import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            int histogram_val = sc.nextInt();
            String unit_bar = "=";
            String histogram_bar = unit_bar.repeat(histogram_val);
            
            System.out.println(histogram_bar);
        }
    }
}