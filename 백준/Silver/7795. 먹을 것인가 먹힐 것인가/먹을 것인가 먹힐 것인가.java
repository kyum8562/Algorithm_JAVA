import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int ans = 0;
            int[] arr = new int[N];
            int[] arr2 = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++)
                arr2[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(arr);
            Arrays.sort(arr2);

            int l = N - 1;
            int r = M - 1;
            int tgt = r / 2;

            // 1 1 [3] 7 8
            // 1 3 6

            while (l >= 0) {
                if(r == -1){
                    r = M-1;
                    l --;
                    continue;
                }
                if (arr[l] > arr2[r]) {
                    ans += r+1;
                    l--;
                } else {
                    // 오른쪽이 더 크거나 같다면
                    if (arr[l] <= arr2[r]) {
                        r--;
                    } else {
                        ans += r+1;
                        r = M - 1;
                        l--;
                    }
                }
            }

            System.out.println(ans);
        }
    }
}