package case_study_2;

import java.util.Scanner;

public class ItemManager {
    public static void main(String[] args) {
        String filename = "item.txt";
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        menu.addOption("Add new item");
        menu.addOption("Remove an item");
        menu.addOption("Update an item's price");
        menu.addOption("Print the list");
        menu.addOption("Save to files");
        menu.addOption("Quit");
        int userChoice;
        NewItems list = new NewItems();
        list.loadStoreCode(filename);
        do {
            System.out.println("\nNEW ITEM MANAGER");
            userChoice = menu.getChoice();
            switch(userChoice){
                case 1: list.addNewItem();
                        break;
                case 2: list.removeItem();
                        break;
                case 3: list.updatePrice();
                        break;
                case 4: list.print();
                        break;
                case 5: list.appendToFile(filename);
                        break;
            }
        } while (userChoice > 0 && userChoice <6);
    }
}
