package com.example.solarsearch_project.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.solarsearch_project.R;
import com.example.solarsearch_project.databinding.FragmentGalleryBinding;
import com.example.solarsearch_project.models.Element;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    private static final String Solar_API_ID = "https://api.le-systeme-solaire.net/rest.php/bodies?data=id";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();





        return root;



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}