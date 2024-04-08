package com.example.productservice;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.ProductRepository;
import com.example.productservice.services.FakeStoreProductService;
import com.example.productservice.services.ProductService;
import com.example.productservice.services.SelfProductService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceApplicationTests {



    @Autowired
    private SelfProductService productService;


    @MockBean
    private ProductRepository productRepository;



    @Test
    public void testGetAllProducts() throws ProductNotFoundException {

        when(productRepository.findAll()).
                thenReturn(

                Stream.of( new Product("shirt", 10.00,"Summer Tshirts","google.com/images")

        ).collect(Collectors.toList()));

        assertEquals(1,productService.getAllProducts().size());

    }

    @Test
    public  void testForGetProductById() throws ProductNotFoundException {

        Long id= 10l;

        when(productRepository.findById(id)).thenReturn(
                Optional.of(new Product("shirt", 10.00,"Summer Tshirts","google.com/images"))


        );

        assertEquals("shirt", productService.getProductById(id).getTitle());

    }

    @Test
    public void testForDeleteProduct() throws ProductNotFoundException {

        Long id= 10l;

        when(productRepository.findById(id)).thenReturn(
                Optional.of(new Product("shirt", 10.00,"Summer Tshirts","google.com/images"))


        );


    productService.deleteProduct(10l);


    verify(productRepository, times(1)).deleteById(10l);


    }



}
