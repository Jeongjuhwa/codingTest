package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon11399 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		int sum = 0;
		int[] sumArr = new int[n];
		
		for(int i =0; i<n;i++) {
			sum +=arr[i];
			sumArr[i] = sum;
		}
		
		int answer = 0;
		
		for(int i =0; i<sumArr.length; i++)
			answer += sumArr[i];
		
		
		System.out.println(answer);

	}

}
