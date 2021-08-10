package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BaekJoon2589 {

	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		N = Integer.parseInt(str.split(" ")[0]);
		M = Integer.parseInt(str.split(" ")[1]);
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] str2 = br.readLine().split("");

			for (int j = 0; j < M; j++) {
				if ("L".equals(str2[j])) {
					map[i][j] = 1;
				}
			}
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					visited = new boolean[N][M];
					int result = bfs(new Point(i, j, 0));
					answer = Math.max(answer, result);
				}
			}
		}

		System.out.println(answer);

	}

	public static int bfs(Point point) {
		Queue<Point> q = new LinkedList<>();
		q.offer(point);
		int count = 0;
		visited[point.x][point.y] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();
			int x = p.x;
			int y = p.y;

			int nx, ny;

			for (int i = 0; i < 4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if (map[nx][ny] == 1 && !visited[nx][ny]) {
						q.offer(new Point(nx, ny, p.cnt + 1));
						visited[nx][ny] = true;
						count = Math.max(count, p.cnt + 1);
					}
				}
			}
		}
		return count;
	}

	static class Point {

		int x;
		int y;
		int cnt;

		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;

		}
	}

}
