package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2839 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int weight = Integer.parseInt(br.readLine());
		int answer = 0;

		if (weight == 4 || weight == 7) {
			answer = -1;
		} else if (weight % 5 == 0) {
			answer = weight / 5;
		} else if (weight % 5 == 2 || weight % 5 == 4) {
			answer = (weight / 5) + 2;
		} else if (weight % 5 == 1 || weight % 5 == 3) {
			answer = (weight / 5) + 1;
		}

		System.out.println(answer);

	}

}
