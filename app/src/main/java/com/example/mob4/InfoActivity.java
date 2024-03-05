package com.example.mob4;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mob4.databinding.ActivityInfoBinding;

public class InfoActivity extends AppCompatActivity {
    private ActivityInfoBinding binding;

    private final ActivityResultLauncher<Intent> addSubjectLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if(result.getResultCode() == RESULT_OK){
                    Toast.makeText(getApplicationContext(), "Время занятия успешно передано", Toast.LENGTH_SHORT).show();
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.enterInfoBtn.setOnClickListener(v ->{
            addSubjectLauncher.launch(new Intent(v.getContext(), ResultActivity.class));
        });

        inflateTextViews();

        Bundle args = getIntent().getExtras();
        if(args != null){
            User user = (User) args.get("user");
            if(user != null)
                inflateTextViews(user);
        }





    }




    private void inflateTextViews(User user){
        binding.nameTv.setText(getResources().getString(R.string.user_name, user.getName()));
        binding.surnameTv.setText(getResources().getString(R.string.user_surname, user.getSurname()));
    }
    private void inflateTextViews(){
        binding.nameTv.setText(getResources().getString(R.string.user_name, ""));
        binding.surnameTv.setText(getResources().getString(R.string.user_surname, ""));
    }
}