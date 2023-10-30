import java.io.*;
import java.util.*;

public class Main {
    static Node[] map;
    static class Node{
        int d;
        int v;
        public Node(int d, int v){
            this.d = d;
            this.v = v;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new Node[12];

        /**
         * 북 4
         * 동 1
         * 남 3
         * 서 2
         *
         * 3 1 3
         * 4, 2, 3, 1
         */
        int maxR = Integer.MIN_VALUE;
        int maxC = Integer.MIN_VALUE;
        for(int i = 0 ; i < 6 ; i ++){
            st = new StringTokenizer(br.readLine());
            int dist = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            map[i] = new Node(dist, val);
            map[i+6] = new Node(dist, val);

            if(dist == 1 || dist == 2)
                maxR = Math.max(maxR, val);
            else
                maxC = Math.max(maxC, val);
        }
        int ans = maxR * maxC;

        int ansIdx = 0;
        // 1 3 2 4 반복
        int[] dist = {4, 2, 3, 1, 4, 2, 3, 1, 4, 2, 3, 1};
        int currD = 0;
        if(map[2].d == 4) currD = 0;
        else if(map[2].d == 2) currD = 1;
        else if(map[2].d == 3) currD = 2;
        else if(map[2].d == 1) currD = 3;

        for(int i = 2 ; i < 12 ; i ++){
            if(map[i].d != dist[currD]){
                ansIdx = i;
                break;
            }
            currD++;
        }
        ans -= map[ansIdx-1].v * map[ansIdx].v;

        System.out.println(ans*N);
    }
}