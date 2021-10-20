package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.*;
import com.example.demo.entity.*;

@Service
public class ProductService implements IGeneralService<Product> {
	@Autowired
    private ProductRepository repository;

    @Override
    public List<Product> findAll(){
        return repository.findAll();
    }

    @Override
    public Optional<Product> findById(long id){
    	return repository.findById(id);
    }
	
	@Override
    public Product save(Product newProduct){
		Product product = new Product(
								newProduct.getThumbnail(),
								newProduct.getName(),
								newProduct.getDescription(),
								newProduct.getPrice(),
								newProduct.getRef());
        return repository.saveAndFlush(product);
    }
	
	@Override
    public Product update(Product updatedProduct, long id){
		updatedProduct.setId(id);
        return save(updatedProduct);
    }

    @Override
    public void remove(long id){
        repository.deleteById(id);
    }
}