package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon2606 {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static boolean[] visited;
	static int comCnt;
	static int nodeCnt;
	static int cnt;

	private static void dfs(int start) {

		visited[start] = true;

		for (int i = 0; i < graph.get(start).size(); i++) {
			int y = graph.get(start).get(i);

			if (!visited[y]) {
				visited[y] = true;

				cnt++;
				dfs(y);
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		comCnt = Integer.parseInt(br.readLine()); // 컴퓨터 수
		nodeCnt = Integer.parseInt(br.readLine()); // 네트워크 연결 수

		visited = new boolean[comCnt + 1];

		// 그래프 초기화
		for (int i = 0; i <= comCnt; i++)
			graph.add(new ArrayList<Integer>());

		String str;
		int v1, v2;
		for (int i = 0; i < nodeCnt; i++) {
			/*
			 * 이렇게 입력받지 말자 StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			 * graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken
			 * ()));
			 */
			str = br.readLine();
			v1 = Integer.parseInt(str.split(" ")[0]); // .split(" ") 뒤에 [0] 의 의미 -> 자른것 문자열 첫번째.([1]이면 두번째
			v2 = Integer.parseInt(str.split(" ")[1]);
			System.out.print("v1: " + v1 + " v2: " + v2 + "\n");
			graph.get(v1).add(v2);
			graph.get(v2).add(v1);

		}

		cnt = 0;
		dfs(1);

		System.out.println(cnt);

	}

}
