package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1475 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String roomNum = br.readLine();

		int[] roomNumArr = new int[roomNum.length()];

		for (int i = 0; i < roomNum.length(); i++)
			roomNumArr[i] = roomNum.charAt(i) - '0';

		double[] count = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		for (int i = 0; i < roomNumArr.length; i++) {
			int eachRoomNum = roomNumArr[i];

			if (eachRoomNum == 6 || eachRoomNum == 9) {
				count[6]++;
			} else {
				count[eachRoomNum]++;
			}

		}

		count[6] = Math.round(count[6] / 2);

		int max = 0;
		for (int i = 0; i < count.length; i++) {
			max = (int) Math.max(max, count[i]);
		}

		System.out.println(max);

	}

}
