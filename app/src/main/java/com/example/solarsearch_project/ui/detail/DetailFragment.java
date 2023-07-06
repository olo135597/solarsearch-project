package com.example.solarsearch_project.ui.detail;

import android.content.Intent;
import android.os.Bundle;
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
import com.example.solarsearch_project.databinding.FragmentDetailBinding;
import com.example.solarsearch_project.helper.ElementJsonParser;
import com.example.solarsearch_project.models.Element;
import com.example.solarsearch_project.ui.search.SearchFragment;

import org.json.JSONException;
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

        return root;
    }

    private void addElementClickableList(String url) {
        TextView moons = binding.moons;
        TextView massValue = binding.massValue;
        TextView massExponent = binding.massExponent;
        TextView gravity = binding.gravity;
        TextView density = binding.density;
        TextView polarRadius = binding.polarRadius;
        TextView equaRadius = binding.equaRadius;
        TextView discoveredBy = binding.discoveredBy;
        TextView discoveryDate = binding.discoveryDate;
        TextView bodyType = binding.bodyType;
    }

    /*RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
    StringRequest stringRequest = new StringRequest(Request.Method.GET, Deta,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    try {
                        ArrayList<Element> elements = ElementJsonParser.createElementFromJsonString(response);
                        elementArrayAdapter.addAll(elements);
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
        queue.add(stringRequest);*/

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}