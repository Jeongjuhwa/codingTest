package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BaekJoon1966 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		while (testCase-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int inputCnt = Integer.parseInt(st.nextToken());
			int importance = Integer.parseInt(st.nextToken());

			LinkedList<int[]> q = new LinkedList<int[]>();

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < inputCnt; i++)
				q.offer(new int[] { i, Integer.parseInt(st.nextToken()) });

			int count = 0;
			while (!q.isEmpty()) {

				int[] front = q.poll();
				boolean isMax = true;

				for (int i = 0; i < q.size(); i++) {
					if (front[1] < q.get(i)[1]) {
						q.offer(front);

						for (int j = 0; j < i; j++) {
							q.offer(q.poll());
						}

						isMax = false;
						break;
					}
				}

				if (isMax == false)
					continue;

				count++;
				if (front[0] == importance)
					break;

			}
			System.out.println(count);

		}

	}

}
