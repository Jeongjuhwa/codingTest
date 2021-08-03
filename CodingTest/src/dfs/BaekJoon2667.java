package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaekJoon2667 {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int aptBlockCnt;
	static int aptCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			String[] str = br.readLine().split("");

			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(str[j - 1]);
			}
		}

		aptBlockCnt = 0;
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					aptBlockCnt++;
					aptCnt = 0;
					dfs(i, j);
					list.add(aptCnt);
				}
			}
		}

		Collections.sort(list);
		System.out.println(aptBlockCnt);

		for (Integer i : list) {
			System.out.println(i);
		}
	}

	public static void dfs(int x, int y) {
		visited[x][y] = true;
		aptCnt++;

		int nx, ny;

		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if (nx > 0 && ny > 0 && nx <= N && ny <= N) {
				if (map[nx][ny] == 1 && !visited[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
	}

}
