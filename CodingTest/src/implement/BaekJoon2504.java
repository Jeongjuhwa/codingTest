package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BaekJoon2504 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();

		Stack<String> stack = new Stack<String>();

		boolean isAble = true;

		for (int i = 0; i < input.length(); i++) {

			String str = input.substring(i, i + 1);

			if ("(".equals(str)) {
				stack.push(")");
				continue;
			}

			if ("[".equals(str)) {
				stack.push("]");
				continue;
			}

			int sum = 0;

			while (true) {

				if (stack.isEmpty()) {
					isAble = false;
					break;

				}

				if (isNumber(stack.peek())) {
					sum += Integer.parseInt(stack.pop());
				} else {

					if (str.equals(stack.peek())) {
						stack.pop();
						int num = (")".equals(str)) ? 2 : 3;

						if (sum == 0) {
							stack.push(String.valueOf(num));
						} else {
							stack.push(String.valueOf(num * sum));
						}
						break;
					} else {
						isAble = false;
						break;
					}

				}

			}

			if (!isAble)
				break;

		}

		int answer = 0;

		while (!stack.isEmpty()) {
			if (isNumber(stack.peek())) {
				answer += Integer.parseInt(stack.pop());
			} else {
				isAble = false;
				break;
			}
		}

		if (isAble)
			System.out.println(answer);
		else
			System.out.println(0);

	}

	private static boolean isNumber(String str) {
		if (str.equals(")") || str.equals("]"))
			return false;
		return true;
	}

}
