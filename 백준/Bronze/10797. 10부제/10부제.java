import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for(int t = 0; t < 5; t++){
            if(sc.nextInt() == n){
                count++;
            }
        }
        System.out.println(count);
    }
}