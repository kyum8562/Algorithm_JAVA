import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];

        int left = 0, right = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++){
            map[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, map[i]);
        }

        M = Integer.parseInt(br.readLine());

        binarySearch(left, right);
    }

    private static void binarySearch(int left, int right) {
        while(left <= right){
            int mid = (left + right) / 2;

            long budget = 0;
            for(int i = 0 ; i < N ; i ++){
                if(map[i] > mid) budget += mid;
                else budget += map[i];
            }

            if(M >= budget) left = mid + 1;
            else right = mid -1;
        }

        System.out.println(right);
    }
}