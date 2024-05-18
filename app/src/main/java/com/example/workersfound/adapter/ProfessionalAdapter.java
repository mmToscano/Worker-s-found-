package com.example.workersfound.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workersfound.databinding.ProfessionalItemBinding;
import com.example.workersfound.model.Professional;

import java.util.ArrayList;

public class ProfessionalAdapter extends RecyclerView.Adapter<ProfessionalAdapter.ProfessionalViewHolder> {

    private final Context context;
    private final ArrayList<Professional> listaProfessionals;


    public ProfessionalAdapter(Context context, ArrayList<Professional> listaProfessionals) {
        this.context = context;
        this.listaProfessionals = listaProfessionals;
    }

    @NonNull
    @Override
    public ProfessionalAdapter.ProfessionalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProfessionalItemBinding listItem;
        listItem = ProfessionalItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ProfessionalViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfessionalAdapter.ProfessionalViewHolder holder, int position) {

        String servicos = "";
        for(String item: listaProfessionals.get(position).getServicos()){
            servicos += item + " ";
        }

        holder.binding.userIcon.setImageResource(listaProfessionals.get(position).getImg());
        holder.binding.userNameTxt.setText(listaProfessionals.get(position).getName());
        holder.binding.userAddressTxt.setText(listaProfessionals.get(position).getCidade());
        holder.binding.userCompanyNameTxt.setText(listaProfessionals.get(position).getCompanyName());
        holder.binding.serviceListTxt.setText(servicos);
    }

    @Override
    public int getItemCount() {
        return listaProfessionals.size();
    }

    public static class ProfessionalViewHolder extends RecyclerView.ViewHolder{

        ProfessionalItemBinding binding;

        public ProfessionalViewHolder(ProfessionalItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
