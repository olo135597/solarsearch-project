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

                JSONArray moonsArray = jsonElement.optJSONArray("moons");
                if (moonsArray != null) {
                    String[] moons = new String[moonsArray.length()];
                    for (int j = 0; j < moonsArray.length(); j++) {
                        JSONObject moonObj = moonsArray.getJSONObject(j);
                        moons[j] = moonObj.getString("moon");
                    }
                    element.setMoons(moons);
                } else {
                    // Handle the case when the "moons" field is missing or null
                    // You can set a default value or handle it as needed
                    element.setMoons(new String[] {"Unknown"}); // Set an empty array or any other default value
                }

                String englishName = jsonElement.getString("englishName");
                if (englishName != null && !englishName.isEmpty()) {
                    element.setName(englishName);
                } else {
                    element.setName("Unknown");
                }

                JSONObject massObj = jsonElement.optJSONObject("mass");
                double massValue = massObj != null ? massObj.optDouble("massValue", 0.0) : 0.0;
                int massExponent = massObj != null ? massObj.optInt("massExponent", 0) : 0;
                element.setMassValue(massValue);
                element.setMassExponent(massExponent);

                double gravity = jsonElement.optDouble("gravity", 0.0);
                element.setGravity(gravity);

                double density = jsonElement.optDouble("density", 0.0);
                element.setDensity(density);

                int polarRadius = jsonElement.optInt("polarRadius", 0);
                element.setPolarRadius(polarRadius);

                int equaRadius = jsonElement.optInt("equaRadius", 0);
                element.setEquaRadius(equaRadius);

                String discoveredBy = jsonElement.getString("discoveredBy");
                if (discoveredBy != null && !discoveredBy.isEmpty()) {
                    element.setDiscoveredBy(discoveredBy);
                } else {
                    element.setDiscoveredBy("Unknown");
                }

                String discoveryDate = jsonElement.getString("discoveryDate");
                if (discoveryDate != null && !discoveryDate.isEmpty()) {
                    element.setDiscoveryDate(discoveryDate);
                } else {
                    element.setDiscoveryDate("Unknown");
                }

                String bodyType = jsonElement.getString("bodyType");
                if (bodyType != null && !bodyType.isEmpty()) {
                    element.setBodyType(bodyType);
                } else {
                    element.setBodyType("Unknown");
                }

                elementList.add(element);
            }
        }
        return elementList;
    }
}
