package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class BaekJoon10773 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		Stack<Integer> answer = new Stack<Integer>();
		int i = 0;
		int count = 0;
		int flag = 0;
		int recent = 1;
		for (int idx = 0; idx < n; idx++)
			arr[idx] = Integer.parseInt(br.readLine());

		while (count < n) {

			if (arr[i] != 0) {
				answer.push(arr[i]);
			} else {
				answer.pop();
			}

			count++;
			i++;

		}

		int sum = 0;
		for (int idx = 0; idx <= answer.capacity(); idx++) {

			if (answer.isEmpty()) {
				break;
			}

			sum += answer.pop();
		}

		System.out.println(sum);

	}

}
