package com.yono.applicationscanner;


import android.app.SearchManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;
import com.yono.applicationscanner.databinding.ActivityMainBinding;
import com.yono.applicationscanner.mvv.adapter.ExampleAdapter;
import com.yono.applicationscanner.mvv.models.ExampleMainViewModels;
import com.yono.applicationscanner.mvv.response.ExampleResponse;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    CarouselView carouselView;
    ActivityMainBinding binding;
    ExampleMainViewModels viewModels;
    ExampleAdapter adapter;

    MaterialCardView menuBmn, menuHbi, menuKkks, menuLogUpdate, menuScan;

    String[] data = {
            "https://www.pertamina.com/Media/Image/post/IMG-20180712-WA0003.jpg",
            "https://www.pertamina.com/media/021dbc52-738d-401f-8542-2dfe73164fd4/Area%20geothermal%20kemojang2.jpg",
            "https://www.pertamina.com/media/31c8e548-60a6-461c-adc7-d228c001d8af/Aktifitas%20Pengeboran.jpg",
            "https://www.pertamina.com/Media/Image/gallery/PGE_Pertamina_Kamojang.jpg"
    };

    public static final String MY_SHARED_STATUS = "my_shared_status";
    public static final String STATUS_LOGIN = "status_login";
    public static Boolean status_login;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        registerReceiver(new NetworckChecker(), new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));

        sharedPreferences = getSharedPreferences(MY_SHARED_STATUS, Context.MODE_PRIVATE);
        status_login = sharedPreferences.getBoolean(STATUS_LOGIN, false);

        if (!status_login){
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

        carouselImage();
        actionMenu();
        getDataLastUpdate();

    }

    private void getDataLastUpdate() {
        viewModels = ViewModelProviders.of(this).get(ExampleMainViewModels.class);
        viewModels.getExampleResponse().observe(this, new Observer<ArrayList<ExampleResponse>>() {
            @Override
            public void onChanged(ArrayList<ExampleResponse> exampleResponses) {
                ArrayList<ExampleResponse> exampleResponseArrayList = exampleResponses;
                adapter = new ExampleAdapter(getApplicationContext(), exampleResponseArrayList);
                binding.rvLastUpdateDashboard.setAdapter(adapter);
                binding.rvLastUpdateDashboard.setLayoutManager(
                        new LinearLayoutManager(getApplicationContext(),
                                LinearLayoutManager.HORIZONTAL, false)
                );

            }
        });
    }

    private void actionMenu() {

        binding.menuHbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, HbiActivity.class));
            }
        });

        binding.manuBmn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Utils().PesanToast(MainActivity.this, R.string.app_name);
            }
        });

        binding.menuKkks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Utils().PesanToast(MainActivity.this, R.string.app_name);
            }
        });

        binding.menuLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Utils().PesanToast(MainActivity.this, R.string.app_name);
            }
        });

        binding.menuScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ScannerActivity.class));
            }
        });

    }

    private void carouselImage() {
        carouselView = findViewById(R.id.carousel_image);
        carouselView.setPageCount(data.length);
        carouselView.setImageListener(imageListener);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            Picasso.get().load(data[position]).into(imageView);
        }
    };


}