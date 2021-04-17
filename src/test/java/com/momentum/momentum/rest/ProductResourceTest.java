package com.momentum.momentum.rest;

import com.momentum.momentum.services.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductResourceTest {

@Mock
private ProductService productService;

    @Test
    public void testDataIsLoaded()  {
        Mockito.when(
                productService.viewAll()).thenReturn(anyList());
    }
}
