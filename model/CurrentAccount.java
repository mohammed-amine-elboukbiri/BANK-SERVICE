package model;
/*
### `CurrentAccount extends Account`

* ajoute `overdraftLimit` (découvert autorisé)
* redéfinit `withdraw()` pour autoriser le découvert
*/
public class CurrentAccount extends Account {
    private double overdraftLimit;
    public CurrentAccount(){
        super();
        this.overdraftLimit = 0.0;
    }
    public CurrentAccount(int id,String ownerName,double balance,double overdraftLimit){
        super(id,ownerName,balance);
        this.overdraftLimit = overdraftLimit;
    }
    public CurrentAccount(CurrentAccount other){
        super(other);
        this.overdraftLimit = other.overdraftLimit;
    }
    public double getOverdraftLimit(){
        return overdraftLimit;
    }
    public void setOverdraftLimit(double overdraftLimit){
        this.overdraftLimit = overdraftLimit;
    }
    @Override
    public void  deposit(double amount){
        System.out.println("=====Deposit=====");
        if(amount<=0){
            System.out.println("Deposit amount must be greater than zero");
        }else{
            double Somme = getBalance() + amount;
            setBalance(Somme);
        }
    }
    @Override
    public void withdraw(double amount){
        System.out.println("=====Withdraw=====");
        if (amount<=0 || amount>getBalance()){
            System.out.println("Invalid withdrawal amount");
        }else{
            double Soustraction = getBalance() - amount;
            setBalance(Soustraction);
        }
    }
}
