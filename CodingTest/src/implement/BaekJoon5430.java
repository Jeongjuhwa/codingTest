package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

import java.util.StringTokenizer;

public class BaekJoon5430 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int testCase = Integer.parseInt(br.readLine());

		while (testCase > 0) {
			String str = br.readLine();

			String[] strArr = str.split("");

			int arrCnt = Integer.parseInt(br.readLine());
			String inputArr = br.readLine();
			inputArr = inputArr.replaceAll("\\[", "");
			inputArr = inputArr.replaceAll("\\]", "");
			StringTokenizer st = new StringTokenizer(inputArr, ",");
			Deque<Integer> dq = new LinkedList<Integer>();
			boolean printLeft = true;
			boolean errorFlag = true;

			for (int i = 0; i < arrCnt; i++)
				dq.add(Integer.parseInt(st.nextToken()));

			for (int i = 0; i < strArr.length; i++) {
				String method = strArr[i];

				if ("R".equals(method)) {
					if (printLeft == true) {
						printLeft = false;
					} else if (printLeft == false) {
						printLeft = true;
					}
				} else if ("D".equals(method)) {

					if (dq.isEmpty()) {
						errorFlag = false;
						break;
					} else {
						if (printLeft == true) {
							dq.pollFirst();

						} else if (printLeft == false) {
							dq.pollLast();

						}

					}

				}

			}

			if (dq.isEmpty() && errorFlag == false) {
				// System.out.println("error");
				sb.append("error\n");
			} else if (dq.isEmpty() && errorFlag == true) {
				// System.out.println("[]");
				sb.append("[]\n");
			} else {
				// System.out.print("[");
				sb.append("[");
				if (printLeft == true) {
					while (dq.size() > 1) {
						// System.out.print(dq.pollFirst() + ",");
						sb.append(dq.pollFirst() + ",");
					}

				} else if (printLeft == false) {
					while (dq.size() > 1) {
//						System.out.print(dq.pollLast() + ",");
						sb.append(dq.pollLast() + ",");
					}

				}

				// System.out.print(dq.poll() + "]\n");
				sb.append(dq.poll() + "]\n");
			}

			testCase--;

		}
		System.out.println(sb);

	}

}
