package coffee;

public class CashBox{
    int credit, totalReceived;
    
    public CashBox() {
        credit = 0;
        totalReceived = 0;
    }
    
    public void deposit(int amount) {
        credit += amount;
        totalReceived += amount;
    }
    
    public boolean sufficientFunds(int amount) {
        return credit >= amount;
    }
    
    public void deduct(int amount) {
        credit -= amount;
        if (credit > 0) {
            System.out.printf("Returning %d cents%n", credit);
        }
    }
}  
