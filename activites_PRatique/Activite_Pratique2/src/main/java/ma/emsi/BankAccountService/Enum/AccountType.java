package ma.emsi.BankAccountService.Enum;

public enum AccountType {
    CURRENT_ACCOUNT("Current Account"),
    SAVING_ACCOUNT("Saving Account");

    private final String description;

    AccountType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
