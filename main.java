import java.util.Scanner;
import model.CurrentAccount;
import service.BankServiceImpl;

public class main {
    /*
    ## 6) CLI : menu avec Scanner

Dans `Main` :

* créer `Scanner sc = new Scanner(System.in);`
* boucle `while(true)` + menu
* `switch(choice)` pour appeler le service

### Menu exemple (à implémenter)

1. Créer compte épargne
2. Créer compte courant
3. Dépôt
4. Retrait
5. Afficher un compte
6. Lister tous les comptes
7. Quitter

💡 **Pièges Scanner**

* après `nextInt()` ou `nextDouble()`, faire `sc.nextLine()` pour consommer le `\n`
* valider les montants (pas négatifs)

    */
   public static void printLogo() {
    System.out.println("██████╗  █████╗ ███╗   ██╗██╗  ██╗");
    System.out.println("██╔══██╗██╔══██╗████╗  ██║██║ ██╔╝");
    System.out.println("██████╔╝███████║██╔██╗ ██║█████╔╝ ");
    System.out.println("██╔══██╗██╔══██║██║╚██╗██║██╔═██╗ ");
    System.out.println("██████╔╝██║  ██║██║ ╚████║██║  ██╗");
    System.out.println("╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝");
    }
    public static void main(String[] args) {
        printLogo();
        Scanner sc = new Scanner(System.in);
        BankServiceImpl Service = new BankServiceImpl();
        while (true) {
            System.out.println("===== MENU =====");
            System.out.println("1. Create account");
            System.out.println("2. Create Savings Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withraw");
            System.out.println("5. Print account");
            System.out.println("6. Print all accounts");
            System.out.println("0. Exit");
            
            System.out.println("Enter your choice : ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    Service.createCurrentAccount();
                    break;
                case 2:
                    Service.createSavingsAccount();
                    break;
                case 3:
                    Service.deposit();
                    break;
                case 4:
                    Service.withdraw();
                    break;
                case 5:
                    Service.printAccount();
                    break;
                case 6:
                    Service.printAllAccounts();
                    break;
                case 0:
                    System.out.println("Goodbye");
                    return;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
        
    }
}
