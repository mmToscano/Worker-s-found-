package com.example.workersfound.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workersfound.databinding.ServicoItemBinding;
import com.example.workersfound.model.Servico;
import com.example.workersfound.view.ProfessionalsListing;

import java.util.ArrayList;

public class ServicoAdapter extends RecyclerView.Adapter<ServicoAdapter.ServicoViewHolder> {

    private final Context context;
    //O home irá renderizar sempre a listaFiltradaServicos. Sempre. O listaServicos serve apenas para guardar mesmo todas as
    //informações dos servicos. Ele serve apenas como banco de dados.
    private final ArrayList<Servico> listaServicos;
    private final ArrayList<Servico> listaFiltradaServicos;

    public ServicoAdapter(Context context, ArrayList<Servico> listaServicos) {
        this.context = context;
        this.listaServicos = listaServicos;
        this.listaFiltradaServicos = new ArrayList<>(listaServicos);
    }

    @NonNull
    @Override
    public ServicoAdapter.ServicoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ServicoItemBinding listItem = ServicoItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ServicoViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ServicoAdapter.ServicoViewHolder holder, int position) {
        Servico currentServico = listaFiltradaServicos.get(position);
        holder.binding.imageIcon.setImageResource(currentServico.getImg());
        holder.binding.serviceTypeTxt.setText(currentServico.getNome());
        holder.binding.cardView.setCardBackgroundColor(currentServico.getCor());
        holder.binding.professionalsQuantityTxt.setText(String.valueOf(currentServico.getProfessionals().size()) + " profissionais em Uberlândia - MG");
    }

    @Override
    public int getItemCount() {
        return listaFiltradaServicos.size();
    }

    public void filter(String searchText) {
        listaFiltradaServicos.clear();
        if (searchText.isEmpty()) {
            listaFiltradaServicos.addAll(listaServicos);
        } else {
            searchText = searchText.toLowerCase();
            for (Servico servico : listaServicos) {
                if (servico.getNome().toLowerCase().contains(searchText)) {
                    listaFiltradaServicos.add(servico);
                }
            }
        }
        notifyDataSetChanged();
    }

    public class ServicoViewHolder extends RecyclerView.ViewHolder {
        ServicoItemBinding binding;

        public ServicoViewHolder(ServicoItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getRoot().setOnClickListener(view -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Intent intent = new Intent(binding.getRoot().getContext(), ProfessionalsListing.class);
                    intent.putExtra("service_type", listaFiltradaServicos.get(position).getNome());
                    binding.getRoot().getContext().startActivity(intent);
                }
            });
        }
    }
}
