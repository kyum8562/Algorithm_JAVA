import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long min = Long.MAX_VALUE;
    static long[] map, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new long[N];
        ans = new long[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) map[i] = Long.parseLong(st.nextToken());

        Arrays.sort(map);

        for (int start = 0; start < N - 2; start++) twoPointer(start);


        System.out.println(map[(int)ans[0]] + " " + map[(int)ans[1]] + " " + map[(int)ans[2]]);
    }

    private static void twoPointer(int start) {
        int mid = start + 1;
        int end = N - 1;

        while (mid < end) {
            long sum = Math.abs(map[start] + map[mid] + map[end]);
            if (min > sum) {
                min = sum;
                ans[0] = start;
                ans[1] = mid;
                ans[2] = end;
            }
            if (map[start] + map[mid] + map[end] >= 0) end--;
            else mid++;
        }
    }
}