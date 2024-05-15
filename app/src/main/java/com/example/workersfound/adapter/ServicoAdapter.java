package com.example.workersfound.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ServicoAdapter.ServicoViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ServicoViewHolder extends RecyclerView.ViewHolder{

        ServicoItemBinding binding;

        public ServicoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


}
