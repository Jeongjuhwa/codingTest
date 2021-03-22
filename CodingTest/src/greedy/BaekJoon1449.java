package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1449 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());
		int count = 1;
		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);

		int start = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - start >= length) {
				count++;
				start = arr[i];
			}
		}

		System.out.println(count);

	}

}
