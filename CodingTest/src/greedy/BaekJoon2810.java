package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2810 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int sCount = 0;
		int lCount = 0;
		int cupHolder = 0;
		String sitStructure = br.readLine();
		char[] sit = sitStructure.toCharArray();

		if (n > 1) {
			for (int i = 0; i < n; i++) {
				if ("S".equals(String.valueOf(sit[i]))) {
					sCount++;
				}

				else if ("L".equals(String.valueOf(sit[i]))) {
					lCount++;
				}

			}
			if (lCount != 0) {
				cupHolder = sCount + (lCount / 2) + 1;
			} else {
				cupHolder = sCount;
			}

		} else {
			cupHolder = 1;
		}

		System.out.println(cupHolder);

	}

}
