import java.io.*;
import java.util.*;
public class Main {
    static int N, L;
    static List<Node> list;
    static class Node{
        int cur;
        int R;
        int G;
        public Node(int cur, int R, int G){
            this.cur = cur;
            this.R = R;
            this.G = G;
        }
    }
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.add(new Node(a, b, c));
        }

        int time = 0;
        for(int i = 0 ; i < N ; i ++){
            if(i == 0) time += list.get(i).cur;
            else time += (list.get(i).cur - list.get(i-1).cur);

            int allTime = list.get(i).R + list.get(i).G;
            int terms = time/allTime;
            int spareTime = time - (terms*allTime);

            if(list.get(i).R > spareTime)
                time += list.get(i).R - spareTime;
        }
        time += L - list.get(N-1).cur;
        System.out.println(time);
    }
}