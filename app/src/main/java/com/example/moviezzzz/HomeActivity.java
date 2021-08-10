package com.example.moviezzzz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.AsyncQueryHandler;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moviezzzz.databinding.ActivityHomeBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding activityHomeBinding;
    private Toolbar toolbar;
    Spinner lss;
    RecyclerView recyclerViews;
    MovieAdapter adapter;
    ArrayList arr;
    ArrayAdapter add;
    String API = "https://jsonkeeper.com/b/YAVF";
    public static List<Datas> valuesh;
    FloatingActionButton mAddFab, mAddmoview;
    TextView addMovietextview;
    boolean isAllFabsVisible;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        activityHomeBinding= DataBindingUtil.setContentView(this,R.layout.activity_home);
        valuesh = new ArrayList<>();
        toolbar = (Toolbar) activityHomeBinding.toolbarMain;
        lss=findViewById(R.id.lss);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("TMDb");
        mAddFab = findViewById(R.id.add_fab);
        mAddmoview = findViewById(R.id.add_movie_fab);
        addMovietextview = findViewById(R.id.add_moview_textview);
        mAddmoview.setVisibility(View.GONE);
        mAddmoview.setVisibility(View.GONE);
        isAllFabsVisible = false;
        recyclerViews = findViewById(R.id.recv);
        recyclerViews.setHasFixedSize(true);
        recyclerViews.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));
        recyclerViews.setHasFixedSize(true);
        arr=new ArrayList();
        arr.add("Action");
        arr.add("Drama");
        arr.add("Comedy");
        add=new ArrayAdapter(HomeActivity.this,android.R.layout.simple_expandable_list_item_1,arr);
        lss.setAdapter(add);
        try
        {
            Thread.sleep(5000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        MyServiceclas myServiceclas = new MyServiceclas();
        myServiceclas.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.search) {
            startActivity(new Intent(this, SearchActivity.class));
        }
        return super.onOptionsItemSelected(item);
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
                valuesh.add(d);
                valuesh.add(d);
                valuesh.add(d);
                valuesh.add(d);
                valuesh.add(d);
                valuesh.add(d);
                valuesh.add(d);
                valuesh.add(d);
                valuesh.add(d);
                valuesh.add(d);

                Log.i("adata", "doInBackground:======" + valuesh.get(0).title);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            getmovies();
        }
    }
    private void getmovies() {
        adapter = new MovieAdapter(this, valuesh);
        recyclerViews.setAdapter(adapter);
    }

    public void fab(View view) {
        if (!isAllFabsVisible) {
            mAddmoview.show();
            addMovietextview.setVisibility(View.VISIBLE);
            isAllFabsVisible = true;
        } else {
            mAddmoview.hide();
            addMovietextview.setVisibility(View.GONE);
            isAllFabsVisible = false;
        }
    }

}