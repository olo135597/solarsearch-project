package com.example.solarsearch_project.ui.home;

import static androidx.navigation.fragment.FragmentKt.findNavController;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import com.example.solarsearch_project.R;
import com.example.solarsearch_project.databinding.ActivityMainBinding;
import com.example.solarsearch_project.databinding.FragmentHomeBinding;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;

    private static final String NASA_API = "https://api.nasa.gov/planetary/apod?api_key=n9YNX94gAtAvKEijfUzDcfeA8kBVdKnoOLYiAn20";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //Navigates to the Search Page
        ImageButton imageButton = (ImageButton) binding.searchorange;
        View.OnClickListener listener = v -> {
            findNavController(this).navigate(R.id.toGallerie);
        };
        imageButton.setOnClickListener(listener);

        String nasaImgUrl = fetchNasaImg();
        if(nasaImgUrl != null) {
            showNasaImg(nasaImgUrl);
        }


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public String fetchNasaImg() {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(NASA_API)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String jsonString = response.body().string();

            JSONObject jsonObject = new JSONObject(jsonString);
            return jsonObject.getString("url");
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void showNasaImg(String url) {
        ImageView pictureoftheday = binding.pictureoftheday;
        Picasso.get().load(url).into(pictureoftheday);
    }

//    public void NasaIMG() {
//        String url = "";
//
//        OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder()
//                .url(NASA_API)
//                .build();
//
//        try {
//            Response response = client.newCall(request).execute();
//            String jsonString = response.body().string();
//
//            JSONObject jsonObject = new JSONObject(jsonString);
//            url = jsonObject.getString("url");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
////        ImageView imageView = findViewById(R.id.pictureoftheday);
////        Picasso.get().load(url).into(imageView);
//    }


}