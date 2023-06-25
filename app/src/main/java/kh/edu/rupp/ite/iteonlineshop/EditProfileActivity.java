package kh.edu.rupp.ite.iteonlineshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import kh.edu.rupp.ite.iteonlineshop.databinding.ActivityEditProfileBinding;

public class EditProfileActivity extends AppCompatActivity {

    private ActivityEditProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityEditProfileBinding.inflate(getLayoutInflater());
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        String gender = intent.getStringExtra("gender");
        String birthday = intent.getStringExtra("birthday");
        String address = intent.getStringExtra("address");

        binding.fullName.setText(name);
        binding.email.setText(email);
        binding.gender.setText(gender);
        binding.birthday.setText(birthday);
        binding.address.setText(address);



        setContentView(binding.getRoot());
    }
}