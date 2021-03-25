package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon11497 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		for (int i = 0; i < testCase; i++) {
			int woodNum = Integer.parseInt(br.readLine());
			int[] arr = new int[woodNum];
			int[] sortArr = new int[woodNum];

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < woodNum; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			int max = arr[woodNum - 1];

			int count = 0;
			int lIdx = 0;
			int rIdx = woodNum - 1;
			Arrays.sort(arr);

			for (int j = 0; j < woodNum; j++) {
				if (j % 2 != 0) {
					sortArr[lIdx] = arr[j];
					lIdx += 1;
				} else {
					sortArr[rIdx] = arr[j];
					rIdx -= 1;
				}
			}

			int min = Math.abs(sortArr[0] - sortArr[woodNum - 1]);

			for (int idx = 1; idx < woodNum; idx++) {
				min = Math.max(min, Math.abs(sortArr[idx] - sortArr[idx - 1]));
			}

			System.out.println(min);

		}

	}

}
