package com.devtolife.carforyourraccoon.cardata;

public class CarItemModel {


   private int idCar, carYear;
   private String urlImage, carMake, carModel, carPrice, carCountry, carCity, carOwner, ownerPhone, urlVideo;


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

    public int getIdCar() {
        return idCar;
    }

    public int getCarYear() {
        return carYear;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public String getCarMake() {
        return carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getCarPrice() {
        return carPrice;
    }

    public String getCarCountry() {
        return carCountry;
    }

    public String getCarCity() {
        return carCity;
    }

    public String getCarOwner() {
        return carOwner;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public String getUrlVideo() {
        return urlVideo;
    }
}
