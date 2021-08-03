package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon1068 {

	static int N;
	static int eraN;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static boolean[] visited;
	static int count = 0;
	static int root;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		eraN = Integer.parseInt(br.readLine());

		visited = new boolean[N];

		// 그래프 초기화
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}

		// 그래프 입력
		for (int i = 0; i < N; i++) {

			int parentNode = Integer.parseInt(st.nextToken());

			if (parentNode != -1) {
				graph.get(parentNode).add(i);

			} else {
				root = i;
			}

		}

		if (eraN == root) {
			System.out.println(0);
		} else {
			dfs(root);
			System.out.println(count);
		}

	}

	public static void dfs(int start) {

		visited[start] = true;
		int childNum = 0;
		for (int i = 0; i < graph.get(start).size(); i++) {
			int y = graph.get(start).get(i);

			if (!visited[y] && y != eraN) {
				childNum++;
				dfs(y);
			}
		}
		if (childNum == 0) {
			count++;
		}
	}

}
