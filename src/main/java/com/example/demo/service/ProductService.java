package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.entity.*;

@Service
public class ProductService extends GeneralService<Product> {
	@Override
    public Product update(Product product, long id){
		product.setId(id);
		return repository.saveAndFlush(product);
    }
}