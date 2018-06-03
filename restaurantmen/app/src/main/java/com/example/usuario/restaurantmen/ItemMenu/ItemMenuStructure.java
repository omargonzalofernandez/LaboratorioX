package com.example.usuario.restaurantmen.ItemMenu;

import android.graphics.Bitmap;

public class ItemMenuStructure {
    private String poster;
    private String foodname;
    private String quantity;
    private Bitmap img;
    private Boolean deleteui;
    private String urlimg;
    private String id;
    public ItemMenuStructure (String poster, String foodname, String quantity, String id) {
        this.poster = poster;
        this.foodname = foodname;
        this.quantity = quantity;
        this.urlimg=urlimg;
        this.id = id;
    }
    public void setImg(Bitmap img) {
        this.img=img;
    }

    public String getPoster(){

        return this.poster;
    }
    public void setQuantity (String c){
        this.quantity=c;
    }
    public void setDeleteui(Boolean deleteui){
        this.deleteui=deleteui;

    }
    public String  getUrlimg() {
        return this.urlimg;
    }
    public Bitmap getImg() {
        return this.img;
    }
    public String getFoodname()
    {
        return this.foodname;
    }
    public String getQuantity() {

        return this.quantity;
    }

    public String getId() {
        return this.id;
    }

    public Boolean getDeleteui() {
        return this.deleteui;
    }
    //public String getIdimdb ()
    //{
    //  return this.idimdb;
    //}
}
