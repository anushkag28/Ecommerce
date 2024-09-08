package com.example.scm.services;

import com.example.scm.Dto.ProductDto;

public interface ProductServiceInterface {
    ProductDto createProduct(ProductDto productDto);
    ProductDto updateProduct(ProductDto productDto, Long id);
    ProductDto getProductDetailsById(Long id);
    ProductDto deleteProduct(Long id);


}
