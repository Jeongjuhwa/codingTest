package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baekjoon11724 {
	
	static int dotCnt;
	static int nodeCnt;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static boolean[] visited;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		dotCnt = Integer.parseInt(str.split(" ")[0]);
		nodeCnt = Integer.parseInt(str.split(" ")[1]);
		
		// 그래프 초기화
		for(int i = 0; i <=dotCnt; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		// 그래프 채우기
		for(int i =1; i<= nodeCnt; i++) {
			String str2 = br.readLine();
			int v1 = Integer.parseInt(str2.split(" ")[0]);
			int v2 = Integer.parseInt(str2.split(" ")[1]);
			
			graph.get(v1).add(v2);
			graph.get(v2).add(v1);
			
		}
		
		visited = new boolean[dotCnt + 1];
		
		for(int i = 1; i<=dotCnt; i++) {
			if(!visited[i]) {
				cnt++;
				dfs(i);
			}
		}
		System.out.println(cnt);
	}
	
	public static void dfs(int start) {
		visited[start] = true;
		
		for(int i = 0; i< graph.get(start).size(); i++) {
			int y = graph.get(start).get(i);
			if(!visited[y]) {
				dfs(y);
			}
				
		}
	}

}
