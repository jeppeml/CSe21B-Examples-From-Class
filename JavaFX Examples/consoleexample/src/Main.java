import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static volatile int s = 0;
    private static Set<Integer> ints = new HashSet<>();

    private static void incS() {
        s = s + 1;
        if (ints.contains(s)){
            System.out.println("Duplicate: " + s);
        }
        else
            ints.add(s);
        System.out.println("s:"+s);
    }
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!");
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        //System.out.println(i);
                        incS();
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            });

            t.start();
        }
        Thread.sleep(1500);
        List<Integer> missing = new ArrayList<>();
        
    }
}