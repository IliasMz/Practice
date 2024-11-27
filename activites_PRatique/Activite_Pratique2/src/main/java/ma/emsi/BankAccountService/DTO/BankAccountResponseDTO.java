package ma.emsi.BankAccountService.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.emsi.BankAccountService.Enum.AccountType;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor @Builder

public class BankAccountResponseDTO {
    private String id; // Changed to Long for the primary key

    private Date creationDate;

    private Double balance;

    private String currency;

    private AccountType accountType;
}
