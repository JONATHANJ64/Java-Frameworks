package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.domain.Product;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/buyProduct")
    public String buyProduct(@RequestParam("productId") Long productId, @RequestParam("quantity") int quantity) {
        Optional<Product> productOptional = productRepository.findById(productId);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            int currentInventory = product.getInv();

            if (currentInventory >= quantity) {
                // Decrease the inventory by the purchased quantity
                product.setInv(currentInventory - quantity);
                productRepository.save(product);

                // Redirect to a purchase success page
                return "redirect:/purchaseSuccess";
            } else {
                // Redirect to a purchase error page
                return "redirect:/purchaseError";
            }
        }

        // Redirect to a purchase error page in case of product not found
        return "redirect:/purchaseError";
    }


    @GetMapping("/purchaseSuccess")
    public String displayPurchaseSuccess() {
        return "purchaseSuccess";
    }

    @GetMapping("/purchaseError")
    public String displayPurchaseError() {
        return "purchaseError"; // Make sure this matches the template name
    }

}
