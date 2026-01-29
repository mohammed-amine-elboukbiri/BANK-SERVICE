## 1) Objectif du Bank CLI

Tu vas construire une application console qui permet de :

* créer un compte
* déposer / retirer
* afficher le solde
* lister les comptes
* quitter

Le tout en utilisant :

* **POO** (classes/objets)
* **héritage** (ex: `Account` → `SavingsAccount`, `CurrentAccount`)
* **interface** (ex: opérations bancaires)
* **implémentation** (classes qui `implements`)
* **Scanner** (lecture clavier)
* collections (`ArrayList`, `Map`) + `switch`

---

## 2) Structure recommandée (packages / classes)

Tu peux faire ça simple :

* `Main.java` (menu + Scanner)
* `model/Account.java` (classe abstraite)
* `model/SavingsAccount.java` (hérite)
* `model/CurrentAccount.java` (hérite)
* `service/BankService.java` (interface)
* `service/BankServiceImpl.java` (implémente)
* `service/AccountNotFoundException.java` (optionnel, pour réviser exceptions)

---

## 3) Modèle POO : Account (abstraite)

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

## 4) Héritage : SavingsAccount / CurrentAccount

### `SavingsAccount extends Account`

* ajoute `interestRate`
* ajoute méthode `applyInterest()`

### `CurrentAccount extends Account`

* ajoute `overdraftLimit` (découvert autorisé)
* redéfinit `withdraw()` pour autoriser le découvert

💡 **Révision** :

* `@Override`
* `super(...)` dans le constructeur
* différence entre **polymorphisme** : `Account a = new SavingsAccount(...)`

---

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

---

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

---

## 7) Règles métier simples (à coder)

* dépôt : montant > 0
* retrait :

  * épargne : pas de découvert, balance doit rester ≥ 0
  * courant : balance peut descendre jusqu’à `-overdraftLimit`
* si compte introuvable : message clair (ou exception)

---

## 8) Bonus révision (si tu veux monter d’un niveau)

* Créer une exception `AccountNotFoundException`
* Ajouter une interface `Printable` avec `String format()`
* Ajouter historique transactions (`List<Transaction>`)
* Sauvegarde simple fichier texte (facultatif)

---

## 9) Checklist de révision (super utile)

Tu peux te tester en cochant :

* [ ] J’ai une classe `Account` avec encapsulation (private + getters)
* [ ] J’utilise `extends` et `super`
* [ ] J’ai au moins 2 classes filles avec `@Override`
* [ ] J’ai une `interface` et une classe `implements`
* [ ] Mon `Main` utilise `Scanner` + boucle + `switch`
* [ ] Je stocke les comptes dans une collection (Map ou List)
* [ ] Je gère les erreurs (montant invalide, compte absent)

