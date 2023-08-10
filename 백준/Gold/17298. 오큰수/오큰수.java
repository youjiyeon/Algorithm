import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> out = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            stack.push(Integer.parseInt(st.nextToken()));
        }

        while (!stack.isEmpty()){
            if (out.isEmpty()){
                list.add(-1);
                out.push(stack.pop());
            } else if (stack.peek()< out.peek()) {
                list.add(out.peek());
                out.push(stack.pop());
            } else {
                out.pop();
            }
        }

        for (int i = list.size()-1; i >= 0 ; i--) {
            sb.append(list.get(i)+" ");
        }

        System.out.println(sb);
    }
}