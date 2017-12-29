package com.devtolife.carforyourraccoon.listpart;

public class CarItemModel {


   int idCar, carYear;
   String urlImage, carMake, carModel, carPrice, carCountry, carCity, carOwner, ownerPhone, urlVideo;


   public CarItemModel(int idCar, String urlImage, String carMake, String carModel, int carYear, String carPrice, String carCountry, String carCity, String carOwner, String ownerPhone, String urlVideo) {
        this.idCar = idCar;
        this.urlImage = urlImage;
        this.carMake = carMake;
        this.carModel = carModel;
        this.carYear = carYear;
        this.carPrice = carPrice;
        this.carCountry = carCountry;
        this.carCity = carCity;
        this.carOwner = carOwner;
        this.ownerPhone = ownerPhone;
        this.urlVideo = urlVideo;
    }

}
