
package case_study_2;

public class Item {
    String code;
    String name;
    int price;


    public Item(String code, String name, int price){
        this.code = code;
        this.name = name;
        this.price = price;
    }


    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public void print(){
        System.out.println("Code: "+code);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
    
}
