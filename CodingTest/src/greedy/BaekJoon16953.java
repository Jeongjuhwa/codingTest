package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon16953 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		int answer = 1;
		while (B != A) {
			if (B < A) {
				answer = -1;
				break;
			}

			String strB = String.valueOf(B);

			if (strB.charAt(strB.length() - 1) != '1' && B % 2 != 0) {
				answer = -1;
				break;
			}

			if (B % 2 == 0) {
				B /= 2;
			} else {
				strB = strB.substring(0, strB.length() - 1);
				B = Long.parseLong(strB);
			}

			answer++;
		}
		System.out.println(answer);

	}

}
