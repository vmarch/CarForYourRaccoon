package com.devtolife.carforyourraccoon.cardata;

public class CarItemModel {


    public int idCar;
    public String urlImage, carMake, carModel, carYear, carPrice, carCountry, carCity, carOwner, ownerPhone, urlVideo;


    public int getIdCar() {
        return idCar;
    }

    public String getCarYear() {
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


    public CarItemModel(int idCar, String urlImage, String carMake, String carModel, String carYear, String carPrice, String carCountry, String carCity, String carOwner, String ownerPhone, String urlVideo) {
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
