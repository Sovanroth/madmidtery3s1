package kh.edu.rupp.ite.iteonlineshop.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import kh.edu.rupp.ite.iteonlineshop.Api.Model.Profile;
import kh.edu.rupp.ite.iteonlineshop.Api.Service.ApiService;
import kh.edu.rupp.ite.iteonlineshop.Api.Service.RetrofitClient;
import kh.edu.rupp.ite.iteonlineshop.EditProfileActivity;
import kh.edu.rupp.ite.iteonlineshop.databinding.FragmentProfileBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@Nullable View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        getProfile();
        binding.edit.setOnClickListener(v -> {

            Intent intent = new Intent(getContext(), EditProfileActivity.class);
            intent.putExtra("name", binding.fullName.getText());
            intent.putExtra("email", binding.email.getText());
            intent.putExtra("gender", binding.gender.getText());
            intent.putExtra("birthday", binding.bod.getText());
            intent.putExtra("address", binding.address.getText());
            startActivity(intent);
            getActivity().finish();
        });
    }


    public void getProfile(){

        ApiService apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);
        apiService.getProfile().enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(@NonNull Call<Profile> call, @NonNull Response<Profile> response) {
                if (response.isSuccessful()){
                    Log.d("Loading", "Profile is " +response.body());
                    assert response.body() != null;
                    Picasso.get().load(response.body().getImageUrl()).into(binding.profileImage);
                    binding.fullName.setText(String.format("%s %s", response.body().getFirstName(), response.body().getLastName()));
                    binding.email.setText(response.body().getEmail());
                    binding.emailShow.setText(response.body().getEmail());
                    binding.phone.setText(response.body().getPhoneNumber());
                    binding.gender.setText(response.body().getGender());
                    binding.bod.setText(response.body().getBirthday());
                    binding.address.setText(response.body().getAddress());
                } else {
                    Toast.makeText(getContext(), "Load profile is failed!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {
                Toast.makeText(getContext(), "Load profile is failed!", Toast.LENGTH_LONG).show();
                Log.e("[ProfileFragment]", "Load profile is failed: " + t.getMessage());
                t.printStackTrace();
            }
        });
    }
}