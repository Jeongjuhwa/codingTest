package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon15903 {

	public static void main(String[] args) throws IOException {

//		처음 구현 -> 통과는 했지만 시간이 좀 많이 걸림
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//		int card = Integer.parseInt(st.nextToken());
//		int count = Integer.parseInt(st.nextToken());
//		long[] arr = new long[card];
//
//		st = new StringTokenizer(br.readLine(), " ");
//
//		for (int i = 0; i < card; i++)
//			arr[i] = Long.parseLong(st.nextToken());
//
//		for (int i = 0; i < count; i++) {
//			Arrays.sort(arr); -> for문 한 번 수행할때마다 정렬 비효율적
//			long sum = arr[0] + arr[1];
//			arr[0] = arr[1] = sum;
//		}
//
//		long answer = 0;
//		for (int i = 0; i < arr.length; i++)
//			answer += arr[i];
//
//		System.out.println(answer);

//		=====================================================================
//			우선순위 큐 구현
//		=====================================================================
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int card = Integer.parseInt(st.nextToken());
		int count = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		PriorityQueue<Long> arr = new PriorityQueue<Long>();

		for (int i = 0; i < card; i++) {
			arr.add(Long.parseLong(st.nextToken()));
		}

		for (int i = 0; i < count; i++) {
			long firCard = arr.poll();
			long secCard = arr.poll();
			long sum = firCard + secCard;
			arr.add(sum);
			arr.add(sum);
		}

		long answer = 0;
		for (int i = 0; i < card; i++)
			answer += arr.poll();

		System.out.println(answer);

	}

}
