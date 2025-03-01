import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Character, Integer> weight = new HashMap<>();
        String[] s = new String[n];

        for (int i = 0; i < n; i++) {
            s[i] = br.readLine();
            int len = s[i].length();
            for (int j = 0; j < len; j++) {
                char c = s[i].charAt(j);
                weight.put(c, weight.getOrDefault(c, 0) + (int) Math.pow(10, len - j - 1));
            }
        }

        // 가중치 기준 내림차순 정렬
        List<Character> sortedKeys = new ArrayList<>(weight.keySet());
        sortedKeys.sort((a, b) -> Integer.compare(weight.get(b), weight.get(a)));

        // 숫자 할당
        Map<Character, Integer> charToNum = new HashMap<>();
        int num = 9;
        for (char c : sortedKeys) {
            charToNum.put(c, num--);
        }

        // 결과 계산
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int value = 0;
            for (char c : s[i].toCharArray()) {
                value = value * 10 + charToNum.get(c);
            }
            sum += value;
        }

        System.out.println(sum);
    }
}