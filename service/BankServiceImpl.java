package service;
import model.Account;
import model.CurrentAccount;
import model.SavingsAccount;
//import model.CurrentAccount;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

/*
## 5) Interface : BankService

Crée une interface `BankService` qui définit les opérations :

* `createSavingsAccount(...)`
* `createCurrentAccount(...)`
* `deposit(String id, double amount)`
* `withdraw(String id, double amount)`
* `printAccount(String id)`
* `printAllAccounts()`

Puis `BankServiceImpl implements BankService` :

* stocke les comptes dans un `Map<String, Account>` (id → account)
  (ou `ArrayList<Account>` si tu veux simple, mais `Map` est plus “bank-like”).

💡 **Révision** :

* `interface` = contrat
* `implements` = fournir le code
* `Map` + `containsKey` + `get`

*/

public class BankServiceImpl implements BankService  {

        public Map <Integer, Account> compteName ;
        Scanner sc = new Scanner(System.in);
        public BankServiceImpl() {
            this.compteName =  new HashMap<>();
        }

        public BankServiceImpl(Map <Integer, Account> compteName) {
            this.compteName =  new HashMap<>(compteName);
        }

        public BankServiceImpl(BankServiceImpl other) {
            this.compteName =  new HashMap<>(other.compteName);
        }
        
        public void createSavingsAccount() {
            System.out.println("Enter your Id : ");
            int id = sc.nextInt();
            sc.nextLine();
            if(compteName.containsKey(id)){
                System.out.println("Id already exists");
                return;
            }
            System.out.println("Enter Name : ");
            String name = sc.nextLine();
            System.out.println("Entre Amount : ");
            double sold = sc.nextDouble();
            sc.nextLine();
            System.out.println("Enter interestRate : ");
            double interestRate = sc.nextDouble();
            sc.nextLine();
            SavingsAccount savingsAccount = new SavingsAccount();
            savingsAccount.applyInterest();
            Account account = new SavingsAccount(interestRate,id,name,sold);
            compteName.put(id, account);
            System.out.println("Your SavingsAccount has been created successfuly");
        }

        public void createCurrentAccount() {

            System.out.println("Enter your Id : ");
                int id = sc.nextInt();
                sc.nextLine();
            if( compteName.containsKey(id) ) {
                System.out.println("Id already exists");
                return;
            }
            System.out.println("Enter your Name : ");
                String name = sc.nextLine();
            System.out.println("Enter your Sold : ");
                double sold = sc.nextDouble();
                sc.nextLine();
            System.out.println("Enter your overdraftLimit : ");
                double overCardLimit = sc.nextDouble();
                sc.nextLine();
            Account account = new CurrentAccount(id, name, sold, overCardLimit);
            compteName.put(id, account);
            System.out.println("Your account has been created successfuly");
            
        }

        public void deposit() {
            System.out.println("Enter your Id : ");
            int idDepot = sc.nextInt();
            sc.nextLine();

            Account account = compteName.get(idDepot);
            if (account == null) {
                System.out.println(" Id not found ");
                return;
            }

            System.out.println("Enter amount : ");
            double amountDepot = sc.nextDouble();
            sc.nextLine();

            account.deposit(amountDepot);
            System.out.println("Deposit successful \n New balance: " + account.getBalance());
        }

        public void withdraw() {
            System.out.println("Enter your Id : ");
            int idWith = sc.nextInt();
            sc.nextLine();

            Account account = compteName.get(idWith);
            if (account == null) {
                System.out.println(" Id not found ");
                return;
            }

            System.out.println("Enter amount : ");
            double amountWith = sc.nextDouble();
            sc.nextLine();

            account.withdraw(amountWith);
            System.out.println("Withdraw successful \n New balance: " + account.getBalance());
        }

        public void printAccount() {
            System.out.println(" Enter your Id ");
            int Id = sc.nextInt();
            sc.nextLine();
            if(compteName.containsKey(Id)){
                System.out.println(" Your account infos are : ");
                Account account = compteName.get(Id);
                System.out.println(" Id : " + account.getId());
                System.out.println(" Name  : " + account.getOwnerName());
                System.out.println(" Sold : " + account.getBalance());
            }else {
                System.out.println(" Id not found " );
            }

        }

        public void printAllAccounts() {
                for( Account account : compteName.values() ) {
                    System.out.println(account.toString());
                }  
        }
        

}
