package com.example.moviezzzz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MovieAdapter adapter;
    SearchView searchView;
    List<Datas> values;
    String API = "https://jsonkeeper.com/b/NG16";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        recyclerView = findViewById(R.id.RecyclerViews);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        searchView = findViewById(R.id.searchBar);
        searchView.onActionViewExpanded();
        values = new ArrayList<>();
        MyServiceclas myServiceclas = new MyServiceclas();
        myServiceclas.execute();
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


    private class MyServiceclas extends AsyncTask {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected Object doInBackground(Object[] objects) {
            GetMovie getMovie = new GetMovie();
            String resut = getMovie.makeServiceCall(API);
            try {
                JSONObject wholeobj = new JSONObject(resut);
                String s1 = wholeobj.getString("Title");
                String s2 = wholeobj.getString("Rating");
                Datas d = new Datas(s1, s2);
                Log.i("shiv", "doInBackground: ");
                values.add(d);
                values.add(d);
                values.add(d);
                values.add(d);
                values.add(d);
                values.add(d);
                values.add(d);
                values.add(d);
                values.add(d);
                values.add(d);
                Log.i("adata", "doInBackground:======" + values.get(0).title);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }


    }
    private void getmovies() {
        adapter = new MovieAdapter(this, values);
        recyclerView.setAdapter(adapter);
    }
}