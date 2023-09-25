package coffee;

public class SelectorClass {
    /*
    Knows what the products are and what is selected, is in charge of drink making
    */
    CashBox box;
    String[] products;
    public SelectorClass(CashBox boxParam, String[] productsParam) {
        box = boxParam;
        products = productsParam;
    }
    
    public void select(int choiceIndex) {
        String productName = products[choiceIndex];
        Product product = new Product(productName);
        if (box.sufficientFunds(product.price)) {
            product.make();
            box.deduct(product.price);
        }
        else {
            System.out.println("Sorry. Not enough money deposited.");
        }
    }
    
    
}
