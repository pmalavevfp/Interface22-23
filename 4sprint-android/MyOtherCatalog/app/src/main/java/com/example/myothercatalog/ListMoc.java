package com.example.myothercatalog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListMoc {
    private List<Moc_Comic> comics;

    public ListMoc(JSONArray array)  {
       comics= new ArrayList<>();

        for (int i=0; i< array.length();i++){

            try {
                JSONObject jsonElement = array.getJSONObject(i);
                Moc_Comic aClip =new Moc_Comic(jsonElement);
                comics.add(aClip);
            }catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public List<Moc_Comic> getMoc_Comic() {
        return comics;
    }
}
