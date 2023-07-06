package com.example.solarsearch_project.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.solarsearch_project.R;
import com.example.solarsearch_project.databinding.FragmentDetailBinding;
import com.example.solarsearch_project.helper.ElementDetailJsonParser;
import com.example.solarsearch_project.helper.ElementJsonParser;
import com.example.solarsearch_project.models.Element;
import com.example.solarsearch_project.ui.search.SearchFragment;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;


public class DetailFragment extends Fragment {

    private String elementId;
    private static String FULL_SOLAR_API = "https://api.le-systeme-solaire.net/rest.php/bodies";



    private FragmentDetailBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DetailViewModel detailViewModel =
                new ViewModelProvider(this).get(DetailViewModel.class);

        binding = FragmentDetailBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        String Detail_Infos_Link = getArguments().getString("detailInfosLink");
        Log.e("ID", Detail_Infos_Link);

        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Detail_Infos_Link,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            ArrayList<Element> elementList = ElementDetailJsonParser.createElementFromJsonString(response);

                            if (!elementList.isEmpty()) {
                                // Get the first element from the list
                                Element element = elementList.get(0);

                                // Find the TextView elements in your XML layout by their IDs
                                TextView elementNameTextView = getView().findViewById(R.id.elementName);
                                TextView moonsTextView = getView().findViewById(R.id.moons);
                                TextView massValueTextView = getView().findViewById(R.id.massValue);
                                TextView massExponentTextView = getView().findViewById(R.id.massExponent);
                                TextView gravityTextView = getView().findViewById(R.id.gravity);
                                TextView densityTextView = getView().findViewById(R.id.density);
                                TextView polarRadiusTextView = getView().findViewById(R.id.polarRadius);
                                TextView equaRadiusTextView = getView().findViewById(R.id.equaRadius);
                                TextView discoveredByTextView = getView().findViewById(R.id.discoveredBy);
                                TextView discoveryDateTextView = getView().findViewById(R.id.discoveryDate);
                                TextView bodyTypeTextView = getView().findViewById(R.id.bodyType);


                                // Set the values from the parsed element to the corresponding TextViews
                                elementNameTextView.setText(String.valueOf(element.getName()));
                                moonsTextView.setText(TextUtils.join(", ", element.getMoons()));
                                massValueTextView.setText(String.valueOf(element.getMassValue()));
                                massExponentTextView.setText(String.valueOf(element.getMassExponent()));
                                gravityTextView.setText(String.valueOf(element.getGravity()));
                                densityTextView.setText(String.valueOf(element.getDensity()));
                                polarRadiusTextView.setText(String.valueOf(element.getPolarRadius()));
                                equaRadiusTextView.setText(String.valueOf(element.getEquaRadius()));
                                discoveredByTextView.setText(String.valueOf(element.getDiscoveredBy()));
                                discoveryDateTextView.setText(String.valueOf(element.getDiscoveryDate()));
                                bodyTypeTextView.setText(String.valueOf(element.getBodyType()));
                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("ErrorvomAPIFetchSolar", error.toString());
                    }
                }
        );
        queue.add(stringRequest);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}