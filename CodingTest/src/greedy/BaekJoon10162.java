package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon10162 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int input = Integer.parseInt(br.readLine());
		int count300 = 0;
		int count60 = 0;
		int count10 = 0;
		int a = 300;
		int b = 60;
		int c = 10;

		while (input >= 300) {
			input -= 300;
			count300++;
		}

		while (input >= 60) {
			input -= 60;
			count60++;
		}

		while (input >= 10) {
			input -= 10;
			count10++;
		}
		if (input != 0)
			System.out.println(-1);
		else
			System.out.println(count300 + " " + count60 + " " + count10);

	}

}