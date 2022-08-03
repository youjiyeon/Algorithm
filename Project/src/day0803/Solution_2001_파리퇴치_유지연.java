package day0803;

import java.util.Scanner;

public class Solution_2001_파리퇴치_유지연 {

	public static void main(String[] args) {

		// input
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt();

		// testcase만큼
		for (int t = 1; t <= testcase; t++) {

			// input M, N
			int M = s.nextInt();
			int N = s.nextInt();

			// arr set
			int[][] map = new int[M][M];
			for (int m1 = 0; m1 < M; m1++) {
				for (int m2 = 0; m2 < M; m2++) {
					map[m1][m2] = s.nextInt();
				}
			}

			// find max
			int max = 0;
			int sum = 0;
			int cnt = 0;

			for (int m1 = 0; m1 < M; m1++) {
				for (int m2 = 0; m2 < M; m2++) {

					cnt = 0;
					sum = 0;
					// NxN 탐색
					for (int n1 = m1; n1 < m1 + N; n1++) {
						for (int n2 = m2; n2 < m2 + N; n2++) {
							if (n1 < M && n1 >= 0 && n2 < M && n2 >= 0) {
								sum += map[n1][n2];
								cnt++;
							} else
								break;
						}
					}

					// max와 sum비교
					if (cnt == N * N) {
						max = max < sum ? sum : max;
					}
				}
			}

			// print output
			System.out.printf("#%d %d\n", t, max);
		}

	}

}
