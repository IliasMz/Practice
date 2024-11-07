package ma.emsi.BankAccountService.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.emsi.BankAccountService.Enum.AccountType;

@Data@AllArgsConstructor@NoArgsConstructor@Builder
public class BankAccountRequestDTO {

    private Double balance;
    private String currency;
    private AccountType accountType;
}
