package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Primary
public class SelfProductService implements ProductService{


    private CategoryRepository categoryRepository ;
    private ProductRepository productRepository;

    public SelfProductService(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public Product convertToProduct(FakeStoreProductDto productDto){

        Product product = new Product();

        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setImgUrl(productDto.getImage());
        product.setPrice(productDto.getPrice());
        product.setId(productDto.getId());

        Optional<Category> optionalCategory;
        Category category ;

        String categoryFromDto = productDto.getCategory();

        optionalCategory = categoryRepository.findByTitle(categoryFromDto);

        if(optionalCategory.isEmpty()){

            category = new Category(categoryFromDto);
           // categoryRepository.save(category);

        }
        else category = optionalCategory.get();

        product.setCategory(category);





        return product;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {

        Optional<Product> optionalProduct = productRepository.findById(id);




        if(optionalProduct.isEmpty())
            throw new ProductNotFoundException("The product with ID - "+ id+ " is not found");




        return optionalProduct.get();


    }

    @Override
    public List<Product> getAllProducts() throws ProductNotFoundException {

       List<Product> products =  productRepository.findAll();



        return products;
    }

    @Override
    public Product addNewProduct(FakeStoreProductDto productDto) {

        Product product = convertToProduct(productDto);

        productRepository.save(product);

        return product;

    }

    @Override
    public void test() {

    }

    @Override
    public Product deleteProduct(Long id) throws ProductNotFoundException {

        Optional<Product> product = productRepository.findById(id);

        if(product.isEmpty())
            throw new ProductNotFoundException("The product with ID - "+ id+ " is not found");

       productRepository.deleteById(id);

        return null;
    }

    @Override
    public Product updateProduct(Long id, FakeStoreProductDto productDto) throws ProductNotFoundException {

        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty())
            throw new ProductNotFoundException();

        Product product = optionalProduct.get();

        if(productDto.getTitle() != null){
            product.setTitle(productDto.getTitle());
        }
        if(productDto.getPrice() != product.getPrice()){
            product.setPrice(productDto.getPrice());
        }
        if(productDto.getDescription() != null){
            product.setDescription(productDto.getDescription());
        }
        if(productDto.getImage() != null){
            product.setImgUrl(productDto.getImage());
        }
        if(productDto.getCategory() != product.getCategory().getTitle()){
            Optional<Category> categoryOptional = categoryRepository.findByTitle(productDto.getCategory());

            Category category;
            if(categoryOptional.isEmpty()){
                 category = new Category(productDto.getCategory());
                 product.setCategory(category);
            }
            else category = categoryOptional.get();

        }

       Product product1 =  productRepository.save(product);

        return product1;
    }
}
