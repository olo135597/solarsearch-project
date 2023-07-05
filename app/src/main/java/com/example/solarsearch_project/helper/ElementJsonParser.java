package com.example.solarsearch_project.helper;

import com.example.solarsearch_project.models.Element;

import org.json.JSONException;
import org.json.JSONObject;

public class ElementJsonParser {
    public static Element createElementFromJSONString(String elementJsonString) throws
            JSONException {
        Element element = new Element();
        JSONObject jsonObj = new JSONObject(elementJsonString);
        element.setId(jsonObj.getString("elementID"));
        return element;

    }

}