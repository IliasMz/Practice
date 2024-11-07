package ma.emsi.BankAccountService.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.emsi.BankAccountService.Enum.AccountType;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccount {

    @Id
    private String id; // Changed to Long for the primary key

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    private Double balance;

    @Column(length = 20, nullable = false) // Specify length and make it non-nullable if necessary
    private String currency;

    @Enumerated(EnumType.STRING) // Enum mapping as String
    private AccountType accountType;
}
