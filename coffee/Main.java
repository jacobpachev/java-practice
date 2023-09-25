/*
Author: Jacob Pachev
Date: 07/08/23

Stimulates a coffee machine
I did a version of this in python and I'm rewriting it to practice OOP in Java
*/
package coffee;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        CoffeeMachine machine = new CoffeeMachine();
        while (machine.oneAction()) {
            System.out.println("______________________________________");
            System.out.println("\tPRODUCT LIST: all 35 cents, except bouillon (25 cents)");
            System.out.println("\t1=black, 2=white, 3=sweet, 4=white & sweet, 5=boullion");
            System.out.println("\tSample commands: insert 25, select 1");
            System.out.print(">>> Your command: ");
            machine.command = sc.nextLine();
        }
        
        float total = machine.totalCash();
        System.out.printf("Total cash recieved: %.2f%n", total/100.0f);
    }
}
