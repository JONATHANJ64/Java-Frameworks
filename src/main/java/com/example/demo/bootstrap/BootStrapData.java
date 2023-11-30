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

//         Clearing repositories for multiple test runs
         partRepository.deleteAll();
         productRepository.deleteAll();
         outsourcedPartRepository.deleteAll();

        if (partRepository.count() == 0) {

            InhousePart Batteries = new InhousePart();
            Batteries.setName("Batteries");
            Batteries.setPrice(19.99);
            Batteries.setInv(10);
            Batteries.setMinimum(0);
            Batteries.setMaximum(100);

            InhousePart MotherBoard = new InhousePart();
            MotherBoard.setName("MotherBoard");
            MotherBoard.setPrice(29.99);
            MotherBoard.setInv(10);
            MotherBoard.setMinimum(0);
            MotherBoard.setMaximum(100);

            InhousePart CaseHouse = new InhousePart();
            CaseHouse.setName("Casing & Housing");
            CaseHouse.setPrice(39.99);
            CaseHouse.setInv(10);
            CaseHouse.setMinimum(0);
            CaseHouse.setMaximum(100);

            InhousePart Microprocessor = new InhousePart();
            Microprocessor.setName("Microprocessor");
            Microprocessor.setPrice(49.99);
            Microprocessor.setInv(10);
            Microprocessor.setMinimum(0);
            Microprocessor.setMaximum(100);

            InhousePart LED = new InhousePart();
            LED.setName("LED Display");
            LED.setPrice(59.99);
            LED.setInv(10);
            LED.setMinimum(0);
            LED.setMaximum(100);

            partRepository.save(Batteries);
            partRepository.save(MotherBoard);
            partRepository.save(CaseHouse);
            partRepository.save(Microprocessor);
            partRepository.save(LED);
        }

        if (outsourcedPartRepository.count() == 0) {

            OutsourcedPart ssd1000 = new OutsourcedPart();
            ssd1000.setName("screw 0.2");
            ssd1000.setPrice(19.99);
            ssd1000.setInv(10);
            ssd1000.setCompanyName("X-Group");
            ssd1000.setMinimum(0);
            ssd1000.setMaximum(100);

            OutsourcedPart ssd2000 = new OutsourcedPart();
            ssd2000.setName("screw 0.4");
            ssd2000.setPrice(29.99);
            ssd2000.setInv(10);
            ssd2000.setCompanyName("X-Group");
            ssd2000.setMinimum(0);
            ssd2000.setMaximum(100);

            OutsourcedPart ssd3000 = new OutsourcedPart();
            ssd3000.setName("screw 0.6");
            ssd3000.setPrice(39.99);
            ssd3000.setInv(10);
            ssd3000.setCompanyName("X-Group");
            ssd3000.setMinimum(0);
            ssd3000.setMaximum(100);

            OutsourcedPart ssd4000 = new OutsourcedPart();
            ssd4000.setName("screw 0.8");
            ssd4000.setPrice(49.99);
            ssd4000.setInv(10);
            ssd4000.setCompanyName("X-Group");
            ssd4000.setMinimum(0);
            ssd4000.setMaximum(100);

            OutsourcedPart ssd5000 = new OutsourcedPart();
            ssd5000.setName("screw 1.0");
            ssd5000.setPrice(59.99);
            ssd5000.setInv(10);
            ssd5000.setCompanyName("X-Group");
            ssd5000.setMinimum(0);
            ssd5000.setMaximum(100);

            outsourcedPartRepository.save(ssd1000);
            outsourcedPartRepository.save(ssd2000);
            outsourcedPartRepository.save(ssd3000);
            outsourcedPartRepository.save(ssd4000);
            outsourcedPartRepository.save(ssd5000);
        }

        if (productRepository.count() == 0 ) {

            Product T1 = new Product("Computer", 199.99, 15);
            Product T2 = new Product("Iphone", 299.99, 15);
            Product T3 = new Product("Tablet", 399.99, 15);
            Product T4 = new Product("Monitor", 499.99, 15);
            Product T5 = new Product("Console System", 599.99, 15);

            productRepository.save(T1);
            productRepository.save(T2);
            productRepository.save(T3);
            productRepository.save(T4);
            productRepository.save(T5);
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
