package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BaekJoon7562 {

	static int testCase;
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int start_x, start_y, end_x, end_y;
	static int[] dx = { -2, -1, 2, 1, 2, 1, -2, -1 };
	static int[] dy = { 1, 2, 1, 2, -1, -2, -1, -2 };
	static Integer[][] count;
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		testCase = Integer.parseInt(br.readLine());

		while (testCase > 0) {
			testCase--;
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			count = new Integer[N][N];
			visited = new boolean[N][N];
			String str = br.readLine();
			String str2 = br.readLine();

			start_x = Integer.parseInt(str.split(" ")[0]);
			start_y = Integer.parseInt(str.split(" ")[1]);
			end_x = Integer.parseInt(str2.split(" ")[0]);
			end_y = Integer.parseInt(str2.split(" ")[1]);

			bfs(new Point(start_x, start_y));

			if (count[end_x][end_y] == null) {
				list.add(0);
			} else {
				list.add(count[end_x][end_y]);
			}

		}

		for (int answer : list) {
			System.out.println(answer);
		}

	}

	public static void bfs(Point point) {
		Queue<Point> q = new LinkedList<>();
		visited[point.x][point.y] = true;
		count[point.x][point.y] = 0;
		q.offer(point);

		while (!q.isEmpty()) {
			Point point2 = q.poll();
			int x = point2.x;
			int y = point2.y;

			for (int i = 0; i < dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
					if (!visited[nx][ny]) {
						count[nx][ny] = count[x][y] + 1;
						q.offer(new Point(nx, ny));
						visited[nx][ny] = true;
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
