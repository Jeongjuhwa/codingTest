package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1012 {

	static int m; // 가로길이(1~50)
	static int n; // 세로길이(1~50)
	static int k; // 배추가 심어져있는 위치의 갯수(1~2500)
	static int[][] maps; // 배추 지도
	static boolean[][] visited;
	static int result; // 최소 벌레 수

	// 북 동 남 서
	static int[] dx = { 0, 1, 0, -1 }; // 가로
	static int[] dy = { -1, 0, 1, 0 }; // 세로

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		for (int i = 0; i < testCase; i++) {

			String str = br.readLine();

			m = Integer.parseInt(str.split(" ")[0]);
			n = Integer.parseInt(str.split(" ")[1]);
			k = Integer.parseInt(str.split(" ")[2]);

			maps = new int[n][m];
			visited = new boolean[n][m];
			result = 0;

			// 배추가 심어져있는 갯수
			int x; // 가로
			int y; // 세로

			for (int j = 0; j < k; j++) {
				str = br.readLine();
				x = Integer.parseInt(str.split(" ")[0]);
				y = Integer.parseInt(str.split(" ")[1]);

				// 지도에 배추 심기
				maps[y][x] = 1;
			}

			// 지렁이 구간 탐색

			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (maps[j][k] == 1 && !visited[j][k]) {
						result++;
						visited[j][k] = true;
						dfs(j, k);
					}

				}
			}
			System.out.println(result);

		}

	}

	private static void dfs(int y, int x) {
		int nx, ny;

		for (int i = 0; i < 4; i++) {
			ny = y + dy[i];
			nx = x + dx[i];

			// 범위 체크
			if (ny >= 0 && nx >= 0 && ny < n && nx < m) {
				// 배추가 있고 방문 안한 곳
				if (maps[ny][nx] == 1 && !visited[ny][nx]) {
					visited[ny][nx] = true;
					dfs(ny, nx);
				}
			}
		}

	}

}
