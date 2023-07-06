package com.example.solarsearch_project.helper;

import android.util.Log;

import com.example.solarsearch_project.models.Element;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ElementJsonParser {
 public static ArrayList<Element> createElementFromJsonString(String elementJsonString) throws JSONException {

     ArrayList<Element> elements = new ArrayList<>();

     JSONObject jsonObj = new JSONObject(elementJsonString);
     JSONArray bodies = jsonObj.getJSONArray("bodies");
     if (bodies != null) {
         for (int i=0;i<bodies.length();i++){
             JSONObject jsonElement = new JSONObject(bodies.getString(i));

             Element element = new Element();
             element.setId(jsonElement.getString("id"));
             element.setName(jsonElement.getString("englishName"));
             elements.add(element);

         }
     }

     return elements;
 }
}
