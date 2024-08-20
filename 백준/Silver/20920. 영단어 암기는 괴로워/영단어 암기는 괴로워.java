import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력: 단어의 개수 'n'과 최소 단어 길이 'm'을 읽음
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        // HashMap을 사용하여 길이가 'm' 이상인 단어들과 그 개수를 저장
        Map<String, Integer> map = new HashMap<>();
        
        // 'n'개의 단어를 읽으며, 길이가 'm' 이상인 단어의 등장 횟수를 세어 map에 저장
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.length() < m) continue; // 길이가 'm' 미만인 단어는 무시
            map.put(s, map.getOrDefault(s, 0) + 1); // 이미 나온 단어인 경우 카운트 증가, 처음 나온 단어인 경우 1로 설정
        }
        
        // map에서 단어들을 가져와서 ArrayList에 저장
        List<String> words = new ArrayList<>(map.keySet());
        
        // words 리스트를 정렬
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 자주 등장하는 단어 순서대로 정렬
                if (Integer.compare(map.get(o1), map.get(o2)) != 0) {
                    return Integer.compare(map.get(o2), map.get(o1));
                }
                // 등장 횟수가 같으면 길이가 긴 단어가 먼저 오도록 정렬
                if (o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                }
                // 등장 횟수와 길이가 같으면 사전 순으로 정렬
                return o1.compareTo(o2);
            }
        });
        
        // 정렬된 단어들을 출력
        StringBuilder sb = new StringBuilder();
        for (String str : words) {
            sb.append(str + "\n");
        }
        System.out.println(sb);
    }
}