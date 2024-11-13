import java.util.*;

class Solution {
    static class Node {
        int prev, next;
        boolean isDeleted;
        
        public Node(int prev, int next) {
            this.prev = prev;
            this.next = next;
            this.isDeleted = false;
        }
    }
    
    public String solution(int n, int k, String[] cmd) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i - 1, i + 1);
        }
        nodes[n - 1].next = -1; // 마지막 노드 처리
        
        Stack<Integer> removed = new Stack<>();
        int current = k;
        
        for (String command : cmd) {
            String[] parts = command.split(" ");
            char action = parts[0].charAt(0);
            
            if (action == 'U') {
                int x = Integer.parseInt(parts[1]);
                while (x-- > 0) current = nodes[current].prev;
            } else if (action == 'D') {
                int x = Integer.parseInt(parts[1]);
                while (x-- > 0) current = nodes[current].next;
            } else if (action == 'C') {
                removed.push(current);
                nodes[current].isDeleted = true;
                
                if (nodes[current].prev != -1) nodes[nodes[current].prev].next = nodes[current].next;
                if (nodes[current].next != -1) nodes[nodes[current].next].prev = nodes[current].prev;
                
                current = (nodes[current].next != -1) ? nodes[current].next : nodes[current].prev;
            } else if (action == 'Z') {
                int restored = removed.pop();
                nodes[restored].isDeleted = false;
                
                if (nodes[restored].prev != -1) nodes[nodes[restored].prev].next = restored;
                if (nodes[restored].next != -1) nodes[nodes[restored].next].prev = restored;
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(nodes[i].isDeleted ? 'X' : 'O');
        }
        
        return result.toString();
    }
}