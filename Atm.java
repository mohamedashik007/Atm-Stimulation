import java.util.HashMap;
import java.util.Scanner;

class Atm{
  private static Scanner sc= new Scanner(System.in);
  private static HashMap<String,Card> cards= new HashMap<>();
  public static void main(String[] args) {
    String option;

    while(true){

      System.out.println("Welcome to ABC Bank\nPress 1 to continue\nEnter \"exit\" to close");
      option=sc.next();

      switch (option) {
        case "1":
          handleCardOperations();
          break;
        case "exit":
          System.out.println("Thank u! visit again.");
          sc.close();
          System.exit(0);
          break;
        default:
          System.out.println("Enter a valid input..");
          break;
      }
    }
  }
  
  private static void handleCardOperations() {
    String cardNumber;
    sc.nextLine();

    System.out.println("Enter your card number:");
    cardNumber = sc.nextLine();

    // Check if card already exists in HashMap
    if (cards.containsKey(cardNumber)) {
        atmOperations(cardNumber);
    } else {
        // New card details
        String cardHolderName;
        int pin;

        System.out.println("Enter Card Holder name:");
        cardHolderName = sc.nextLine();

        System.out.println("Enter your 4 digit pin:");
        pin = sc.nextInt();

        // Create new Card object
        Card newCard = new Card(cardNumber, cardHolderName, pin);

        // Store the card in HashMap
        cards.put(cardNumber, newCard);

        System.out.println("New card created and logged in for " + cardHolderName);
        atmOperations(cardNumber);
    }
  }

  private static void atmOperations(String cardNumber){
        int checkPin;
        Card existingCard = cards.get(cardNumber);
        String atmOptions;
        boolean isStill=true;
        float amount;

        System.out.println("Enter your pin:");
        checkPin=sc.nextInt();

        //check the atm pin
        if (checkPin ==existingCard.getPin()) System.out.println("logged in");
        else{
          System.out.println("invalid pin number");
          return;
        }
        while(true){
          System.out.println("press\n1.Check balance\n2.withdraw\n3.deposit\n4.transaction history\nEnter \"exit\" to close.");
          atmOptions=sc.next();
          switch (atmOptions) {
            case "1":
              existingCard.balanceCheck();
              break;
            case "2":
              System.out.println("Enter amount to withdraw:");
              amount=sc.nextFloat();
              existingCard.withdraw(amount);
              break;
            case "3":
              System.out.println("Enter amount to deposit:");
              amount=sc.nextFloat();
              existingCard.deposit(amount);
              break;
            case "4":
              existingCard.viewTransaction();
              break;
            case "exit":
              System.out.println("Thank u! visit again.");
              isStill=false;
              break;
            default:
              break;
          }
          if(!isStill) break;
        }
        return;
  }
}