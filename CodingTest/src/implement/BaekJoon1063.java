package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1063 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		String king = st.nextToken();
		String stone = st.nextToken();
		int moveCnt = Integer.parseInt(st.nextToken());

		int kingX = king.charAt(0) - 'A';
		int kingY = king.charAt(1) - 49;
		int stoneX = stone.charAt(0) - 'A';
		int stoneY = stone.charAt(1) - 49;

		for (int i = 0; i < moveCnt; i++) {
			String move = br.readLine();

			switch (move) {
			case "R":
				if (kingX < 7) {
					kingX++;
					if (kingX == stoneX && kingY == stoneY) {
						if (stoneX < 7)
							stoneX++;
						else
							kingX--;
					}
				}

				break;

			case "L":
				if (kingX > 0)
					kingX--;
				if (kingX == stoneX && kingY == stoneY) {
					if (stoneX > 0)
						stoneX--;
					else
						kingX++;

				}
				break;

			case "B":
				if (kingY > 0) {
					kingY--;
					if (kingX == stoneX && kingY == stoneY) {
						if (stoneY > 0)
							stoneY--;
						else
							kingY++;
					}
				}

				break;

			case "T":
				if (kingY < 7)
					kingY++;
				if (kingX == stoneX && kingY == stoneY) {
					if (stoneY < 7)
						stoneY++;
					else
						kingY--;

				}
				break;

			case "RT":
				if (kingY < 7 && kingX < 7) {
					kingY++;
					kingX++;
					if (kingX == stoneX && kingY == stoneY) {
						if (stoneY < 7 && stoneX < 7) {

							stoneX++;
							stoneY++;
						} else {
							kingX--;
							kingY--;
						}
					}
				}

				break;

			case "LT":
				if (kingY < 7 && kingX > 0) {
					kingY++;
					kingX--;
					if (kingX == stoneX && kingY == stoneY) {
						if (stoneY < 7 && stoneX > 0) {

							stoneY++;
							stoneX--;
						} else {
							kingY--;
							kingX++;
						}
					}
				}

				break;

			case "RB":
				if (kingY > 0 && kingX < 7) {
					kingY--;
					kingX++;
					if (kingX == stoneX && kingY == stoneY) {
						if (stoneY > 0 && stoneX < 7) {
							stoneY--;
							stoneX++;

						} else {
							kingY++;
							kingX--;
						}
					}
				}

				break;

			case "LB":
				if (kingX > 0 && kingY > 0) {
					kingX--;
					kingY--;
					if (kingX == stoneX && kingY == stoneY) {
						if (stoneX > 0 && stoneY > 0) {
							stoneX--;
							stoneY--;

						} else {
							kingX++;
							kingY++;
						}
					}
				}

			default:
				break;

			}
		}

		String kingStr = "";
		kingStr += (char) (kingX + 65);
		System.out.println(kingStr + (kingY + 1));
		String stoneStr = "";
		stoneStr += (char) (stoneX + 65);
		System.out.println(stoneStr + (stoneY + 1));

	}

}
