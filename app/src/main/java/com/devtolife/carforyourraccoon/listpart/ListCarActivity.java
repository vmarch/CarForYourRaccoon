package com.devtolife.carforyourraccoon.listpart;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.devtolife.carforyourraccoon.R;
import com.devtolife.carforyourraccoon.cardata.CarItemModel;
import com.devtolife.carforyourraccoon.cardata.CarItemsList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ListCarActivity extends AppCompatActivity {

    private RecyclerView appRecyclerView;
    RecViewAdapter appAdapter;
    private RecyclerView.LayoutManager layoutManager;
    Context context;

    private List<CarItemModel> carsList;
    private CarItemModel myCarModel;
    CarItemsList carItemsList;
    public static String LOG_TAG = "my_log";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        new ParseTask().execute();


        appRecyclerView = (RecyclerView) findViewById(R.id.my_rec_view);

        layoutManager = new LinearLayoutManager(this);

        appRecyclerView.setLayoutManager(layoutManager);
        appRecyclerView.getRecycledViewPool().clear();

        appAdapter = new RecViewAdapter(this, carsList);
        appRecyclerView.setAdapter(appAdapter);

    }

    private class ParseTask extends AsyncTask<Void, Void, String> {

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String resultJson = "";

        @Override
        protected String doInBackground(Void... params) {
            // получаем данные с внешнего ресурса
            try {
                URL url = new URL("http://www.mocky.io/v2/5a445bb62e000013337660f4");

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

        @Override
        protected void onPostExecute(String strJson) {
            super.onPostExecute(strJson);
            // выводим целиком полученную json-строку
            Log.d(LOG_TAG, strJson);

            JSONObject dataJsonObj;

            try {
                dataJsonObj = new JSONObject(strJson);
                JSONArray cars = dataJsonObj.getJSONArray("cars");
                carsList = new ArrayList<>();

                for (int i = 0; i < cars.length(); i++) {
                    JSONObject car = cars.getJSONObject(i);


                    myCarModel = new CarItemModel(

                            car.getInt("id"),
                            car.getString("img"),
                            car.getString("car_make"),
                            car.getString("car_model"),
                            car.getInt("car_model_year"),
                            car.getString("price"),
                            car.getString("country"),
                            car.getString("city"),
                            car.getString("first_name") + " " +
                                    car.getString("last_name"),
                            car.getString("phone"),
                            car.getString("url")
                    );
                    carsList.add(myCarModel);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


}
