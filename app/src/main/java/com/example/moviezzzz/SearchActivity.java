package com.example.moviezzzz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MovieAdapter adapter;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        searchView=findViewById(R.id.searchBar);
        searchView.onActionViewExpanded();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                getmovies();
                //Here u can get the value "query" which is entered in the search box.
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //This is your adapter that will be filtered
                return false;
            }
        });
    }

    private void getmovies() {
        adapter = new MovieAdapter(getApplicationContext());
        recyclerView.setAdapter(adapter);
    }

}