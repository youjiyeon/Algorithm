import java.io.*;
import java.util.*;

public class Main {
    static class Egg {
        int power;
        int weight;

        public Egg(int power, int weight) {
            this.power = power;
            this.weight = weight;
        }
    }

    static int n, ans = Integer.MIN_VALUE;
    static Egg[] eggs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        eggs = new Egg[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        dfs(0, 0);
        System.out.println(ans);
    }

    static void dfs(int idx, int broken) {
        // 최대 깨진 계란 개수 갱신
        ans = Math.max(ans, broken);

        if (idx >= n) return; // 계란을 다 확인했으면 종료

        // 손에 든 계란이 이미 깨졌으면 다음 계란으로 이동
        if (eggs[idx].power <= 0) {
            dfs(idx + 1, broken);
            return;
        }

        boolean hit = false; // 적어도 한 번이라도 다른 계란을 친 적이 있는지 확인

        for (int i = 0; i < n; i++) {
            if (i == idx || eggs[i].power <= 0) continue; // 같은 계란이거나 이미 깨진 계란이면 건너뜀

            // 현재 계란과 대상 계란을 서로 친다
            eggs[idx].power -= eggs[i].weight;
            eggs[i].power -= eggs[idx].weight;

            int newBroken = broken;
            if (eggs[idx].power <= 0) newBroken++;
            if (eggs[i].power <= 0) newBroken++;

            hit = true; // 한 번이라도 친 적 있음

            dfs(idx + 1, newBroken); // 다음 계란으로 이동

            // 원래 상태로 복원
            eggs[idx].power += eggs[i].weight;
            eggs[i].power += eggs[idx].weight;
        }

        // 만약 다른 계란을 한 번도 치지 못했다면 다음 계란으로 이동
        if (!hit) dfs(idx + 1, broken);
    }
}