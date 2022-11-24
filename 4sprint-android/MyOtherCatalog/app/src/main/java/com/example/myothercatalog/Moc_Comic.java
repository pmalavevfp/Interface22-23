package com.example.myothercatalog;

import org.json.JSONException;
import org.json.JSONObject;

public class Moc_Comic {
    private int id;
    private String photoName;
    private String urlPhoto;
    private String photoDescrip;


    public Moc_Comic (JSONObject json) throws JSONException {


        //this.id= json.getInt("id");
        this.photoName = json.getString("name");
        this.urlPhoto = json.getString("videoUrl");
        this.photoDescrip= json.getString("photoDescrip");

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhotoTitle() {
        return photoName;
    }

    public void setPhotoTitle(String photoName) {
        this.photoName = photoName;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public String getPhotoDescrip() {
        return photoDescrip;
    }

    public void setPhotoDescrip(String photoDescrip) {
        this.photoDescrip = photoDescrip;
    }
}
