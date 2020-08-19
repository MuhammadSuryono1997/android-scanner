package com.yono.applicationscanner;


import android.app.SearchManager;
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

import com.google.android.material.card.MaterialCardView;
import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    CarouselView carouselView;

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
        setContentView(R.layout.activity_main);

        menuBmn = findViewById(R.id.manu_bmn);
        menuHbi = findViewById(R.id.menu_hbi);
        menuKkks = findViewById(R.id.menu_kkks);
        menuLogUpdate = findViewById(R.id.menu_log);
        menuScan = findViewById(R.id.menu_scanner);

        registerReceiver(new NetworckChecker(), new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));

        sharedPreferences = getSharedPreferences(MY_SHARED_STATUS, Context.MODE_PRIVATE);
        status_login = sharedPreferences.getBoolean(STATUS_LOGIN, false);

        if (!status_login){
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

        carouselImage();
        actionMenu();

    }

    private void actionMenu() {
        menuHbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, HbiActivity.class));
            }
        });

        menuBmn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Utils().PesanToast(MainActivity.this, R.string.app_name);
            }
        });

        menuKkks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Utils().PesanToast(MainActivity.this, R.string.app_name);
            }
        });

        menuLogUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Utils().PesanToast(MainActivity.this, R.string.app_name);
            }
        });

        menuScan.setOnClickListener(new View.OnClickListener() {
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