import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int tgt = Integer.parseInt(st.nextToken());
//            sb.append(upperBound(tgt) - lowerBound(tgt)).append(" ");
            sb.append(bound(tgt, 1) - bound(tgt, 0)).append(" ");
        }

        System.out.println(sb);
    }

    private static int bound(int tgt, int type) {
        int start = 0;
        int mid = 0;
        int end = N;

        while (end > start) {
            mid = (start + end) / 2;

            // lower
            if(type == 0){
                if(arr[mid] >= tgt) end = mid;
                else start = mid + 1;
            }
            // upper
            else {
                if(arr[mid] > tgt) end = mid;
                else start = mid + 1;
            }
        }
        return start;
    }
}