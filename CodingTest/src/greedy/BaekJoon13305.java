package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon13305 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		long[] distance = new long[n - 1]; // 거리
		long[] cost = new long[n]; // 비용

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n - 1; i++) {
			distance[i] = Long.parseLong(st.nextToken());

		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			cost[i] = Long.parseLong(st.nextToken());

		}

		long sum = 0;

		long minCost = cost[0];

		for (int i = 0; i < n - 1; i++) {

			if (cost[i] < minCost) {
				minCost = cost[i];
			}

			sum += (minCost * distance[i]);
		}

		System.out.println(sum);

	}

}
