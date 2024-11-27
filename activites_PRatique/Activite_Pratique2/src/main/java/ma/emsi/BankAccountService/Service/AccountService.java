package ma.emsi.BankAccountService.Service;

import ma.emsi.BankAccountService.DTO.BankAccountRequestDTO;
import ma.emsi.BankAccountService.DTO.BankAccountResponseDTO;

public interface AccountService  {
     BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
}
