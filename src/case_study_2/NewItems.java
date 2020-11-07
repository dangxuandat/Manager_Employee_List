package case_study_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class NewItems extends Vector<Item> {
    Scanner sc = new Scanner(System.in);
    Vector<String> storeCode = new Vector<>();
    public NewItems(){
        super();
    }
    //load stored code from a text file
    public void loadStoreCode(String fname){
        //clear stored code before loading code
        if(storeCode.size()>0) storeCode.clear();
        try {
            File f = new File(fname);
            if(!f.exists()) return;
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String code;
            String name;
            String price;
            while((code = br.readLine()) != null && (name = br.readLine()) != null && (price = br.readLine()) != null){
                storeCode.add(code);
                fr.close();
                br.close();
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        } 
    }
    private boolean valid(String acode){
        int i;
        for(i = 0; i < storeCode.size();i++){
            if(acode.equals(storeCode.get(i))) return false;
        }
        //check it in new item list
        for(i = 0; i < this.size(); i++){
            if(acode.equals(this.get(i))) return false;
        }
        return true;
    }
    //find a antion code in new-item list 
    private int find(String acode){
        for(int i = 0; i < this.size();i++){
            if(this.get(i).getCode().equals(acode)) return i;
        }
        return -1;
    }
    public void appendToFile(String fname){
        if(this.size() == 0){
            System.out.println("Empty List");
        }
        try {
            boolean appen = true;
            File f = new File(fname);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for(Item x : this){
                pw.println(x.getCode());
                pw.println(x.getName());
                pw.println(x.getPrice());
                pw.flush();
            }
            pw.close();
            fw.close();
            this.loadStoreCode(fname); //reload stored codes
            this.clear();
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        }
    }
    public void addNewItem(){
        String code;
        String name;
        int price;
        boolean duplicated = false;
        boolean matched = true;
        System.out.println("Enter New Item Details: ");
        do {
            System.out.println("Code I000: ");
            code = sc.nextLine().toUpperCase();
            duplicated = !valid(code);
            matched = code.matches("^I\\d{3}$");
        } while (duplicated || !matched);
        System.out.println("Name: ");
        name =sc.nextLine();
        System.out.println("Price: ");
        price = Integer.parseInt(sc.nextLine());
        this.add(new Item(code, name, price));
        System.out.println("New Item has been add");
    }
    public void removeItem(){
        if(this.size() <= 0){ 
            System.out.println("Empty List!!");
            return;
        }
        else{
            String code;
            System.out.println("Enter the code: ");
            code = sc.nextLine();
            int pos = find(code);
            if(pos > 0) this.remove(pos);
            if(pos < 0) System.out.println("This code doesn't exist");
        }
    }
    public void updatePrice(){
        String code;
        int newPrice;
        System.out.println("Enter the code: ");
        code = sc.nextLine();
        int pos = find(code);
        if(pos > 0){
            System.out.println("Enter new Price: ");
            newPrice = Integer.parseInt(sc.nextLine());
            this.get(pos).setPrice(newPrice);
        }
        if(pos < 0 ) System.out.println("This code doesn't exist!!");
    }
    public void print(){
        if(this.size() == 0){
            System.out.println("Empty List");
            return;
        }
        System.out.println("\nITEMS LIST");
        System.out.println("---------------------------");
        for(Item x : this){
            x.print();
        }
    }
}