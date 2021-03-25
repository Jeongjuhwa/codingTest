package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BaekJoon1946 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		for (int i = 0; i < testCase; i++) {
			int num = Integer.parseInt(br.readLine());
			int[][] arr = new int[num][2];

			for (int j = 0; j < num; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");

				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[0] == o2[0])
						return o1[1] - o2[1];
					else
						return o1[0] - o2[0];
				}
			});

			int prev_interview_score = arr[0][1];
			int count = 1;

			for (int k = 0; k < num; k++) {
				if (prev_interview_score > arr[k][1]) {
					count++;
					prev_interview_score = arr[k][1];
				}
			}
			System.out.println(count);

		}

	}

}
