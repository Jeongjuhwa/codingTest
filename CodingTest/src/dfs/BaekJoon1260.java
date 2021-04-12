package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1260 {

	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	static int dotCnt; // 정점의 갯수
	static int nodeCnt; // 간선의 갯수
	static int startNode; // 시작할 정점

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		dotCnt = Integer.parseInt(st.nextToken());
		nodeCnt = Integer.parseInt(st.nextToken());
		startNode = Integer.parseInt(st.nextToken());

		graph = new ArrayList[dotCnt + 1];

		// 그래프 초기화
		for (int i = 0; i <= dotCnt; i++)
			graph[i] = new ArrayList<Integer>();

		String str;
		int v1, v2;
		for (int i = 0; i < nodeCnt; i++) {

			str = br.readLine();
			v1 = Integer.parseInt(str.split(" ")[0]); // .split(" ") 뒤에 [0] 의 의미 -> 자른것 문자열 첫번째.([1]이면 두번째
			v2 = Integer.parseInt(str.split(" ")[1]);

			graph[v1].add(v2);
			graph[v2].add(v1);

		}

		for (int i = 1; i < dotCnt + 1; i++) {
			Collections.sort(graph[i]);
		}

		visited = new boolean[dotCnt + 1];

		dfs(startNode);

		System.out.println();

		for (int i = 0; i < visited.length; i++)
			visited[i] = false;

		bfs(startNode);

	}

	private static void dfs(int start) {

		visited[start] = true;

		System.out.print(start + " ");

		for (int y : graph[start]) {
			if (!visited[y])
				dfs(y);
		}

	}

	private static void bfs(int start) {

		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int x = q.poll();
			System.out.print(x + " ");

			for (int y : graph[x]) {
				if (!visited[y]) {
					visited[y] = true;
					q.offer(y);
				}
			}

		}

	}

}
