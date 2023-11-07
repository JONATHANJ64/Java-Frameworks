package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
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

        // Clearing repositories for multiple test runs
        // partRepository.deleteAll();
        // productRepository.deleteAll();
        // outsourcedPartRepository.deleteAll();

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