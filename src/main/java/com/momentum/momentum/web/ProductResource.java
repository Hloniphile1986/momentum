package com.momentum.momentum.web;

import com.momentum.momentum.domain.Product;
import com.momentum.momentum.persitence.entity.ProductEntity;
import com.momentum.momentum.persitence.repository.ProductRepository;
import com.momentum.momentum.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/product")
public class ProductResource {

    private static final Logger logger = LoggerFactory.getLogger(ProductResource.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/populate", method = RequestMethod.POST)
    public void loadData(@RequestParam(value = "numberOfProducts", required = true) final int numberOfProducts) throws SQLException, JAXBException {
        logger.debug("Populating data for [{}] products ", numberOfProducts);
        System.out.println("Populating data for products = " + numberOfProducts);
        productService.populateData(numberOfProducts);
    }

    @RequestMapping(value = "/viewAll", method = RequestMethod.GET)
    public List<Product> getListProductItems() {
        System.out.println("getListProductItems data ");
        List<Product> products = productService.viewAll();
        return products;
    }

    @RequestMapping(value = "/productCodes", method = POST)
    public void buyProducts(@RequestParam(value = "code", required = true) final List<String> code) throws SQLException, JAXBException {
        System.out.println("getListProductItems data " + code);
        productService.buyItems(code);
    }



}
