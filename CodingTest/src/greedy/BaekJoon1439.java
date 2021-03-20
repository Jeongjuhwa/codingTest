package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1439 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] arr = br.readLine().split("");
		int countZero = 0;
		int countOne = 0;

		if (arr[0].equals("0"))
			countZero++;
		else
			countOne++;

		for (int i = 1; i < arr.length; i++) {
			if (!arr[i - 1].equals(arr[i])) {
				if (arr[i].equals("0"))
					countZero++;
				else
					countOne++;
			}
		}

		System.out.println(Math.min(countZero, countOne));

	}

}
