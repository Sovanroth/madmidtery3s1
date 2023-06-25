package kh.edu.rupp.ite.iteonlineshop.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import kh.edu.rupp.ite.iteonlineshop.Api.Adapter.ProductsAdapter;
import kh.edu.rupp.ite.iteonlineshop.Api.Model.Product;
import kh.edu.rupp.ite.iteonlineshop.Api.Service.ApiService;
import kh.edu.rupp.ite.iteonlineshop.Api.Service.RetrofitClient;
import kh.edu.rupp.ite.iteonlineshop.R;
import kh.edu.rupp.ite.iteonlineshop.databinding.FragmentHomeBinding;
import kh.edu.rupp.ite.iteonlineshop.databinding.FragmentProductsBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsFragment extends Fragment {

    private FragmentProductsBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        binding = FragmentProductsBinding.inflate(inflater, container, false);
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@Nullable View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        getProductList();

    }

    private void getProductList(){
        //create service object
        ApiService apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);
        //load province list from server
        apiService.getProducts().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {

                if (response.isSuccessful()) {
                    showProvinceList(response.body());
                    Log.d("Loading", "are" +response.body());
                } else {
                    Toast.makeText(getContext(), "Load Products list failed!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(getContext(), "Load products list failed!", Toast.LENGTH_LONG).show();
                Log.e("[ProductsFragment]", "Load products failed: " + t.getMessage());
                t.printStackTrace();
            }
        });
    }

    private void showProvinceList(List<Product> provinceList) {

        // Create layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.recyclerview.setLayoutManager(layoutManager);

//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
//        binding.recyclerview.setLayoutManager(gridLayoutManager);

        // Create adapter
        ProductsAdapter adapter = new ProductsAdapter();
        adapter.submitList(provinceList);
        binding.recyclerview.setAdapter(adapter);

    }
}