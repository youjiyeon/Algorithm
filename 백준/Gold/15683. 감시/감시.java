import java.io.*;
import java.util.*;

public class Main {

	static class Node {

		int x;
		int y;
		int val;

		public Node(int x, int y, int val) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}

	static int N, M, result;
	static int[][] map, origin;
	static List<Node> cctvs = new ArrayList<>();

	static int[][][] cctv = { {}, { { 0 }, { 1 }, { 2 }, { 3 } }, { { 0, 1 }, { 2, 3 } },
			{ { 0, 2 }, { 0, 3 }, { 1, 3 }, { 1, 2 } }, { { 0, 1, 2 }, { 0, 2, 3 }, { 0, 1, 3 }, { 1, 2, 3 } },
			{ { 0, 1, 2, 3 } } };
	// 우 좌 상 하
	static int[][] way = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
	static int[] pick;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		origin = new int[N][M];
		// input
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
				if (origin[i][j] >= 1 && origin[i][j] <= 5) {
					cctvs.add(new Node(i, j, origin[i][j]));
				}
			}
		}
		// ---

		pick = new int[cctvs.size()];
		result = Integer.MAX_VALUE;
		perm(0);
		System.out.println(result);
	}

	private static void perm(int cnt) {

		if (cnt == cctvs.size()) {
			// 배열 초기화
			arrayCopy();
			// cctv 가시화
			looking();

			// 사각지대 cnt
			int curBlindCnt = getCurBlindCnt();

			result = Math.min(result, curBlindCnt);

			return;
		}

		for (int i = 0; i < cctv[cctvs.get(cnt).val].length; i++) {
			pick[cnt] = i;
			perm(cnt + 1);
		}
	}

	private static void looking() {

		// 감시 카메라 작동
		for (int i = 0; i < cctvs.size(); i++) {
			Node ctv = cctvs.get(i); // cctv 정보 가져오기

			// dirCase[ cctv번호 ][ 선택한 방향 ]
			// 2번 cctv에 0번 방향이라면 상, 하 델타 인덱스를 뽑아냄
			for (int dir : cctv[ctv.val][pick[i]]) {

				// cctv의 좌표값 받아오기
				int r = ctv.x;
				int c = ctv.y;

				// 해당 방향으로 한 칸씩 이동하며 감시영역 체크
				while (true) {
					// 한 칸 이동
					r += way[dir][0];
					c += way[dir][1];

					// 경계를 벗어나거나 벽(6)인 경우 해당 방향의 검사 마침
					if (r < 0 || r >= N || c < 0 || c >= M || map[r][c] == 6)
						break;

					// 위의 조건을 만족하지 않는다면 감시 영역 체크(-1로 체크)
					map[r][c] = -1;
				}
			}

		}
	}

	private static int getCurBlindCnt() {

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}

	// 감시 카메라
	private static void arrayCopy() {

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = origin[i].clone();
		}

	}

}