import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Card {
  private String cardNumber;
  private String cardHolderName;
  private int pin;
  private float balance=10000f;
  private Queue<ArrayList<String>> transactionHistory = new LinkedList<>(); // only store last 5 transactions

  public Card(String cardNumber, String cardHolderName, int pin) {
      this.cardNumber = cardNumber;
      this.cardHolderName = cardHolderName;
      this.pin = pin;
  }

  public String getCardNumber() {
      return cardNumber;
  }

  public String getCardHolderName() {
      return cardHolderName;
  }

  public int getPin() {
      return pin;
  }

  //get date and time for transaction history
  public String getDateTime(){
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
  }

  public void balanceCheck(){
    System.out.println("Available Balance:"+(int) balance);
  }

  public void deposit(float amount){
    if((int) amount%100==0 || (int) amount%500 == 0){
      balance+=amount;
      System.out.println((int) amount +" is deposited successfully!");
      System.out.println("Available balance:"+(int) balance);
      addTransaction(amount,"deposit");
    }else{
      System.out.println("Enter amount in multiplies of 100 or 500");
    }
  }

  public void withdraw(float amount){
    if((int) amount%100==0 || (int) amount%500 == 0){
        if((int)balance>=(int)amount){
        balance-=amount;
        System.out.println((int)amount +"is withdrawn successfully!");
        System.out.println("Available balance:"+(int) balance);
        addTransaction(amount, "withdraw");
        }else{
            System.out.println("Insufficient balance.");
        }
    }
    else {
        System.out.println("Enter amount in multiplies of 100 or 500");
    }

  }
  private void addTransaction(float amount,String type){
    ArrayList<String> transaction =new ArrayList<>();
    transaction.add(getDateTime());
    transaction.add(getCardHolderName());
    transaction.add(type);
    transaction.add(Integer.toString((int)amount));
    transaction.add(Integer.toString((int)balance));
    transactionHistory.add(transaction);

    if(transactionHistory.size()>5) transactionHistory.remove();
  }
  public void viewTransaction(){
    System.out.println("Last 5 transactions...\n");

    // Print table header
    System.out.printf("%-20s %-15s %-10s %-10s %-10s\n", "Date Time", "Card Holder", "Type", "Amount", "Balance");
    System.out.println("--------------------------------------------------------------");

    // Print each transaction
    for (ArrayList<String> transaction : transactionHistory) {
        String dateTime = transaction.get(0);
        String cardHolderName = transaction.get(1);
        String type = transaction.get(2);
        String amount = transaction.get(3);
        String balance = transaction.get(4);
        System.out.printf("%-20s %-15s %-10s %-10s %-10s\n", dateTime, cardHolderName, type, amount, balance);
    }
  }
  public void changePassword(int newPin){
    pin=newPin;
  }
}