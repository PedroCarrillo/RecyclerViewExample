package com.studyjam.studyjam.recyclerviewexample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PedroCarrillo on 3/30/16.
 */
public class TestRecyclerViewAdapter extends RecyclerView.Adapter<TestRecyclerViewAdapter.TestViewHolder> {

    private List<Note> noteList = new ArrayList<>();
    private RecyclerItemClickListener recyclerItemClickListener;

    public TestRecyclerViewAdapter(List<Note> noteList, RecyclerItemClickListener recyclerItemClickListener) {
        this.noteList = noteList;
        this.recyclerItemClickListener = recyclerItemClickListener;
    }

    @Override
    public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Aqui creamos nuestra vista (a traves del LayoutInflater) y creamos una instancia de nuestro TestViewHolder.
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_row, parent, false);
        return new TestViewHolder(v, recyclerItemClickListener);
    }

    @Override
    public void onBindViewHolder(TestViewHolder holder, int position) {
        // Este metodo es el equivalente a getView de un BaseAdapter. Es llamado cuando se requiere mostrar un row. Acuerdense que se llaman 10 elementos pero se muestran 8.
        final Note note = noteList.get(position);
        holder.tvTitle.setText(note.text);
        holder.tvDescription.setText(note.description);
        holder.itemView.setTag(note);
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    public class TestViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        /**
         *  Este sera nuestro RecyclerView.ViewHolder hecho por nosotros. Este ViewHolder tiene que ser implementado para poder usarlo con el RecyclerView.
         *  No hay una forma facil de hacer un click listener asi que creamos una interface que se encargara de avisarnos cuando se hace un click en un item.
         */

        TextView tvTitle;
        TextView tvDescription;
        RecyclerItemClickListener recyclerItemClickListener;

        public TestViewHolder(View itemView, RecyclerItemClickListener recyclerItemClickListener) {
            super(itemView);
            this.tvTitle = (TextView)itemView.findViewById(R.id.tv_title);
            this.tvDescription = (TextView)itemView.findViewById(R.id.tv_desc);
            this.recyclerItemClickListener = recyclerItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (recyclerItemClickListener != null) {
                // Mandaremos nuestra instancia de viewholder cuando presionemos en un item
                recyclerItemClickListener.onClick(this);
            }
        }
    }

    public interface RecyclerItemClickListener {
        void onClick(RecyclerView.ViewHolder viewHolder);
    }

 }
