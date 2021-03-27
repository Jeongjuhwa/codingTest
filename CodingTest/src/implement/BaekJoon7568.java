package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon7568 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int peopleNum = Integer.parseInt(br.readLine());

		int[][] physical = new int[peopleNum][2];

		int[] physicalRank = new int[peopleNum];
		physicalRank[0] = 1;

		for (int i = 0; i < peopleNum; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			physical[i][0] = Integer.parseInt(st.nextToken()); // 몸무게
			physical[i][1] = Integer.parseInt(st.nextToken()); // 키
		}

		int[][] physicalClone = physical.clone();

		for (int i = 0; i < peopleNum; i++) {
			int rank = 1;
			int weight = physicalClone[i][0];
			int height = physicalClone[i][1];
			for (int j = 0; j < peopleNum; j++) {

				if (weight < physical[j][0] && height < physical[j][1]) {
					rank++;
				}

			}
			physicalRank[i] = rank;

		}

		for (int i = 0; i < physicalRank.length; i++)
			System.out.print(physicalRank[i] + " ");

	}

}
