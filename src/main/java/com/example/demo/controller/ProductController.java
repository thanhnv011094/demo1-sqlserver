package com.example.demo.controller;

import com.example.demo.entity.*;
import org.springframework.web.bind.annotation.*;
 
@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin
public class ProductController extends BaseController<Product> {
	
}