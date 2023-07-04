package com.example.solarsearch_project.helper;

import com.example.solarsearch_project.models.Picture;

import org.json.JSONException;
import org.json.JSONObject;

public class PictureJsonParser {
    public static Picture createElementFromJSONString(String pictureJsonString) throws
            JSONException {
        Picture picture = new Picture();
        JSONObject jsonObj = new JSONObject(pictureJsonString);
        picture.setUrl(jsonObj.getString("pictureURL"));
        return picture;

    }

}
