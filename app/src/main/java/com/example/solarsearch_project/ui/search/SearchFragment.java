package com.example.solarsearch_project.ui.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.solarsearch_project.databinding.FragmentSearchBinding;
import com.example.solarsearch_project.helper.ElementJsonParser;
import com.example.solarsearch_project.models.Element;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class SearchFragment extends Fragment {

    private FragmentSearchBinding binding;
    private static final String Solar_API_ID = "https://api.le-systeme-solaire.net/rest/bodies/";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SearchViewModel searchViewModel =
                new ViewModelProvider(this).get(SearchViewModel.class);

        binding = FragmentSearchBinding.inflate(inflater, container, false);
        View root = binding.getRoot();





        return root;



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

   /* private void addElementClickableList(String url) {
        ListView listElements = binding.listElements;
        final ArrayAdapter<Element> elementArrayAdapter = new
                ArrayAdapter<>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1);
        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                 @Override
                    public void onResponse(String response) {

                     Element element = null;
                     try {
                         element = ElementJsonParser.createElementFromJsonString(response);
                     } catch (JSONException e) {
                         throw new RuntimeException(e);
                     }
                     elementArrayAdapter.addAll(element.getId());
                         listElements.setAdapter(elementArrayAdapter);

                 }
                });




    }*/


}