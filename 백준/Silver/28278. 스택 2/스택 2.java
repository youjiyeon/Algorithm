import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int in = Integer.parseInt(st.nextToken());
            switch (in) {
                case 1:
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;

                case 2:
                    if (stack.isEmpty()) {
                        sb.append(-1).append("\n");
                    }
                    else {
                        sb.append(stack.pop()).append("\n");
                    }
                break;

                case 3:
                    sb.append(stack.size()).append("\n");
                    break;

                case 4:
                    if (stack.isEmpty()) {
                        sb.append(1).append("\n");
                    }
                    else {
                        sb.append(0).append("\n");
                    }
                    break;

                case 5:
                    if (stack.isEmpty()) {
                        sb.append(-1).append("\n");
                    }
                    else {
                        sb.append(stack.peek()).append("\n");
                    }
                    break;
            }
        }

        System.out.print(sb);
    }
}