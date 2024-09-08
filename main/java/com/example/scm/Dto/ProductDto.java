package com.example.scm.Dto;


import lombok.*;

import java.math.BigDecimal;



    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public class ProductDto {


        private Long id;
        private String name;
        private String description;
        private BigDecimal price;
        private int stockQuantity;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
