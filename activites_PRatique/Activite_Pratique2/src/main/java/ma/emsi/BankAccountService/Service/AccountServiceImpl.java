package ma.emsi.BankAccountService.Service;
import ma.emsi.BankAccountService.DTO.BankAccountRequestDTO;
import ma.emsi.BankAccountService.DTO.BankAccountResponseDTO;
import ma.emsi.BankAccountService.Entity.BankAccount;
import ma.emsi.BankAccountService.Mappers.AccountMapper;
import ma.emsi.BankAccountService.Repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
     @Autowired
    private BankAccountRepository bankAccountRepository;
     @Autowired
    private AccountMapper accountMapper;


    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        //Mapping DTO to Entity
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .creationDate(new Date())
                .balance(bankAccountDTO.getBalance())
                .currency(bankAccountDTO.getCurrency())
                .accountType(bankAccountDTO.getAccountType())
                .build();
        //business layer
       BankAccount saveBankAccount= bankAccountRepository.save(bankAccount);
       //Mapping Entity to DTO
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(saveBankAccount);
        return bankAccountResponseDTO;
    }
}
