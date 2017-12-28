package com.devtolife.carforyourraccoon.cardata;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonReceiver {

    private static final String CAR_BASE_API =
            "http://www.mocky.io/v2/5a4405702e00004726766083";

    public static String LOG_TAG = "my_log";

    HttpURLConnection urlConnection = null;
    BufferedReader reader = null;
    String resultJson = "";
    JSONObject dataJsonObj;

    public String getJsonString() {
        try {
            URL url = new URL(CAR_BASE_API);

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();

            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            resultJson = buffer.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultJson;
    }

    public JSONObject getDataJsonObj(String resultJson) {


        Log.d(LOG_TAG, resultJson);
        dataJsonObj = null;

        try {
            dataJsonObj = new JSONObject(resultJson);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return dataJsonObj;
    }
}