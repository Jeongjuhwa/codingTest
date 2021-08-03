package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2468 {
	static int N;
	static int[][] map;
	static int[][] transMap;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int safeZoneCnt;
	static int defaultCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];

		// map 채우기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i + 1][j + 1] = Integer.parseInt(st.nextToken());
			}
		}

		defaultCnt = 1;
		// transMap 채우기
		for (int i = 1; i < 101; i++) {
			transMap = new int[N + 1][N + 1];
			safeZoneCnt = 0;

			visited = new boolean[N + 1][N + 1];

			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					if (map[j][k] <= i) {
						transMap[j][k] = 0;
					} else {
						transMap[j][k] = 1;
					}
				}
			}

			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					if (transMap[j][k] == 1 && !visited[j][k]) {
						dfs(j, k);
						safeZoneCnt++;
					}
				}
			}
			defaultCnt = Math.max(defaultCnt, safeZoneCnt);

		}

		System.out.println(defaultCnt);

	}

	public static void dfs(int x, int y) {
		visited[x][y] = true;

		int nx, ny;

		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if (nx > 0 && ny > 0 && nx <= N && ny <= N) {
				if (transMap[nx][ny] == 1 && !visited[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
	}

}
