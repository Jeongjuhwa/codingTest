package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1476 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int e = 1;
		int s = 1;
		int m = 1;
		boolean flag = true;

		int count = 1;
		while (flag) {

			if (E == 1 && S == 1 && M == 1)
				break;

			e++;
			s++;
			m++;
			if (e > 15) {
				e = 1;
			}
			if (s > 28) {
				s = 1;
			}
			if (m > 19) {
				m = 1;
			}
			count++;
			if (e == E && s == S && m == M)
				flag = false;

		}

		System.out.println(count);

	}

}
