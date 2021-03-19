package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2720 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] exchange = new int[n][4];

		int[] money = new int[n];

		for (int i = 0; i < n; i++) {
			money[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < n; i++) {
			if (money[i] >= 25) {
				exchange[i][0] = money[i] / 25;
				money[i] %= 25;
			}

			if (money[i] >= 10) {
				exchange[i][1] = money[i] / 10;
				money[i] %= 10;
			}

			if (money[i] >= 5) {
				exchange[i][2] = money[i] / 5;
				money[i] %= 5;
			}

			if (money[i] >= 1) {
				exchange[i][3] = money[i] / 1;
				money[i] %= 1;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(exchange[i][j] + " ");
			}
			System.out.println();
		}

	}

}
