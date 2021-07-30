package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baekjoon11725 {
	static int nodeCnt;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static boolean[] visited;
	static int[] nodeParents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		nodeCnt = Integer.parseInt(br.readLine());
		nodeParents = new int[nodeCnt + 1];

		// 그래프 초기화
		for (int i = 0; i <= nodeCnt; i++) {
			graph.add(new ArrayList<Integer>());
		}

		// 그래프 채우기
		String str;
		int v1, v2;
		for (int i = 0; i < nodeCnt - 1; i++) {
			str = br.readLine();
			v1 = Integer.parseInt(str.split(" ")[0]);
			v2 = Integer.parseInt(str.split(" ")[1]);

			graph.get(v1).add(v2);
			graph.get(v2).add(v1);

		}

		visited = new boolean[nodeCnt + 1];
		dfs(1);
		
		// 인덱스 0은 원래 안쓰고 1은 최상위 노드라 비어있고 2부터 출력 ㄱ
		for(int i = 2; i< nodeParents.length; i++) {
			System.out.println(nodeParents[i]);
		}

	}
	
	public static void dfs(int start) {
		visited[start] = true;
		for(int i = 0; i<graph.get(start).size();i++) {
			int y = graph.get(start).get(i);
			if(!visited[y]) {
				nodeParents[y] = start;
				dfs(y);
			}
		}
	}

}
