package ma.emsi.BankAccountService.Entity;

import ma.emsi.BankAccountService.Enum.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class, name = "accountProjection")
public interface AccountProjection {
    public String getId();
    public AccountType getAccountType();
}
