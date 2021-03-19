package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon5585 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int exchange = 1000 - Integer.parseInt(br.readLine());
		int[] coin = {500,100,50,10,5,1};
		int count = 0;
		
		for(int i = 0; i < coin.length; i++) {
			while(exchange >= coin[i]) {
				exchange -= coin[i];
				count++;
			}
		}
		
		System.out.println(count);

	}

}
