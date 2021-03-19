package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2828 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int screenCnt = Integer.parseInt(st.nextToken());
		int basketCnt = Integer.parseInt(st.nextToken());
		int appleCnt = Integer.parseInt(br.readLine());
		int left = 1;
		int right = basketCnt;
		int[] arr = new int[appleCnt];
		int answer = 0;
		
		for (int i = 0; i < appleCnt; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < appleCnt; i++) {
			if (arr[i] >= left && arr[i] <= right) {
				answer = answer;
			} else if (arr[i] > right) {
				answer += arr[i] - right;
				right = arr[i];
				left = right - (basketCnt - 1);
			} else if (arr[i] < left) {
				answer += left - arr[i];
				left = arr[i];
				right = left + (basketCnt - 1);
			}
		}

		System.out.println(answer);

	}

}
