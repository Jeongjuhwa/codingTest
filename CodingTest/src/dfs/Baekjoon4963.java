package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon4963 {
	
	static int w;
	static int h;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,1,1,0,-1,-1};
	static int[] dy = {-1,-1,-1,0,1,1,1,0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			String str = br.readLine();
			w = Integer.parseInt(str.split(" ")[0]);
			h = Integer.parseInt(str.split(" ")[1]);
			int cnt = 0;
			if(w ==0 && h == 0) {
				break;
			}
			
			map = new int[h][w];
			visited = new boolean[h][w];
			
			// 섬 위치 추가
			for(int i = 0; i< h; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j = 0 ; j <w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 연결된 섬 구간 탐색
			for(int i = 0; i<h; i++) {
				for(int j = 0; j < w; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						cnt++;
						dfs(i,j);
					}
				}
			}
			System.out.println(cnt);
			
		}
	}
	
	public static void dfs(int y, int x) {
		visited[y][x] = true;
		int nx, ny;
		for(int i = 0; i <8; i++) {
			ny = y+dy[i];
			nx = x+dx[i];
			if(ny>=0 && nx >=0 && ny <h && nx < w) {
				if(map[ny][nx] == 1 && !visited[ny][nx]) {
					dfs(ny, nx);
				}
			}
		}
		
		
	}

}
