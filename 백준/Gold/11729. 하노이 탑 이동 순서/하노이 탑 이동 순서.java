import java.io.*;

public class Main {
    public static int cnt = 0;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        hanoi(n, 1, 3, 2);

        System.out.println(cnt);
        System.out.print(sb);
    }

    public static void hanoi(int num, int from, int to, int other) {
        if (num == 0) return;
        cnt++;
        hanoi(num - 1, from, other, to);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(num - 1, other, to , from);
    }
}