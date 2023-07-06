package com.example.solarsearch_project.ui.search;

import static androidx.navigation.fragment.FragmentKt.findNavController;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.solarsearch_project.R;
import com.example.solarsearch_project.databinding.FragmentSearchBinding;
import com.example.solarsearch_project.helper.ElementJsonParser;
import com.example.solarsearch_project.models.Element;
import com.example.solarsearch_project.ui.detail.DetailFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {



    private static final String Solar_API_ID = "https://api.le-systeme-solaire.net/rest.php/bodies?data=englishName%2Cid";


    String Detail_Infos_Link = "";

    private String Solar_API_ID_CATEGORY = "https://api.le-systeme-solaire.net/rest.php/bodies?filter%5B%5D=bodyType%2Ceq%2C";

    private String finalUrl = "";

    private FragmentSearchBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        SearchViewModel searchViewModel =
                new ViewModelProvider(this).get(SearchViewModel.class);



        NavController controller = findNavController(this);
        NavDestination destination = controller.getCurrentDestination();
        if(destination != null) {
            int destinationId = destination.getId();





            if(destinationId == R.id.nav_search_dwarfs) {
                Log.e("Wir sind auf Search", "Aber mit dem Filter Zwergplaneten");
                finalUrl = Solar_API_ID_CATEGORY + "Dwarf Planet";
                Detail_Infos_Link = Solar_API_ID_CATEGORY + "Dwarf Planet" + "&filter%5B%5D=id%2Ceq%2C";
                Log.e("search", finalUrl);
            }

            if (destinationId == R.id.nav_search_planets) {
                Log.e("We are on planet Sylva", "planet");
                finalUrl = Solar_API_ID_CATEGORY + "Planet";
                Detail_Infos_Link = Solar_API_ID_CATEGORY + "Planet" + "&filter%5B%5D=id%2Ceq%2C";
                Log.e("planet", finalUrl);
            }

            if(destinationId == R.id.nav_search_comets) {
                Log.e("Comet", "Comet");
                finalUrl = Solar_API_ID_CATEGORY + "Comet";
                Detail_Infos_Link = Solar_API_ID_CATEGORY + "Comet" + "&filter%5B%5D=id%2Ceq%2C";
                Log.e("comet", finalUrl);
            }

            if(destinationId == R.id.nav_search_stars) {
                Log.e("star", "star");
                finalUrl = Solar_API_ID_CATEGORY + "Star";
                Detail_Infos_Link = Solar_API_ID_CATEGORY + "Star" + "&filter%5B%5D=id%2Ceq%2C";
                Log.e("star", finalUrl);
            }

            if(destinationId == R.id.nav_search_moons) {
                Log.e("moon", "moon");
                finalUrl = Solar_API_ID_CATEGORY + "Moon";
                Detail_Infos_Link = Solar_API_ID_CATEGORY + "Moon" + "&filter%5B%5D=id%2Ceq%2C";
                Log.e("moon", finalUrl);
            }

            if (destinationId == R.id.nav_search){
                finalUrl = Solar_API_ID;
                Log.e("main", finalUrl);
                Detail_Infos_Link = "https://api.le-systeme-solaire.net/rest.php/bodies?filter%5B%5D=id%2Ceq%2C";
            }
        }


        binding = FragmentSearchBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        addElementClickableList(finalUrl);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void addElementClickableList(String url) {
        ListView listElements = binding.listElements;
        final ArrayAdapter<Element> elementArrayAdapter = new
                ArrayAdapter<>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1);
        listElements.setAdapter(elementArrayAdapter);

        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {

                Element selected = (Element) parent.getItemAtPosition(position);

                String Id = selected.getId();
                String Detail_Infos_Link = "https://api.le-systeme-solaire.net/rest.php/bodies?filter%5B%5D=id%2Ceq%2C" + Id;

                Bundle b = new Bundle();
                b.putString("detailInfosLink", Detail_Infos_Link);
                Navigation.findNavController(v).navigate(R.id.toSearch, b);
            }

        };
        listElements.setOnItemClickListener(listener);

        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
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
        queue.add(stringRequest);

        SearchView searchView = binding.searchbar;
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                elementArrayAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }


}