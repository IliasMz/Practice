package org.sid.billingservice;

import org.sid.billingservice.Model.Customer;
import org.sid.billingservice.Model.Product;
import org.sid.billingservice.entities.Bill;
import org.sid.billingservice.entities.ProductItem;
import org.sid.billingservice.repositories.BillRepository;
import org.sid.billingservice.repositories.ProductItemRepository;
import org.sid.billingservice.service.CustomersRestClient;
import org.sid.billingservice.service.ProductRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;


@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(BillingServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BillRepository billRepository,
                            ProductItemRepository productItemRepository,
                            CustomersRestClient customersRestClient,
                            ProductRestClient productRestClient) {
        return args -> {
            Collection<Product> products = productRestClient.allProducts().getContent();
            Long customerId = 1L;
            Customer customer = customersRestClient.findCustomerById(customerId);
            if (customer == null) throw new RuntimeException("Customer Not Found");
            Bill bill = new Bill();
            bill.setBillingDate(new Date());
            bill.setCustomerID(customerId);
            Bill savedBill = billRepository.save(bill);
            products.forEach(p -> {
                ProductItem productItem = new ProductItem();
                productItem.setBill(savedBill);
                productItem.setPrice(p.getPrice());
                productItem.setProductID(p.getId());
                productItem.setDiscount(Math.random() * 100);
                productItem.setQuantity(1 + (int)(Math.random() * 100));
                productItemRepository.save(productItem);
            });
        };
    }

}
