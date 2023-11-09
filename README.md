# WESTERN GOVERNOR UNIVERSITY --- D287 – JAVA FRAMEWORKS

# Digital Express Electronics - Inventory Management System

This Inventory Management System is a customized software application built using the Spring Framework. It has a Java backend and an HTML front-end. The application is designed to help businesses track their inventory efficiently. It allows users to manage products, parts, and their respective quantities.

## Table of Contents
- [Project Description](#project-description)
- [Changes Made](#changes-made)
- [Products and Parts](#products-and-parts)
- [Contributors](#contributors)

## Changes Made
## Parts C to J

### Part C

**CHANGE - mainscreen.html**

Line 12-22: Included a custom style for the store header.
Line 23 - <title>Digital Express Electronics</title>
Line 29 - <h1>Welcome to Digital Express Electronics</h1>
Line 33 - <h2> Shop for computer supplies  </h2>
Line 68 - <h2>Shop Computers and Laptops Products</h2>


### Part D

**CREATE - about.html**

<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
 <meta charset="UTF-8">


 <!-- Required meta tags -->
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">


 <!-- Bootstrap CSS -->
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
       integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
 <title>About Us - Digital Express Electronics</title>
</head>
<body>


<div class="container">
 <div class="store-header">
   <h1>About Us</h1>
 </div>
 <a th:href="@{/mainscreen.html}" class="btn btn-primary btn-sm mb-3" style="background-color: black; color: darkgrey; border: none; padding: 10px 20px; text-align: center; text-decoration: none; display: inline-block; font-size: 16px; border-radius: 5px;">Back to Home</a>


 <div class="row">
   <div class="col-md-6">
     <h2>Our Story</h2>
     <p>
       At Digital Express Electronics, we are proud to serve a diverse and loyal customer base. Our journey began with a
       simple mission: to provide high-quality electronic products to our valued customers.
     </p>
     <p>
       Over the years, our customers have become an integral part of our success story. Their trust and support have
       fueled our growth and innovation.
     </p>
   </div>
   <div class="col-md-6">
     <!-- Real image from Google -->
     <img src="images/team_1.jpg" alt="Our Team" class="img-fluid">
   </div>
 </div>


 <div class="row mt-4">
   <div class="col-md-6">
     <!-- Real image from Google -->
     <img src="images/team_2.jpg" alt="Our Store" class="img-fluid">
   </div>
   <div class="col-md-6">
     <h2>Our Team</h2>
     <p>
       Our dedicated team is committed to delivering the best products and services to our customers. We believe that
       our success is a direct result of our customers' satisfaction.
     </p>
     <p>
       We value the feedback and input from our customers, and it continuously inspires us to improve and exceed
       expectations.
     </p>
   </div>
 </div>
</div>


</body>
</html>


</body>
</html>


    INSERT - mainscreen.html
    
Line 31 - <a th:href="@{/about.html}" class="btn btn-primary btn-sm mb-3" style="background-color: black; color: darkgrey; border: none; padding: 10px 20px; text-align: center; text-decoration: none; display: inline-block; font-size: 16px; border-radius: 5px;">Learn More About Us</a>



    CREATE - AboutUsController.java, LINES 57-61
package com.example.demo.controllers;




import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AboutUsController {
   @GetMapping("/about.html")
   public String aboutPage() {
       return "about";
   }
}

**INSERT - MainControllerr **

Lines 4-21: adding in imports all just in case only need GetMapping
Lines 22-27:Configuration of controller to be sent to the AboutUs page

### Part E

**INSERT - Bootstrap.java**

package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

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

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

//        partRepository.deleteAll();
//        productRepository.deleteAll();
//        outsourcedPartRepository.deleteAll();

        if (partRepository.count() == 0) {

            InhousePart batteries = new InhousePart();
            batteries.setName("Batteries");
            batteries.setPrice(10.99);
            batteries.setInv(1000);

            InhousePart microprocessor = new InhousePart();
            microprocessor.setName("Microprocessor");
            microprocessor.setPrice(29.99);
            microprocessor.setInv(500);

            InhousePart led_display = new InhousePart();
            led_display.setName("LED Display");
            led_display.setPrice(49.99);
            led_display.setInv(300);

            InhousePart motherboard = new InhousePart();
            motherboard.setName("Motherboard");
            motherboard.setPrice(79.99);
            motherboard.setInv(200);

            InhousePart casing_housing = new InhousePart();
            casing_housing.setName("Casing and Housing");
            casing_housing.setPrice(59.99);
            casing_housing.setInv(10);

            partRepository.save(batteries);
            partRepository.save(microprocessor);
            partRepository.save(led_display);
            partRepository.save(motherboard);
            partRepository.save(casing_housing);
        }

        if (outsourcedPartRepository.count() == 0) {

            OutsourcedPart sd100 = new OutsourcedPart();
            sd100.setName("Storage Drive 100 GB");
            sd100.setPrice(9.99);
            sd100.setInv(50);
            sd100.setCompanyName("XCorp");

            OutsourcedPart sd200 = new OutsourcedPart();
            sd200.setName("Storage Drive 200 GB");
            sd200.setPrice(19.99);
            sd200.setInv(40);
            sd200.setCompanyName("XCorp");

            OutsourcedPart sd300 = new OutsourcedPart();
            sd300.setName("Storage Drive 300 GB");
            sd300.setPrice(29.99);
            sd300.setInv(30);
            sd300.setCompanyName("XCorp");

            OutsourcedPart sd400 = new OutsourcedPart();
            sd400.setName("Storage Drive 400 GB");
            sd400.setPrice(39.99);
            sd400.setInv(20);
            sd400.setCompanyName("XCorp");

            OutsourcedPart sd500 = new OutsourcedPart();
            sd500.setName("Storage Drive 500 GB");
            sd500.setPrice(49.99);
            sd500.setInv(10);
            sd500.setCompanyName("XCorp");

            outsourcedPartRepository.save(sd100);
            outsourcedPartRepository.save(sd200);
            outsourcedPartRepository.save(sd300);
            outsourcedPartRepository.save(sd400);
            outsourcedPartRepository.save(sd500);
        }

        if (productRepository.count() == 0 ) {

            Product comp_100 = new Product("Computer 100GB", 199.99, 15);
            Product comp_200 = new Product("Computer 200GB", 299.99, 15);
            Product comp_300 = new Product("Computer 300GB", 399.99, 15);
            Product comp_400 = new Product("Computer 400GB", 499.99, 15);
            Product comp_500 = new Product("Computer 500GB", 599.99, 15);

            productRepository.save(comp_100);
            productRepository.save(comp_200);
            productRepository.save(comp_300);
            productRepository.save(comp_400);
            productRepository.save(comp_500);
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}


### Part F

**CREATE - confirmationbuyproduct.html**

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Product Purchase Confirmation</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- Custom Styles -->
    <style>
        body {
            background-color: #f8f9fa;
            padding: 20px;
        }

        h1 {
            color: #28a745;
            text-align: center;
            margin-top: 50px;
        }

        a {
            display: block;
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Your product has been purchased.</h1>
        <a href="http://localhost:8080/" class="btn btn-primary">Link to Main Screen</a>
    </div>
</body>
</html>



**CREATE - errorbuyproduct.html**

         < !DOCTYPE html > 
         < html lang="en" > 
         < head > 
             < meta charset="UTF-8" > 
             < title > Error purchasing product. < /title > 
         < /head > 
         < body > 
         < h1 > Error purchasing product. Confirm current inventory. < /h1 > 
        
         < a href="http://localhost:8080/" > Link to Main Screen < /a > 
        
         < /body > 
         < /html > 

**NSERT - mainscreen.html, LINES 96**

        <a th:href="@{/buyproduct(productID=${tempProduct.id})}" class="btn btn-primary btn-sm mb-3" onclick="if(!(confirm('Are you sure you want to purchase this product?')))return false">Buy Now</a>


**INSERT - product.java, LINES 108-128**

// Instruction F: buyProduct function to decrement inventory
   public boolean buyProduct() {
       if (this.inv >= 1 ) {
           this.inv--;


           for (Part part : this.getParts()) {
               if (part.getInv() >= 1) {
                   part.setInv(part.getInv() - 1);
               } else {
                   // Handle the case where the part inventory is insufficient
                   return false;
               }
           }


           // Product purchase was successful
           return true;
       } else {
           // Handle the case where product inventory is insufficient
           return false;
       }
   }



**INSERT - AddProductController.java, 172-187**

        
@GetMapping("/buyproduct")
public String buyProduct(@RequestParam("productID") int theId, Model theModel) {
   ProductService productService = context.getBean(ProductServiceImpl.class);
   Product product = productService.findById(theId);


   boolean purchaseConfirmation = product.buyProduct();


   if (purchaseConfirmation) {
       productService.save(product);
       // Purchase successful, redirect to a success page
       return "redirect:/purchaseSuccess";
   } else {
       // Purchase failed, redirect to an error page
       return "redirect:/purchaseError";
   }
}

### Part G
• Add additional fields to the part entity for maximum and minimum inventory.
** INSERT - mainscreen.html, LINES 50-51 AND LINES 60-61**

<th>Minimum</th>
<th>Maximum</th>


<td th:text="${tempPart.minimum}"></td>
<td th:text="${tempPart.maximum}"></td>

   INSERT - Part.java, LINES 44-52
@Min (value = 0, message = "Minimum inventory must be > 0")
int minimum;
int maximum;


public void setMinimum(int minimum) { this.minimum = minimum; }
public int getMinimum() { return this.minimum; }


public void setMaximum(int maximum) { this.maximum = maximum; }
public int getMaximum() { return this.maximum; }


**    INSERT - InhousePart.java AND OutsourcedPart.java, LINES 18-20**

        // Adding default values for maximum and minimum; can be changed in app
        this.minimum = 0;
        this.maximum = 100;

 
•Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
   INSERT - InhousePartForm.html AND OutsourcedPartForm.html, LINES 5-50

<p><input type="hidden" th:field="*{id}"/></p>


<p>
   <label>Name:</label>
   <input type="text" th:field="*{name}" placeholder="Name" class="form-control mb-4 col-4"/>
</p>


<p>
   <label>Price:</label>
   <input type="text" path="price" th:field="*{price}" placeholder="Price" class="form-control mb-4 col-4"/>
<p th:if="${#fields.hasErrors('price')}" th:errors="*{price}">Price Error</p>
</p>


<p>
   <label>Inventory:</label>
   <input type="text" path="inv" th:field="*{inv}" placeholder="Inventory" class="form-control mb-4 col-4"/>
<p th:if="${#fields.hasErrors('inv')}" th:errors="*{inv}">Inventory Error</p>
</p>


<p>
   <label>Part ID:</label>
   <input type="text" th:field="*{partId}" placeholder="Part ID" class="form-control mb-4 col-4"/>
</p>


<p>
   <label>Minimum:</label>
   <input type="text" th:field="*{minimum}" placeholder="Minimum" class="form-control mb-4 col-4"/>
</p>


<p>
   <label>Maximum:</label>
   <input type="text" th:field="*{maximum}" placeholder="Maximum" class="form-control mb-4 col-4"/>
</p>


<p>
   <label>Part ID:</label>
   <input type="text" th:field="*{partId}" placeholder="Part ID" class="form-control mb-4 col-4"/>
</p>


<p>
<div th:if="${#fields.hasAnyErrors()}">
   <ul>
       <li th:each="err: ${#fields.allErrors()}" th:text="${err}"></li>
   </ul>
</div>
</p>



• Rename the file the persistent storage is saved to.
**   CHANGE - application.properties**

        spring.datasource.url=jdbc:h2:file:~/spring-boot-h2-db102
        TO
        spring.datasource.url=jdbc:h2:file:~/src/main/resources/spring-boot-h2-db102


• Modify the code to enforce that the inventory is between or at the minimum and maximum value.
**    INSERT - Part.java LINES 105-111**

        public void validateLimits() {
            if (this.inv < this.minimum) {
                this.inv = this.minimum;
            } else if (this.inv > this.maximum ) {
                this.inv = this.maximum;
            }
        }

    INSERT - InhousePartServiceImpl.java AND OutsourcedPartServiceImpl.java, LINE 54

thePart.validateLimits();



### Part H

Add validation for between or at the maximum and minimum fields. The validation must include the following:
**   INSERT - Part.java, LINES 21-22**

@ValidPartInventory
@ValidPartInventoryMinimum


• Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
**   CREATE - PartInventoryMinimumValidator.java**

        package com.example.demo.validators;
        
        import com.example.demo.domain.Part;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.ApplicationContext;
        
        import javax.validation.ConstraintValidator;
        import javax.validation.ConstraintValidatorContext;
        
        /**
         *
         *
         *
         *
         */
        public class PartInventoryMinimumValidator implements ConstraintValidator < ValidPartInventoryMinimum, Part > {
            @Autowired
            private ApplicationContext context;
        
            public static  ApplicationContext myContext;
        
            @Override
            public void initialize(ValidPartInventoryMinimum constraintAnnotation) {
                ConstraintValidator.super.initialize(constraintAnnotation);
            }
        
            @Override
            public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
                return part.getInv() > part.getMinimum();
            }
        }

**    CREATE ValidPartInventoryMinimum.java**

        package com.example.demo.validators;
        
        import javax.validation.Constraint;
        import javax.validation.Payload;
        import java.lang.annotation.ElementType;
        import java.lang.annotation.Retention;
        import java.lang.annotation.RetentionPolicy;
        import java.lang.annotation.Target;
        
        /**
         *
         *
         *
         *
         */
        @Constraint(validatedBy = {PartInventoryMinimumValidator.class})
        @Target({ElementType.TYPE})
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ValidPartInventoryMinimum {
            String message() default "Inventory cannot be lower than required minimum";
            Class [] groups() default {};
            Class [] payload() default {};
        }


• Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum. Also, • Display error messages when adding and updating parts if the inventory is greater than the maximum.

**   CREATE - PartInventoryValidator.java**

@Override
public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
   if (part.getInv() >= part.getMinimum()) {
       return true;
   } else {
package com.example.demo.validators;


import com.example.demo.domain.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
*
*
*
*
*/
public class PartInventoryMinimumValidator implements ConstraintValidator < ValidPartInventoryMinimum, Part > {
   @Autowired
   private ApplicationContext context;


   public static  ApplicationContext myContext;


   @Override
   public void initialize(ValidPartInventoryMinimum constraintAnnotation) {
       ConstraintValidator.super.initialize(constraintAnnotation);
   }
   @Override
   public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
       if (part.getInv() >= part.getMinimum()) {
           return true;
       } else {
           // Display a custom error message
           constraintValidatorContext.buildConstraintViolationWithTemplate("Inventory cannot be lowered below the minimum value")
                   .addPropertyNode("inv") // Specify the property
                   .addConstraintViolation();
           return false;
       }
       }
}


**    CREATE - ValidPartInventory.java**

package com.example.demo.validators;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
*
*
*
*
*/
@Constraint(validatedBy = {PartInventoryValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPartInventory {
   String message() default "Inventory cannot exceed maximum value";
   Class [] groups() default {};
   Class [] payload() default {};
}



### Part I
**  INSERT - PartTest.java, LINES 160-176**
        @Test
        void getMinimum() {
            int minimum=5;
            partIn.setMinimum(minimum);
            assertEquals(minimum, partIn.getMinimum());
            partOut.setMinimum(minimum);
            assertEquals(minimum, partOut.getMinimum());
        }
    
        @Test
        void getMaximum() {
            int maximum=5;
            partIn.setMaximum(maximum);
            assertEquals(maximum, partIn.getMaximum());
            partOut.setMaximum(maximum);
            assertEquals(maximum, partOut.getMaximum());
        }



### Part J
ValidDeletePart (DeletePartValidator):

Usage: Used in Part.java.
Functionality: Prevents parts from being deleted if they're associated with a product.
Status: Currently in use.
ValidEnufParts (EnufPartsValidator):

Usage: Used in Product.java.
Functionality: Prevents adding additional product inventory if there isn't enough associated parts inventory.
Status: Currently in use.
ValidPartInventory (PartInventoryValidator):

Usage: Used in Part.java.
Functionality: Prevents adding additional part inventory if it exceeds the specified max.
Status: Currently in use.
ValidPartInventoryMinimum (PartInventoryMinimumValidator):

Usage: Used in Part.java.
Functionality: Prevents modifying part inventory if the changes put it below the min threshold.
Status: Currently in use.
ValidProductPrice (PriceProductValidator):

Usage: Used in Product.java.
Functionality: Prevents charging less for the product than the sum cost of its associated parts.
Status: Currently in use.
