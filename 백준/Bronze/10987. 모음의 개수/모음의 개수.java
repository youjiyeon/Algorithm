import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] c = {'a','e','i','o','u'};
        int cnt = 0;

        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            for (int j = 0; j < 5; j++) {
                if (a==c[j]){
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}