package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon15904 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int index = 0;
		str = str.replaceAll("[a-z]", "");
		str = str.replaceAll(" ", "");

		char[] ucpc = { 'U', 'C', 'P', 'C' };

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ucpc[index]) {
				index++;
				if (index == 4) {
					break;
				}
			}
			
		}
		
		if(index == 4)
			System.out.println("I love UCPC");
		else
			System.out.println("I hate UCPC");

	

	}

}
