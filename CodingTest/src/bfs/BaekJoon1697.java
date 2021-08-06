package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BaekJoon1697 {
	static int N;
	static int K;
	static int[] visited = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		N = Integer.parseInt(str.split(" ")[0]);
		K = Integer.parseInt(str.split(" ")[1]);
		bfs(N);

		System.out.println(visited[K]);

	}

	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();

		q.offer(start);

		while (!q.isEmpty()) {

			int n = q.poll();

			if (n == K) {
				break;
			}
			if (n > 0 && visited[n - 1] == 0) {
				q.offer(n - 1);
				visited[n - 1] = visited[n] + 1;
			}

			if (n < 100000 && visited[n + 1] == 0) {
				q.offer(n + 1);
				visited[n + 1] = visited[n] + 1;

			}

			if (n * 2 <= 100000 && visited[n * 2] == 0) {
				q.offer(n * 2);
				visited[n * 2] = visited[n] + 1;
			}

		}
	}

}
