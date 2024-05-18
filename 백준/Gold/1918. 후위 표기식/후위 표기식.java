import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'A' && arr[i] <= 'Z') {
                sb.append(arr[i]);
            }
            else if (arr[i] == '(') {
                stack.add('(');
            }
            else if (arr[i] == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                // '(' pop
                if (!stack.isEmpty()) stack.pop();
            }
            // 연산자
            else {
                while (!stack.isEmpty() && order(stack.peek()) >= order(arr[i])) {
                    sb.append(stack.pop());
                }
                stack.add(arr[i]);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.print(sb);
    }

    static int order(char c) {
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
        return 0;
    }
}