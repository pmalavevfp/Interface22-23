package com.example.myothercatalog;

import org.json.JSONException;
import org.json.JSONObject;

public class Comics {
    //private int id;
    private String photoName;
    private String photoUrl;
    private String photoDescrip;

    public Comics (){}
    public Comics (String photoName,String photoUrl,String photoDescrip){
        this.photoName = photoName;
        this.photoUrl = photoUrl;
        this.photoDescrip= photoDescrip;

    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPhotoDescrip() {
        return photoDescrip;
    }

    public void setPhotoDescrip(String photoDescrip) {
        this.photoDescrip = photoDescrip;
    }
}
