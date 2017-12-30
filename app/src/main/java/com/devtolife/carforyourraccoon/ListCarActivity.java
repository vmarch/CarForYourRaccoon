package com.devtolife.carforyourraccoon;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class ListCarActivity extends AppCompatActivity {

    Context context;
    private RecyclerView appRecyclerView;

    public static CarItemModel getMyCarModel() {
        return myCarModel;
    }

    public void setMyCarModel(CarItemModel myCarModel) {
        this.myCarModel = myCarModel;
    }

    static CarItemModel myCarModel;
   public CarItemModel[] carArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        context = getApplicationContext();

        appRecyclerView = (RecyclerView) findViewById(R.id.my_rec_view);
        appRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);

        appRecyclerView.setLayoutManager(mLayoutManager);
        appRecyclerView.getRecycledViewPool().clear();

        new ParseTask().execute();

    }


    @SuppressLint("StaticFieldLeak")
    private class ParseTask extends AsyncTask<Void, Void, String> {

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String resultJson = "";

        @Override
        protected String doInBackground(Void... params) {

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

            System.out.println(strJson);

            JSONObject jo = null;

            try {
                jo = new JSONObject(strJson);

                JSONArray cars = jo.getJSONArray("cars");

                JSONObject car;

                carArray = new CarItemModel[cars.length()];

                for (int i = 0; i < cars.length(); i++) {
                    car = cars.getJSONObject(i);

                    CarItemModel carModel = new CarItemModel(
                            car.getInt("id"),
                            car.getString("img"),
                            car.getString("car_make"),
                            car.getString("car_model"),
                            car.getString("car_model_year"),
                            car.getString("price"),
                            car.getString("country"),
                            car.getString("city"),
                            car.getString("first_name") + " " +
                                    car.getString("last_name"),
                            car.getString("phone"),
                            car.getString("url")

                    );
                    carArray[i] = carModel;
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }


            final RecViewAdapter appAdapter = new RecViewAdapter(context, carArray);
            appRecyclerView.setAdapter(appAdapter);

            appRecyclerView.addOnItemTouchListener(new RecyclerClickListener(context) {
                @Override
                public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
                }

                @Override
                public void onItemClick(RecyclerView recyclerView, View itemView,
                                        int position) {

                    Intent intent;
                    intent = new Intent(context, CurrentActivity.class);
                    setMyCarModel(carArray[position]);


//                    System.out.println(position +", " + + appRecyclerView.getChildLayoutPosition(itemView) +", " + carArray[position]);

//                    intent.putExtra("POSITION_OF_ITEM", position);

//
//
//                    ArrayList<CarItemModel> fileList = new ArrayList<CarItemModel>();
//                    fileList.add(carArray[position]);
//

                    startActivity(intent);
                }
            });


        }
    }

}

