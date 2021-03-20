package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BaekJoon2217 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int inputCnt = Integer.parseInt(br.readLine());

		Integer[] input = new Integer[inputCnt];

		for (int i = 0; i < inputCnt; i++) {
			input[i] = Integer.parseInt(br.readLine());

		}

		Arrays.sort(input, Collections.reverseOrder());
		int answer = 0;

		for (int i = 1; i <= inputCnt; i++)
			answer = Math.max(answer, input[i - 1] * i);

		System.out.println(answer);

	}

}
