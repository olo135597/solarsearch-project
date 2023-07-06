package com.example.solarsearch_project.helper;

import com.example.solarsearch_project.models.Element;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ElementDetailJsonParser {
    public static ArrayList<Element> createElementFromJsonString(String elementJsonString) throws JSONException {
        ArrayList<Element> elementList = new ArrayList<>();

        JSONObject jsonObj = new JSONObject(elementJsonString);
        JSONArray bodies = jsonObj.getJSONArray("bodies");
        if (bodies != null) {

            for (int i = 0; i < bodies.length(); i++) {
                JSONObject jsonElement = bodies.getJSONObject(i);


                Element element = new Element();
                element.setId(jsonElement.getString("id"));

                JSONArray moonsArray = jsonElement.getJSONArray("moons");
                if (moonsArray != null) {
                    String[] moons = new String[moonsArray.length()];
                    for (int j = 0; j < moonsArray.length(); j++) {
                        JSONObject moonObj = moonsArray.getJSONObject(j);
                        moons[j] = moonObj.getString("moon");
                    }
                    element.setMoons(moons);
                }

                JSONObject massObj = jsonElement.getJSONObject("mass");
                double massValue = massObj.getDouble("massValue");
                int massExponent = massObj.getInt("massExponent");
                element.setMassValue(massValue);
                element.setMassExponent(massExponent);

                element.setGravity(jsonElement.getDouble("gravity"));
                element.setDensity(jsonElement.getDouble("density"));
                element.setPolarRadius(jsonElement.getInt("polarRadius"));
                element.setEquaRadius(jsonElement.getInt("equaRadius"));
                element.setDiscoveredBy(jsonElement.getString("discoveredBy"));
                element.setDiscoveryDate(jsonElement.getString("discoveryDate"));
                element.setBodyType(jsonElement.getString("bodyType"));

                elementList.add(element);
            }
        }
        return elementList;
    }
}
