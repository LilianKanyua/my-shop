package com.example.myshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myshop.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var productsAdapter: ProductsAdapter
    var productList: List<Procucts> = emptyList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        productsAdapter = ProductsAdapter(emptyList())
        binding.rvProducts.adapter = productsAdapter
//        val intent = Intent(this,ProductsAdapter::class.java)
//        startActivity(intent)

//     startActivity(intent)

    }
    override fun onResume() {
        super.onResume()
        getProducts()
    }
    fun getProducts(){
        var retrofit= ApiClient.buildClient(ApiInterface::class.java)
        val request = retrofit.getProducts()
        request.enqueue(object : Callback<ProductsResponse> {
            override fun onResponse(call: Call<ProductsResponse>, response: Response<ProductsResponse>
            ) {

//                if (response.isSuccessful) {
//                    var productResponse = response.body()?.products
//
//                    var productsAdapter=ProductsAdapter(productResponse?: emptyList())
//                    binding.rvProducts.layoutManager= LinearLayoutManager(this@MainActivity)
//                    binding.rvProducts.adapter=productsAdapter
//
//                    Toast
//                        .makeText(
//                            baseContext,
//                            "fetched ${productList?.size} products",
//                            Toast.LENGTH_LONG
//                        )
//                        .show()

                    if (response.isSuccessful){
    var productsResponse = response.body()?.products
                        var productsAdapter = ProductsAdapter(productsResponse?: emptyList())
//                        var productsAdapter=ProductsAdapter(productResponse?: emptyList())
                    binding.rvProducts.layoutManager= LinearLayoutManager(this@MainActivity)
                    binding.rvProducts.adapter=productsAdapter

    Toast
        .makeText(baseContext,"Fetched ${productList?.size}products",Toast.LENGTH_LONG).show()
}

//                    Toast.makeText(baseContext,response.errorBody()?.string(),Toast.LENGTH_LONG).show()

            }

            override fun onFailure(call: Call<ProductsResponse>, t: Throwable) {
               Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }
        })

    }
}



