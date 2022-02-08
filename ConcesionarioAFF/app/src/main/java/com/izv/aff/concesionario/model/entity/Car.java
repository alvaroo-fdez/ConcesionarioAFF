package com.izv.aff.concesionario.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Car  implements  Parcelable{

    public int reference;
    public String combustible;
    public int km;
    public String cambio;
    public int potencia;
    public int npuertas;
    public String ano;
    public String color;
    public String titulo;
    public String descripcion;
    public String imagenes;
    public int precio;
    public String localizacion;
    public String url;
    public String [] arrayFotos;

    public Car(int reference, String combustible, int km, String cambio, int potencia, int npuertas, String ano, String color, String titulo, String descripcion, String imagenes, int precio, String localizacion, String url, String[] arrayFotos) {
        this.reference = reference;
        this.combustible = combustible;
        this.km = km;
        this.cambio = cambio;
        this.potencia = potencia;
        this.npuertas = npuertas;
        this.ano = ano;
        this.color = color;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagenes = imagenes;
        this.precio = precio;
        this.localizacion = localizacion;
        this.url = url;
        this.arrayFotos = arrayFotos;
    }

    public Car() {

    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getNpuertas() {
        return npuertas;
    }

    public void setNpuertas(int npuertas) {
        this.npuertas = npuertas;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagenes() {
        return imagenes;
    }

    public void setImagenes(String imagenes) {
        this.imagenes = imagenes;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String[] getArrayFotos() {
        return arrayFotos;
    }

    public void setArrayFotos(String[] arrayFotos) {
        this.arrayFotos = arrayFotos;
    }

    public static Creator<Car> getCREATOR() {
        return CREATOR;
    }

    public Car(Parcel in) {
        reference = in.readInt();
        combustible = in.readString();
        km = in.readInt();
        cambio = in.readString();
        potencia = in.readInt();
        npuertas = in.readInt();
        ano = in.readString();
        color = in.readString();
        titulo = in.readString();
        descripcion = in.readString();
        imagenes = in.readString();
        precio = in.readInt();
        localizacion = in.readString();
        url = in.readString();
        arrayFotos = in.createStringArray();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(reference);
        dest.writeString(combustible);
        dest.writeInt(km);
        dest.writeString(cambio);
        dest.writeInt(potencia);
        dest.writeInt(npuertas);
        dest.writeString(ano);
        dest.writeString(color);
        dest.writeString(titulo);
        dest.writeString(descripcion);
        dest.writeString(imagenes);
        dest.writeInt(precio);
        dest.writeString(localizacion);
        dest.writeString(url);
        dest.writeStringArray(arrayFotos);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };
}

