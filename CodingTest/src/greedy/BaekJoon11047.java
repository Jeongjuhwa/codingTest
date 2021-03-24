package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BaekJoon11047 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int money = Integer.parseInt(st.nextToken());
		Integer[] coin = new Integer[n];

		for (int i = 0; i < n; i++)
			coin[i] = Integer.parseInt(br.readLine());

		// 내림차순
		Arrays.sort(coin, Collections.reverseOrder());

		int count = 0;
		int exchange = money;

		for (int i = 0; i < coin.length; i++) {
			if (exchange >= coin[i]) {
				count += (exchange / coin[i]);
				exchange %= coin[i];
			}

			if (exchange == 0)
				break;

		}

		System.out.println(count);

	}

}
