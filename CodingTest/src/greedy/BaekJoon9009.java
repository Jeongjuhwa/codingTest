package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class BaekJoon9009 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long testCase = Long.parseLong(br.readLine());

		for (int i = 0; i < testCase; i++) {
			long n = Long.parseLong(br.readLine());
			ArrayList<Long> list = new ArrayList<Long>();
			list.add((long) 0);
			list.add((long) 1);

			for (int j = 2; j < n+1; j++) {
				long firNum = list.get(j - 1);
				long secNum = list.get(j - 2);
				long pivotNum = firNum + secNum;

				if (pivotNum <= n)
					list.add(pivotNum);
				if (pivotNum > n)
					break;
			}

			// 내림차순
			Collections.reverse(list);
			for(long idx2 : list)
				System.out.print(idx2+" ");
			System.out.println();

			Stack<Long> pivotStack = new Stack<Long>();
			int answer = 0;

		

			for (int k = 0; k < list.size()-1; k++) {
				long num = list.get(k);
				if (answer + num <= n) {
					pivotStack.push(num);
					answer += num;

				}

				if (answer == n)
					break;

				

			}

			for (int idx = 0; idx < pivotStack.capacity(); idx++) {
				if (pivotStack.isEmpty())
					break;
				System.out.print(pivotStack.pop() + " ");

			}

			System.out.println();

		}

	}

}
