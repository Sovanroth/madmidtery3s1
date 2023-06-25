package kh.edu.rupp.ite.iteonlineshop.Api.Service;

import java.util.List;

import kh.edu.rupp.ite.iteonlineshop.Api.Model.Product;
import kh.edu.rupp.ite.iteonlineshop.Api.Model.Profile;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/kimsongsao/ferupp/main/products.json")
    Call<List<Product>> getProducts();

    @GET("/kimsongsao/ferupp/main/profile.json")
    Call<Profile> getProfile();
}
