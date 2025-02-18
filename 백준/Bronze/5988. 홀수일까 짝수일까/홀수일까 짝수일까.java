import java.io.*;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] k = br.readLine().split("");
            System.out.println(Integer.parseInt(k[k.length-1])%2==0 ? "even" : "odd");
        }
    }
}