import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] map;
    static List<Integer> list;
    static class Node{
        int r;
        int c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Queue<Node> q;

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken())+1;

            map = new int[N+1];
            st = new StringTokenizer(br.readLine());
            q = new ArrayDeque<>();
            list = new ArrayList<>();
            for(int i = 1 ; i <= N ; i ++){
                map[i] = Integer.parseInt(st.nextToken());
                if(i == M) q.offer(new Node(map[i], 1));
                else q.offer(new Node(map[i], 0));
                list.add(map[i]);
            }

            Collections.sort(list, Collections.reverseOrder());
            int idx = 0;
            while(!q.isEmpty()){
                Node curr = q.poll();

                if(list.get(idx) == curr.r){
                    idx++;

                    if(curr.c == 1) break;
                }
                else{
                    q.offer(new Node(curr.r, curr.c));
                }
            }
            System.out.println(idx);
        }

    }
}