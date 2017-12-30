package com.devtolife.carforyourraccoon.listpart;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.TextView;

import com.devtolife.carforyourraccoon.cardata.CarItemModel;
import com.devtolife.carforyourraccoon.R;

public class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.ViewHolder> {

    private Context context;
    private CarItemModel[] carArrData;

   static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgListCar;
        TextView tvListCarMake, tvListCarModel, tvListCarYear, tvListCarPrice, tvListCarCountry;

         ViewHolder(View view) {
            super(view);

            imgListCar = (ImageView) view.findViewById(R.id.image_list_car);
            tvListCarMake = (TextView) view.findViewById(R.id.tvlist_car_make);
            tvListCarModel = (TextView) view.findViewById(R.id.tvlist_car_model);
            tvListCarYear = (TextView) view.findViewById(R.id.tvlist_car_year);
            tvListCarPrice = (TextView) view.findViewById(R.id.tvlist_car_price);
            tvListCarCountry = (TextView) view.findViewById(R.id.tvlist_car_country);
        }
    }

    RecViewAdapter(Context cont, CarItemModel[] carsListAdapt) {
        context = cont;
        carArrData = carsListAdapt;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {

        holder.imgListCar.setImageResource(R.mipmap.ic_launcher);
        holder.tvListCarMake.setText(carArrData[i].getCarMake());
        holder.tvListCarModel.setText(carArrData[i].getCarModel());
        holder.tvListCarYear.setText(carArrData[i].getCarYear());
        holder.tvListCarPrice.setText(carArrData[i].getCarPrice());
        holder.tvListCarCountry.setText(carArrData[i].getCarCountry());
    }



    @Override
    public int getItemCount() {
        return carArrData.length;

    }
}
