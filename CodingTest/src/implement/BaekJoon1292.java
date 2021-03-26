package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1292 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int startIdx = Integer.parseInt(st.nextToken());
		int endIdx = Integer.parseInt(st.nextToken());

		int[] arr = new int[endIdx];
		int idx = 0;

		for (int i = 0; i <= 45; i++) {
			for (int j = 0; j <= i; j++) {
				arr[idx++] = i + 1;
				if (idx == endIdx)
					break;
			}
			if (idx == endIdx)
				break;
		}

		int sum = 0;
		for (int i = startIdx - 1; i < endIdx; i++) {
			sum += arr[i];
		}
		System.out.println(sum);

	}

}
