package com.devtolife.carforyourraccoon.listpart;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.TextView;


import com.devtolife.carforyourraccoon.R;

import java.util.List;

public class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.CarViewHolder> {

    private Context context;

   static class CarViewHolder extends RecyclerView.ViewHolder {

        ImageView imgListCar;
        TextView tvListCarMake, tvListCarModel, tvListCarYear, tvListCarPrice, tvListCarCountry;


        CarViewHolder(View view) {
            super(view);


            imgListCar = (ImageView) view.findViewById(R.id.image_list_car);
            tvListCarMake = (TextView) view.findViewById(R.id.tvlist_car_make);
            tvListCarModel = (TextView) view.findViewById(R.id.tvlist_car_model);
            tvListCarYear = (TextView) view.findViewById(R.id.tvlist_car_year);
            tvListCarPrice = (TextView) view.findViewById(R.id.tvlist_car_price);
            tvListCarCountry = (TextView) view.findViewById(R.id.tvlist_car_country);

        }
    }

    private List<CarItemModel> carsListAdapt;
    RecViewAdapter(Context cont, List<CarItemModel> carsListAdapt) {
        context = cont;
        this.carsListAdapt = carsListAdapt;
    }

    @Override
    public int getItemCount() {
//        return carsListAdapt.size();
        return 16;
    }

    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CarViewHolder holder, int position) {

        holder.imgListCar.setImageResource(R.drawable.ic_menu_camera);
        holder.tvListCarMake.setText(carsListAdapt.get(position).carMake);
        holder.tvListCarModel.setText(carsListAdapt.get(position).carModel);
        holder.tvListCarYear.setText(carsListAdapt.get(position).carYear);
        holder.tvListCarPrice.setText(carsListAdapt.get(position).carPrice);
        holder.tvListCarCountry.setText(carsListAdapt.get(position).carCountry);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


}
