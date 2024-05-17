package com.example.workersfound.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workersfound.databinding.ServicoItemBinding;
import com.example.workersfound.model.Servico;

import java.util.ArrayList;

public class ServicoAdapter extends RecyclerView.Adapter<ServicoAdapter.ServicoViewHolder> {

    private final Context context;
    private final ArrayList<Servico> listaServicos;


    public ServicoAdapter(Context context, ArrayList<Servico> listaServicos) {
        this.context = context;
        this.listaServicos = listaServicos;
    }

    @NonNull
    @Override
    public ServicoAdapter.ServicoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ServicoItemBinding listItem;
        listItem = ServicoItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ServicoViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ServicoAdapter.ServicoViewHolder holder, int position) {
        holder.binding.imageIcon.setImageResource(listaServicos.get(position).getImg());
        holder.binding.serviceTypeTxt.setText(listaServicos.get(position).getNome());
        holder.binding.cardView.setCardBackgroundColor(listaServicos.get(position).getCor());
        holder.binding.professionalsQuantityTxt.setText(String.valueOf(listaServicos.get(position).getProfessionals().size()) + " profissionais em Uberlândia - MG");
    }

    @Override
    public int getItemCount() {
        return listaServicos.size();
    }

    public static class ServicoViewHolder extends RecyclerView.ViewHolder{

        ServicoItemBinding binding;

        public ServicoViewHolder(ServicoItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
