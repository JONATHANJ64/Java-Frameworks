package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Check if parts and products count is zero before adding the sample inventory
        //!!! uncomment this code back out before you submit your project
/*
        if (partRepository.count() == 0 && productRepository.count() == 0) {
            // Add 5 sample parts
            for (int i = 1; i <= 5; i++) {
                Part part = new Part();
                part.setName("Part " + i);
                part.setPrice(10.0 * i);
                part.setInv(100 * i);
                partRepository.save(part);
            }
            // Add 5 sample products
            for (int i =  1; i <= 5; i++) {
                Product product = new Product();
                product.setName("Product " + i);
                product.setPrice(100.0 * i);
                product.setInv(15 * i);
                productRepository.save(product);
            }
        }
*/
        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
