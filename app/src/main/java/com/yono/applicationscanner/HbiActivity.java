package com.yono.applicationscanner;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HbiActivity extends AppCompatActivity {

    MenuInflater menuInflater;
    SearchManager searchManager;
    SearchView searchView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_assets);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.dashboard_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.menu_search);
        searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = null;

        if (menuItem != null){
            searchView = (SearchView) menuItem.getActionView();
        }

        if (searchView != null){
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
            searchView.setIconifiedByDefault(false);
            SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    Toast.makeText(getApplicationContext(), "Test 1", Toast.LENGTH_LONG).show();
                    return true;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    Toast.makeText(getApplicationContext(), "Test 2", Toast.LENGTH_LONG).show();
                    return true;
                }
            };

            searchView.setOnQueryTextListener(queryTextListener);
        }

        return super.onCreateOptionsMenu(menu);
    }
}
