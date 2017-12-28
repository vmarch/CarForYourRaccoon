package com.devtolife.carforyourraccoon.cardata;

import com.devtolife.carforyourraccoon.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class CarItemsList {
    private JsonReceiver jr;
    private JSONObject jsonObject;
    private List<CarItemModel> carsList;
    private CarItemModel myCarModel;


    public List<CarItemModel> carItemsList() {

        jr = new JsonReceiver();

        String jsString = jr.getJsonString();
        jsonObject = jr.getDataJsonObj(jsString);
        carsList = new ArrayList<>();

        try {

            JSONArray cars = jsonObject.getJSONArray("cars");

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
        return carsList;
    }

}
