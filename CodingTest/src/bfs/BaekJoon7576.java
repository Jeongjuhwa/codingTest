package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon7576 {
	static int N;
	static int M;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static Queue<Point> q;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		N = Integer.parseInt(str.split(" ")[0]);
		M = Integer.parseInt(str.split(" ")[1]);
		map = new int[M][N];
		q = new LinkedList<Point>();

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					q.offer(new Point(i, j));
				}
			}
		}

		System.out.println(bfs());

	}

	public static int bfs() {

		while (!q.isEmpty()) {
			Point t = q.poll();

			int x = t.x;
			int y = t.y;

			for (int i = 0; i < dx.length; i++) {

				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
					if (map[nx][ny] == 0) {
						q.offer(new Point(nx, ny));
						map[nx][ny] = map[x][y] + 1;
					}
				}
			}

		}

		int result = 0;

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					return -1;
				}
				result = Math.max(result, map[i][j]);
			}
		}
		if (result == 1) {
			return 0;
		} else {
			return result - 1;
		}
	}

	static class Point {

		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;

		}
	}

}
