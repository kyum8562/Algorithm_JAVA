import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while(T -- > 0){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            double min = x;
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < N-1 ; i ++){
                int V = Integer.parseInt(st.nextToken());
                min = Math.min(min, 1.0 * x/V);
            }
            int myV = Integer.parseInt(st.nextToken());
            if(min > 1.0 * x/myV){
                System.out.println(0);
                continue;
            }
            int left = 0;
            int right = y;

            while (left <= right) {
                int mid = (left + right) / 2;
                double booster = 1 + 1.0 * (x - mid) / myV;
                if (booster >= min) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            // 부스터를 써도 이기지 못하는 경우
            if (left > y) {
                System.out.println(-1);
            } else {
                System.out.println(left);
            }
        }
    }

    private static int bs(int myV, int dist, int maxBoost, double lastTime) {
        // 단독 우승을 하면서, 가장 부스터를 적게 써야함
        // 부스트의 범위를 가지고 이분탐색
        int s = 0;
        int e = maxBoost;

        while(s <= e){
            int m = (s+e)/2;

            int spare = (dist - m);
            double curTime = 1.0* spare/myV + 1;

            if(curTime > lastTime) s = m +1;
            else e = m -1;
        }

        if(s > maxBoost) return -1;
        else return s;
    }
}