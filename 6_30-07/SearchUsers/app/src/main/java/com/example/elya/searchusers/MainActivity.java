package com.example.elya.searchusers;


import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final List<User> users = new ArrayList<>();

        initUsersList(users);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(manager);

        adapter = new MyAdapter(users, this);
        recyclerView.setAdapter(adapter);

    }

    private void initUsersList(List<User> users) {
        users.add(new User(getString(R.string.vahan), "Vahan", "description", "mail.ru", "0955555", 2.3f));
        users.add(new User(getString(R.string.astghik), "Astghik", "description", "mail.ru", "0955555", 2.3f ));
        users.add(new User(getString(R.string.vahan), "Vahan", "description", "mail.ru", "0955555", 2.3f));
        users.add(new User(getString(R.string.astghik), "Astghik1", "description", "mail.ru", "0955555", 2.3f));
        users.add(new User(getString(R.string.vahan), "Vahan", "description", "mail.ru", "0955555", 2.3f));
        users.add(new User(getString(R.string.astghik), "Astghik2", "description", "mail.ru", "0955555", 2.3f));
        users.add(new User(getString(R.string.vahan), "Vahan", "description", "mail.ru", "0955555", 2.3f));
        users.add(new User(getString(R.string.astghik), "Astghik3", "description", "mail.ru", "0955555", 2.3f));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//
//                return true;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//                adapter.getFilter().filter(s);
//                adapter.notifyDataSetChanged();
//                return false;
//            }
//        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}