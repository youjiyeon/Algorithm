import java.io.*;
import java.util.*;

class Main {
    static class Node {
        char type;
        List<Integer> door;
        int value;
        boolean v;
        public Node(char type, List<Integer> door, int value, boolean v){
            this.type = type;
            this.door = door;
            this.value = value;
            this.v = v;
        }
    }

    static List<Node> list;
    static int n, res;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                res = 0;

                st = new StringTokenizer(br.readLine());
                char c = st.nextToken().charAt(0);
                int value = Integer.parseInt(st.nextToken());
                List<Integer> l = new ArrayList<>();
                while (true) {
                    int tmp = Integer.parseInt(st.nextToken());
                    if (tmp==0) break;
                    l.add(tmp-1);
                }

                list.add(new Node(c, l, value, false));
            }

            dfs(0, 0);
            sb.append(res == 1 ? "Yes" : "No").append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int start, int money) {
        // 트롤이면 소지금 뺏김
        if (list.get(start).type == 'T') money -= list.get(start).value;
        else {
            if (money < list.get(start).value) {
                money += list.get(start).value;
            }
        }

        // 소지금이 있다면
        if (money >= 0) {
            if (start+1 == n) {
                res = 1;
                return;
            }

            list.get(start).v = true;
            for (int i = 0; i < list.get(start).door.size(); i++) {
                if (!list.get(list.get(start).door.get(i)).v) {
                    dfs(list.get(start).door.get(i), money);
                }
            }
            //list.get(start).v = false;
        }
    }
}