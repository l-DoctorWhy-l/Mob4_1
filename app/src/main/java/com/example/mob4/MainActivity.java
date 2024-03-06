package com.example.mob4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.mob4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.nextBtn.setOnClickListener(v -> {
            if (binding.inputField.getText() == null)
                return;
            String[] text = binding.inputField.getText().toString().split(" ");
            System.out.println(text.length);
            if (text.length != 2)
                return;
            User user = new User(text[0], text[1]);
            Intent intent = new Intent(v.getContext(), InfoActivity.class);
            intent.putExtra("user", user);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });
    }



}