package org.sid.billingservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.sid.billingservice.Model.Customer;

import java.util.Date;
import java.util.List;
@Entity
@Data
@AllArgsConstructor@NoArgsConstructor@Builder

public class Bill {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private Long customerID;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems ;
    private Date billingDate;
    @Transient private Customer customer;

}
