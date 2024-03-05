package com.example.mob4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mob4.databinding.ActivityResultBinding;

import java.util.Objects;

public class ResultActivity extends AppCompatActivity {

    private ActivityResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.okBtn.setOnClickListener(v -> {
            if(binding.commentEt.getText() == null || binding.dayEt.getText() == null || binding.timeEt.getText() == null){
                setResult(RESULT_CANCELED);
                finish();
            }
            Intent intent = new Intent();
            intent.putExtra("day", Objects.requireNonNull(binding.dayEt.getText()).toString());
            intent.putExtra("time", Objects.requireNonNull(binding.timeEt.getText()).toString());
            intent.putExtra("comment", Objects.requireNonNull(binding.commentEt.getText()).toString());
            setResult(RESULT_OK);
            finish();
        });
    }
}