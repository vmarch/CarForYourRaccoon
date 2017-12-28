package com.devtolife.carforyourraccoon.currentpart;

import android.util.Log;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


class CarItemCurrent {

    public static void gettingOfCarData(JSONObject json) {

        try {
//            cityField.setText(json.getString("name").toUpperCase(Locale.US) +
//                    ", " + json.getJSONObject("sys").getString("country") + " |");
//
//            JSONObject details = json.getJSONArray("weather").getJSONObject(0);
//            JSONObject main = json.getJSONObject("main");
//            JSONObject wind = json.getJSONObject("wind");
//
//            setWeatherIcon(details.getInt("id"), dayTime);
//
//            weatherIcon.setImageResource(icon);
//            temperField.setText(String.format("%.2f", main.getDouble("temp")) + "℃");
//            cloudsField.setText(details.getString("description").toUpperCase(Locale.US) + "");
//            humidityField.setText(main.getString("humidity") + "%");
//            pressureField.setText(main.getString("pressure") + " hPa");
//            windField.setText(wind.getString("speed") + " m/c");
//            dateField.setText(new SimpleDateFormat("dd.MM").format(new Date()));

        } catch (Exception e) {
            Log.e("SimpleWeather", "One or more fields not found in the JSON data");
        }
    }

}
