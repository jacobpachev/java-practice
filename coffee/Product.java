package coffee;

public class Product {
    /*
    Dispenses the drink, knows the price and recipe for the product
    */
    String name;
    int price;
    String[] recipe;
    public Product(String nameProd) {
        name = nameProd;
        recipe = getRecipe(name);
        price = (name == "bouillon") ? 25 : 35;
        
    }

    public void make() {
        System.out.println("Making " + name);
        for (String item : recipe) {
            System.out.println("    Dispensing " + item);
        }
    }
    
    public String[] getRecipe(String name) {
        //dictionary would be much cleaner but populating it is proving tricky
        if (name == "black") {
            String recipe[] = {"cup", "coffee", "water"};
            return recipe;
        }
        if (name == "white") {
            String[] recipe = {"cup", "coffee", "creamer", "water"};
            return recipe;
        }
        if (name == "sweet") {
            String[] recipe = {"cup", "coffee", "sugar", "water"};
            return recipe;
        }
        if (name == "white & sweet") {
            String[] recipe = {"cup", "coffee", "sugar", "creamer", "water"};
            return recipe;
        }
        if (name == "bouillon") {
            String[] recipe = {"cup", "bouillonPowder", "water"};
            return recipe;
        }
        String arr[] = {"1"};
        return arr;
    }
}
