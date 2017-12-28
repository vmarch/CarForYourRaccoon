package com.devtolife.carforyourraccoon.listpart;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.devtolife.carforyourraccoon.R;
import com.devtolife.carforyourraccoon.cardata.CarItemModel;
import com.devtolife.carforyourraccoon.cardata.CarItemsList;

import java.util.ArrayList;
import java.util.List;

public class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.ViewHolder> {


    private Context context;
    private List<CarItemModel> carsListAdapt;
//    CarItemsList carItemsList;

     RecViewAdapter(Context cont, List<CarItemModel> carsListAdapt) {
        context = cont;
        this.carsListAdapt = carsListAdapt;

    }


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

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        return new ViewHolder(view);


    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        holder.imgListCar.setImageResource(R.drawable.ic_menu_camera);
        holder.tvListCarMake.setText(carsListAdapt.get(position).getCarMake());
        holder.tvListCarModel.setText(carsListAdapt.get(position).getCarModel());
        holder.tvListCarYear.setText(carsListAdapt.get(position).getCarYear());
        holder.tvListCarPrice.setText(carsListAdapt.get(position).getCarPrice());
        holder.tvListCarCountry.setText(carsListAdapt.get(position).getCarCountry());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }



    @Override
    public int getItemCount() {

        return 12;


    }

}
