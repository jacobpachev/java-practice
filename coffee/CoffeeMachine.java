package coffee;

public class CoffeeMachine {
    CashBox box;
    SelectorClass SelectorClass;
    String command;
    String products[] = {"black", "white", "sweet", "white & sweet", "bouillon"};
    public CoffeeMachine() {
        box = new CashBox();
        command = "original";
        SelectorClass = new SelectorClass(box, products);
    }
    
    public boolean hasVal(int[] list, int val) {
        for (int item : list) {
            if (item == val) {
                return true;
            }
        }
        return false;
    }
    
    public boolean hasVal(String[] list, String val) {
        for (String item : list) {
            if (item.equals(val)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean oneAction() {
        int acceptedCoins[] = {5, 10, 25, 50};
        String commands[] = {"select", "quit", "cancel", "insert", "original"};
        String commandWord = command.split("\\s+")[0];
        if (commandWord.equals("insert")) {
            try {
                int commandNum = Integer.parseInt(command.split(" ")[1]);
                if (hasVal(acceptedCoins, commandNum)) {
                    box.deposit(commandNum);
                    System.out.printf("Depositing %d cents. You have %d cents of credit.%n", commandNum, box.credit);
                }
                else {
                    System.out.println("INVALID AMOUNT >>>");
                    System.out.println("We only take half-dollars, quarters, dimes, and nickels.");
                }
            }
            catch (Exception e) {
                 System.out.println("Invalid");
            }
        }
        
        if (commandWord.equals("select")) {
            try {
                System.out.println(command.split(" ")[1]);
                int commandNum = Integer.parseInt(command.split(" ")[1]);
                if (commandNum > 0 && commandNum < 6) {
                    SelectorClass.select(commandNum-1);
                }
                else {
                    System.out.println("Invalid number to select");
                }
            }
            catch (Exception e) {
                 System.out.println(e);
            }
        }
        
        if (commandWord.equals("cancel")) {
            System.out.printf("Returning %d cents%n", box.credit);
            box.credit = 0;
        }
        
        if(!hasVal(commands, commandWord)) {
            System.out.println("Invalid command");
        }
        return (!commandWord.equals("quit"));
    }
    
    public int totalCash() {
        return box.totalReceived;
    }
}
