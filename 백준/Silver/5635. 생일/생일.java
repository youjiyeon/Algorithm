import java.io.*;
import java.util.*;

public class Main {
    public static class Node{
        String name;
        int day, mon, year;
        public Node(String name, int day, int mon, int year) {
            this.name = name;
            this.day = day;
            this.mon = mon;
            this.year = year;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        Node[] students = new Node[T];

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int d = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            students[i] = new Node(str, d, m, y);
        }

        Arrays.sort(students, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.year == o2.year) {
                    if (o1.mon == o2.mon) {
                        return o2.day - o1.day;
                    }
                    else {
                        return o2.mon - o1.mon;
                    }
                }
                return o2.year - o1.year;
            }
        });

        System.out.println(students[0].name);
        System.out.println(students[T-1].name);
    }
}