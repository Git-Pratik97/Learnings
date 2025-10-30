package designPatterns.structural;

//Facade provides a Simplified interface to complex systems and decouples client from system components

public class FacadeDesignPattern {
    public static void main(String[] args) {
        BankFacade bank = new BankFacade();
        bank.openAccount("Vijay Kediya");
    }
}

//Creating a subsystem for Bank Operations
class AccountCreation{
    public void createAccount(String customer){
        System.out.println("Account created successfully for: " + customer);
    }
}

class CreditCheck{
    public boolean hasGoodCredit(String customer){
        System.out.println("Checking credit score for: " + customer);
        return true; //Suppose customer has good credit
    }
}

class LoanDepartment{
    public void grantLoan(String customer){
        System.out.println("Checking loan history for: " + customer);
        System.out.println("Loan availed to: " + customer);
    }
}

//Creating the facade (Equivalent to help Desk)
class BankFacade{
    private LoanDepartment loan;
    private AccountCreation accountCreation;
    private CreditCheck creditCheck;

    public BankFacade() {
        this.accountCreation = new AccountCreation();
        this.creditCheck = new CreditCheck();
        this.loan = new LoanDepartment();
    }

    public void openAccount(String customer){
        accountCreation.createAccount(customer);
        if(creditCheck.hasGoodCredit(customer)){
            loan.grantLoan(customer);
        }else{
            System.out.println("Can not give loan to customer due to poor credit score");
        }
    }
}