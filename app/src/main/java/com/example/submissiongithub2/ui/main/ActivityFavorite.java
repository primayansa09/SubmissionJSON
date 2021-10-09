package com.example.submissiongithub2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.submissiongithub2.databinding.ActivityFavoriteBinding;

public class ActivityFavorite extends AppCompatActivity {

    private ActivityFavoriteBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        binding = ActivityFavoriteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Favorite");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}