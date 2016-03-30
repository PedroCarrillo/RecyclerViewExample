package com.studyjam.studyjam.recyclerviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvTest = (RecyclerView) findViewById(R.id.rv_example);
        List<Note> notes = new ArrayList<>();
        notes.add(new Note("title 1", "description 1"));
        notes.add(new Note("title 2", "description 12"));
        notes.add(new Note("title 3", "description 13"));
        notes.add(new Note("title 4", "description 14"));
        notes.add(new Note("title 5", "description 15"));
        notes.add(new Note("title 6", "description 16"));
        notes.add(new Note("title 7", "description 17"));
        notes.add(new Note("title 8", "description 18"));
        notes.add(new Note("title 9", "description 19"));
        notes.add(new Note("title 10", "description 100"));
        notes.add(new Note("title 11", "description 101"));
        notes.add(new Note("title 12", "description 102"));
        notes.add(new Note("title 13", "description 192"));
        notes.add(new Note("title 14", "description 12902"));
        notes.add(new Note("title 15", "description 112"));

        // Empezamos a llenar nuestor Recycler View creando nuestro adaptador.

        TestRecyclerViewAdapter testRecyclerViewAdapter = new TestRecyclerViewAdapter(notes, new TestRecyclerViewAdapter.RecyclerItemClickListener() {
            @Override
            public void onClick(RecyclerView.ViewHolder viewHolder) {
                // Tenemos que asegurarnos que le asignamos el tag en el onBindViewHolder del adaptador
                Note note = (Note) viewHolder.itemView.getTag();
                Toast.makeText(MainActivity.this, "item clicked "+note.text,Toast.LENGTH_LONG).show();
            }
        });
        // Importante setear el LayoutManager.
        rvTest.setLayoutManager(new LinearLayoutManager(this));
        rvTest.setAdapter(testRecyclerViewAdapter);

    }
}
