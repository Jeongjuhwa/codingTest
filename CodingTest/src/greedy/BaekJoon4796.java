package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BaekJoon4796 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		LinkedList<Integer> answerList = new LinkedList<Integer>();

		StringTokenizer st;

		boolean flag = true;

		while (flag) {

			st = new StringTokenizer(br.readLine(), " ");
			int L = Integer.parseInt(st.nextToken()); // 캠핑장 사용가능 일 수 L
			int P = Integer.parseInt(st.nextToken()); // 캠핑장 영업연속 일 수 P
			int V = Integer.parseInt(st.nextToken()); // 내 휴가 일 수 V

			if (L == 0 && P == 0 && V == 0) {
				flag = false;
				break;
			}

			if (V % P > L) {
				int answer = (L * (V / P)) + L;
				answerList.add(answer);
			} else {
				int answer = (L * (V / P)) + (V - (P * (V / P)));
				answerList.add(answer);
			}

		}

		for (int i = 0; i < answerList.size(); i++) {
			System.out.println("Case " + (i + 1) + ": " + answerList.get(i));
		}

	}

}
