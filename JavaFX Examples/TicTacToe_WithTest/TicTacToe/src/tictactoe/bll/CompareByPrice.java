package tictactoe.bll;

public class CompareByPrice implements java.util.Comparator<Car> {


    @Override
    public int compare(Car o1, Car o2) {
        return o1.getPrice()-o2.getPrice();
    }
}
