package com.example.scm.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.scm.Dto.ProductDto;
import com.example.scm.entities.Product;


public class ProductMapper {
    @Autowired
    private ModelMapper modelMapper;

    public Product ProductDtoToProduct(ProductDto productDto){
        return modelMapper.map(productDto, Product.class);
    }

    public ProductDto productToProductDto(Product product){
        return modelMapper.map(product, ProductDto.class);
    }
}


