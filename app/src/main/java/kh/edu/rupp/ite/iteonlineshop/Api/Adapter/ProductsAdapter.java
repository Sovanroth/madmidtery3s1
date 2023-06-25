package kh.edu.rupp.ite.iteonlineshop.Api.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import kh.edu.rupp.ite.iteonlineshop.Api.Model.Product;
import kh.edu.rupp.ite.iteonlineshop.databinding.ViewHolderProduct2Binding;
import kh.edu.rupp.ite.iteonlineshop.databinding.ViewHolderProductBinding;

public class ProductsAdapter extends ListAdapter<Product, ProductsAdapter.ProductHolder> {

    public ProductsAdapter() {
        super(new DiffUtil.ItemCallback<Product>() {
            @Override
            public boolean areItemsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
                return oldItem == newItem;
            }

            @Override
            public boolean areContentsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
                return oldItem.getId().equals(newItem.getId());
            }
        });
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewHolderProductBinding binding = ViewHolderProductBinding.inflate(layoutInflater, parent, false);
//        ViewHolderProduct2Binding binding = ViewHolderProduct2Binding.inflate(layoutInflater, parent, false);
        return new ProductHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        Product item = getItem(position);
        holder.bind(item);
    }

    public static class ProductHolder extends RecyclerView.ViewHolder{
        private final ViewHolderProductBinding itemBinding;

        public ProductHolder(ViewHolderProductBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }

        public void bind(Product product){
            Picasso.get().load(product.getImageUrl()).into(itemBinding.imgProduct);
            itemBinding.productName.setText(product.getName());
            itemBinding.productPrice.setText(product.getPrice());
        }


//        private final ViewHolderProduct2Binding itemBinding;
//
//        public ProductHolder(ViewHolderProduct2Binding itemBinding) {
//            super(itemBinding.getRoot());
//            this.itemBinding = itemBinding;
//        }
//
//        public void bind(Product product){
//            Picasso.get().load(product.getImageUrl()).into(itemBinding.imageProduct);
//            itemBinding.productName.setText(product.getName());
//            itemBinding.productPrice.setText(product.getPrice());
//            itemBinding.rating.setText(product.getRating().toString());
//        }
    }
}
