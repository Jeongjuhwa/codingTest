package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2847 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int inputCnt = Integer.parseInt(br.readLine());

		int[] input = new int[inputCnt];
		int[] answer = new int[inputCnt];

		for (int i = 0; i < inputCnt; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

		answer[inputCnt - 1] = 0;

		for (int i = inputCnt - 1; i > 0; i--) {

			if (input[i - 1] >= input[i]) {
				int a = input[i] - 1;
				answer[i - 1] = input[i - 1] - a;
				input[i - 1] = a;

			} else {
				answer[i - 1] = 0;
			}

		}

		int sum = 0;
		for (int i = 0; i < answer.length; i++) {
			sum += answer[i];

		}
		System.out.println(sum);

	}

}
