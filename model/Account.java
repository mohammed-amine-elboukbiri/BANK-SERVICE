package model;
/*
### Champs à mettre dans `Account`

* `id` (String ou int)
* `ownerName` (String)
* `balance` (double)

### Méthodes dans `Account`

* `deposit(double amount)`
* `withdraw(double amount)` (peut être abstraite si tu veux forcer les règles par type)
* `toString()` (affichage propre)

💡 **Révision** :

* `private` champs + `public` getters/setters (encapsulation)
* `protected` si tu veux accessible aux classes filles.

---
*/
public abstract class Account {
    public int id;
    public String ownerName;
    public double balance;
    
    public Account(){
        this.id = 0;
        this.ownerName = "Null";
        this.balance = 0.0;
    }
    public Account(int id,String ownerName,double balance){
        this.id = id;
        this.ownerName = ownerName;
        this.balance = balance;
    }
    public Account(Account other){
        this.id = other.id;
        this.ownerName = other.ownerName;
        this.balance = other.balance;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getOwnerName(){
        return ownerName;
    }
    public void setOwnerName(String ownerName){
        this.ownerName = ownerName;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    @Override
    public String toString(){
        return( " the infos of the account : " + id + "\n" +
            " Owner Name : "+ ownerName + "\n" +
            " Balance : " + balance 
        );
    }
}
