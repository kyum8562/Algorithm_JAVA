import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 수 의 개수 N
	 * 합을 구해야 하는 개수 M
	 * 둘째 줄 N개의 수(1~1000)
	 * 셋째 줄 합계를 구해야 하는 구간 i, j
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// int 배열을 만들어 각 인덱스 값에 누적합을 넣어준다.
		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		int sum1 = 0;
		for(int i = 0 ; i < N ; i ++) {
			sum1 += Integer.parseInt(st.nextToken());
			nums[i] = sum1;
		}
		
		// M 만큼 반복하여 구한다
		for(int i = 0 ; i < M ; i ++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int ans = (start == 0) ? nums[end] : (nums[end] - nums[start-1]);
			System.out.println(ans);
		}
	}

}