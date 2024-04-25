import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int start;
        int end;
        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        int ans = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();
        boolean[] r = new boolean[n];
        List<Node> nodes = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.add(0);

        for (int i = 1; i < n; i++) {
            if (str.charAt(i)=='(') {
                stack.add(i);
            }
            if (str.charAt(i)==')') {
                int in = stack.pop();
                if (str.charAt(i-1)=='(') {
                    r[i] = true;
                    continue;
                }

                nodes.add(new Node(in, i));
            }
        }

        for (Node node : nodes) {
            int tmp = 0;
            for (int i = node.start; i <= node.end; i++) {
                if (r[i]) tmp++;
            }

            ans += tmp+1;
        }

        System.out.println(ans);
    }
}