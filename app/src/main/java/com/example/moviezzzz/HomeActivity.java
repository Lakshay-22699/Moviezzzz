package com.example.moviezzzz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.moviezzzz.databinding.ActivityHomeBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding activityHomeBinding;
    //comment
    private Toolbar toolbar;
    RecyclerView recyclerView;
    MovieAdapter adapter;
    FloatingActionButton mAddFab, mAddmoview;
    TextView addMovietextview;
    boolean isAllFabsVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        activityHomeBinding= DataBindingUtil.setContentView(this,R.layout.activity_home);
//        toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        toolbar = (Toolbar) activityHomeBinding.toolbarMain;
//        setSupportActionBar(toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("TMDb");

        mAddFab = findViewById(R.id.add_fab);
        mAddmoview = findViewById(R.id.add_movie_fab);
        addMovietextview = findViewById(R.id.add_moview_textview);

        mAddmoview.setVisibility(View.GONE);
        mAddmoview.setVisibility(View.GONE);
        //addMovietextview.setVisibility(View.GONE);
        isAllFabsVisible = false;

//        recyclerView = findViewById(R.id.RecyclerView);
        activityHomeBinding.RecyclerView.setHasFixedSize(true);
        activityHomeBinding.RecyclerView.setLayoutManager(new LinearLayoutManager(this));
        getmovies();
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

    private void getmovies() {

        adapter = new MovieAdapter(getApplicationContext());
        activityHomeBinding.RecyclerView.setAdapter(adapter);
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