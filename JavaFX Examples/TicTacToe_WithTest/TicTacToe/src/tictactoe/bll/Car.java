package tictactoe.bll;

public class Car {
    private int price;
    private String name;

    public Car(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public Car(int price) {
        this.price = price;
    }

    public Car() {
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int compareByPrice(Object c) {
        return ((Car)c).getPrice()-this.getPrice();
    }


}
