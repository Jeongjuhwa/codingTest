package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BaekJoon2644 {

	public static boolean[] visited;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static int people; // 사람 수
	static int startNode; // 찾아야하는 사람 1
	static int endNode; // 찾아야하는 사람 2
	static int m; // 관계의 수
	static int ans = -1;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		people = Integer.parseInt(br.readLine());
		String peopleRelation = br.readLine();
		startNode = Integer.parseInt(peopleRelation.split(" ")[0]);
		endNode = Integer.parseInt(peopleRelation.split(" ")[1]);
		m = Integer.parseInt(br.readLine());

		// 그래프 초기화
		for (int i = 0; i <= people; i++) {
			graph.add(new ArrayList<Integer>());
		}

		// 노드 연결
		String str;
		int v1, v2;
		for (int i = 0; i < m; i++) {
			str = br.readLine();
			v1 = Integer.parseInt(str.split(" ")[0]);
			v2 = Integer.parseInt(str.split(" ")[1]);

			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
		}

		visited = new boolean[people + 1];
		dfs(startNode, 0);
		System.out.print(ans);

	}

	public static void dfs(int start, int count) {
		visited[start] = true;

		for (int i = 0; i < graph.get(start).size(); i++) {
			int y = graph.get(start).get(i);

			if (!visited[y]) {
				if (y == endNode) {
					ans = count + 1;
					return;
				}
				dfs(y, count + 1);
			}
		}
	}

}
