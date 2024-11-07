package ma.emsi.BankAccountService.Repositories;

import ma.emsi.BankAccountService.Entity.BankAccount;
import ma.emsi.BankAccountService.Enum.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
    @RestResource(path = "/byAccountType")
    List<BankAccount> findByAccountType(@Param("t") AccountType type);
}
