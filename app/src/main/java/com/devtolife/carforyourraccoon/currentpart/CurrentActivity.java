package com.devtolife.carforyourraccoon.currentpart;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.devtolife.carforyourraccoon.R;

public class CurrentActivity extends AppCompatActivity {
    TextView tvCarMake, tvCarModel, tvCarYear, tvCarPrice, tvCarCountry, tvCarCity, tvCarOwner, tvOwnerPhone;
    ImageView imgCurrentCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        imgCurrentCar = (ImageView) findViewById(R.id.image_car);
        tvCarMake = (TextView) findViewById(R.id.tv_car_make);
        tvCarModel = (TextView) findViewById(R.id.tv_car_model);
        tvCarYear = (TextView) findViewById(R.id.tv_car_year);
        tvCarPrice = (TextView) findViewById(R.id.tv_car_price);
        tvCarCountry = (TextView) findViewById(R.id.tv_car_country);
        tvCarCity = (TextView) findViewById(R.id.tv_car_city);
        tvCarOwner = (TextView) findViewById(R.id.tv_car_owner);
        tvOwnerPhone = (TextView) findViewById(R.id.tv_owner_phone);


        fillingOfCarCard();

    }

    public void fillingOfCarCard(){
        System.out.println("fjsdgfdsfksdjfskl");

        imgCurrentCar.setImageResource(R.mipmap.ic_launcher);
        tvCarMake.setText("dddd");
        tvCarModel.setText("dddd");
        tvCarYear.setText("dddd");
        tvCarPrice.setText("dddd");
        tvCarCountry.setText("dddd");
        tvCarCity.setText("dddd");
        tvCarOwner.setText("dddd");
        tvOwnerPhone.setText("dddd");

    }

}
