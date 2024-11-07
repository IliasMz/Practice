package org.sid.billingservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.sid.billingservice.Model.Product;

@Entity
@Data@AllArgsConstructor@NoArgsConstructor@Builder
public class ProductItem {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private double price;
    private double discount;
    private Long productID;
    private int quantity;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Bill bill;
    @Transient Product product;

}
