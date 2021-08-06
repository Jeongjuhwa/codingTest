package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BaekJoon2178 {
	static int N;
	static int M;
	static int[][] visited;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		N = Integer.parseInt(str.split(" ")[0]);
		M = Integer.parseInt(str.split(" ")[1]);

		map = new int[N][M];
		visited = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] maze = br.readLine().split("");

			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(maze[j]);
			}
		}

		Point startPoint = new Point(0, 0);
		bfs(startPoint);

		System.out.println(visited[N - 1][M - 1]);

	}

	public static void bfs(Point point) {

		Queue<Point> q = new LinkedList<>();

		visited[point.x][point.y] = 1;

		q.offer(point);

		while (!q.isEmpty()) {

			Point pollPoint = q.poll();

			int x = pollPoint.x;
			int y = pollPoint.y;

			for (int i = 0; i < dx.length; i++) {

				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if (map[nx][ny] == 1 && visited[nx][ny] == 0) {
						visited[nx][ny] = visited[x][y] + 1;
						q.offer(new Point(nx, ny));
					}
				}

			}

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
