package com.momentum.momentum.services;

import com.momentum.momentum.domain.Product;
import com.momentum.momentum.persitence.entity.CustomerEntity;
import com.momentum.momentum.persitence.entity.ProductEntity;
import com.momentum.momentum.persitence.repository.CustomerRepository;
import com.momentum.momentum.persitence.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public void populateData(final int numberOfProducts) {
        for (int i = 0; i < numberOfProducts; i++) {
            logger.debug("Lopping on i [{}]", i);
            ProductEntity productEntity = new ProductEntity();
            String code = String.valueOf(System.currentTimeMillis());
            productEntity.setCode(i + code);
            productEntity.setName(i + "Super Product");
            productEntity.setPoints(10);
            productRepository.save(productEntity);
        }
    }

public List<Product> viewAll() {
    List<ProductEntity> list = productRepository.findAll();
    logger.debug("List size is ", list.size());
    List<Product> productsList = new ArrayList<>();
    for (ProductEntity b : list) {
        Product product = new Product();
        product.setCode(b.getCode());
        product.setName(b.getName());
        product.setPoints(b.getPoints());
        productsList.add(product);
    }

  return productsList;
 }

 public void buyItems(final List<String> productCodes) {
     List<ProductEntity> productPoints = productRepository.findByCodeIn(productCodes);
     CustomerEntity customerEntity= customerRepository.findByName("TESTER");
     productPoints.stream().forEach(product -> {
         if (customerEntity.getPoints() > product.getPoints()) {
             logger.debug("........");
             System.out.println("Enough points " + product.getPoints());
             int newCustomerPoints = customerEntity.getPoints() - product.getPoints();
             customerEntity.setPoints(newCustomerPoints);
             customerRepository.save(customerEntity);
         } else {
             System.out.println("Not enough points");
             new Exception("Not enough points");
         }
     });

    }
 }

