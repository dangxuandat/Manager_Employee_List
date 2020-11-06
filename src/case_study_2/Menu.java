package case_study_2;

import java.util.ArrayList;
import java.util.Scanner;


public class Menu extends ArrayList<String> {
    String hints[] = new String[6];
    int size = 0;
    public Menu(){
        super();
    }
    public void addOption(String s){
        if(size < hints.length){
            hints[size++] = s;
        }
    }
    public int getChoice(){
        int result = 0;
        int flag = 1;
        if(size > 0){
            for(int i = 0; i < hints.length;i++) System.out.println((i+1) + " - " + hints[i]);
            do {
                try {
                    System.out.println("Select an Operation");
                    Scanner sc = new Scanner(System.in);
                    result= Integer.parseInt(sc.nextLine());
                    flag = 0;
                } catch (Exception e) {
                    //TODO: handle exception
                    System.out.println(e);
                }
            } while (flag == 1);
        }
        return result;
    }
}
