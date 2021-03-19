package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon14659 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int i = 0;
		int j = 0;
		int count = 0;
		int arr[] = new int[n];
		int cnt[] = new int[1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		cnt[0] = 0;

		for (int k = 0; k < n; k++) {

			arr[k] = Integer.parseInt(st.nextToken());
		}

		while (n - 1 > i) {
			j++;
			if (j == n) {
				if (cnt[0] < count) {
					cnt[0] = count;
					count = 0;
				}
				break;
			}
			if (arr[i] > arr[j]) {
				// System.out.println(j);
				count++;
			} else if(arr[i] < arr[j]) {
				i = i + 1;
				j = i;
				if (cnt[0] < count) {
					cnt[0] = count;
					
				}
				count = 0;

			}

		}

		System.out.println(cnt[0]);

	}

}
