package com.example.productservice.services;


import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements  ProductService {


    private ProductRepository productRepository;
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate , ProductRepository  productRepository) {
        this.restTemplate = restTemplate;
        this.productRepository=productRepository;
    }

    public Product convertToProduct(FakeStoreProductDto productDto){

        Product product = new Product();

        Category category = new Category();

        category.setTitle(productDto.getCategory());

        product.setCategory(category);
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setImgUrl(productDto.getImage());
        product.setPrice(productDto.getPrice());
        product.setId(productDto.getId());


        return product;
    }

    @Override
    public Product getProductById(Long id) throws  ProductNotFoundException{
        FakeStoreProductDto productDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+ id, FakeStoreProductDto.class);

      //  System.out.println(productDto);

        if(productDto==null){
            throw new ProductNotFoundException("Product with ID "+id+ " not found");
        }

        return convertToProduct(productDto);
    }

    @Override
    public List<Product> getAllProducts() throws ProductNotFoundException {

        FakeStoreProductDto[] productDtos = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);

        if(productDtos==null){
            throw new ProductNotFoundException();
        }


        ArrayList<Product> products=new ArrayList<>();

        for(FakeStoreProductDto dto: productDtos){

            products.add(convertToProduct(dto));
        }

        return products;
    }

    @Override
    public Product addNewProduct(FakeStoreProductDto productDto) {
       // restTemplate.postForEntity("")

        return null;
    }

    @Override
    public void test() {




    }

    @Override
    public Product deleteProduct(Long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public Product updateProduct(Long id, FakeStoreProductDto productDto) {


        return null;
    }
}
