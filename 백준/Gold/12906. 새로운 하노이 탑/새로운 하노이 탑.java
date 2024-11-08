import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        Stack<Character>[] h = new Stack[3];

        public Node() {
            for (int i = 0; i < 3; i++) {
                h[i] = new Stack<>();
            }
        }

        public String getNode() {
            String str = "";

            for (char c : h[0]) str += c;
            str += '/';
            for (char c : h[1]) str += c;
            str += '/';
            for (char c : h[2]) str += c;
            str += '/';

            return str;
        }
    }

    static Set<String> set = new HashSet<>();
    static String ans = "";
    static char[] form = {'A','B','C'};
    public static void main(String[] args) throws IOException {
        Node node = new Node();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] cnt = new int[3];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            if (t == 0) continue;
            String str = st.nextToken();
            for (int j = 0; j < t; j++) {
                char tmp = str.charAt(j);
                switch (tmp) {
                    case 'A' :
                        cnt[0]++;
                        break;
                    case 'B' :
                        cnt[1]++;
                        break;
                    case 'C' :
                        cnt[2]++;
                        break;
                }
                node.h[i].add(tmp);
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                ans += form[i];
            }
            ans += '/';
        }

        /*System.out.println(ans);

        for (int i = 0; i < 3; i++) {
            int size = node.h[i].size();
            for (int j = 0; j < size; j++) {
                System.out.print(node.h[i].pop()+" ");
            }
            System.out.println();
        }*/

        System.out.println(bfs(node));
    }

    static int bfs(Node start) {
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        set.add(start.getNode());

        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Node cur = q.poll();

                if (cur.getNode().equals(ans)) {
                    return cnt;
                }

                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (!cur.h[i].isEmpty()) {
                            Node next = copy(cur);

                            next.h[j].push(next.h[i].pop());
                            String str = next.getNode();

                            if (!set.contains(str)) {
                                set.add(str);
                                q.offer(next);
                            }
                        }
                        if (!cur.h[j].isEmpty()) {
                            Node next = copy(cur);

                            next.h[i].push(next.h[j].pop());
                            String str = next.getNode();

                            if (!set.contains(str)) {
                                set.add(str);
                                q.offer(next);
                            }
                        }
                    }
                }
            }

            cnt++;
        }

        return -1;
    }

    static Node copy(Node n) {
        Node res = new Node();

        for (int i = 0; i < 3; i++) {
            for (char c : n.h[i]) res.h[i].push(c);
        }

        return res;
    }
}