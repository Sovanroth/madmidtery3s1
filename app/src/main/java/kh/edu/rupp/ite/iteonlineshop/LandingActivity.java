package kh.edu.rupp.ite.iteonlineshop;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

import kh.edu.rupp.ite.iteonlineshop.Fragment.HomeFragment;
import kh.edu.rupp.ite.iteonlineshop.Fragment.MoreFragment;
import kh.edu.rupp.ite.iteonlineshop.Fragment.ProductsFragment;
import kh.edu.rupp.ite.iteonlineshop.Fragment.ProfileFragment;
import kh.edu.rupp.ite.iteonlineshop.databinding.ActivityLandingBinding;

public class LandingActivity extends AppCompatActivity {

    private ActivityLandingBinding binding;
    private TextView title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityLandingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        showFragment(new HomeFragment());
        title = findViewById(R.id.screen_title);
        title.setText("Home");

        binding.buttonNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.menuHome){
                showFragment(new HomeFragment());
                title.setText("Home");
            }else if (item.getItemId() == R.id.menuProducts){
                showFragment(new ProductsFragment());
                title.setText("Product");
            } else if (item.getItemId() == R.id.menuProfile) {
                showFragment(new ProfileFragment());
                title.setText("Profile");
            }else if (item.getItemId() == R.id.menuMore) {
                showFragment(new MoreFragment());
                title.setText("More");
            }
            return true;
        });
    }

    private void showFragment(Fragment fragment){

        //Return the FragmentManager for interacting with fragments associated with this activity.
        FragmentManager fragmentManager = getSupportFragmentManager();

        //Start a series of edit operations on the Fragments associated with this FragmentManager.
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.lytFragment, fragment);

        fragmentTransaction.commit();

    }
}