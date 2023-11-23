import java.io.*;
import java.util.*;
public class Main {
    static int N, L;
    static boolean[] isSettled;
    static List<Node> list;
    static class Node{
        int cur;
        int R;
        int G;
        int state; // 0: R, 1: G
        int spare;
        public Node(int cur, int R, int G, int state, int spare){
            this.cur = cur;
            this.R = R;
            this.G = G;
            this.state = state;
            this.spare = spare;
        }
    }
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        isSettled = new boolean[1001];
        list = new ArrayList<>();
        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            isSettled[a] = true;
            list.add(new Node(a, b, c, 0, b));
        }

        int cur = 0;
        int time = 0;
        while(cur < L){
            if(isSettled[cur]){ // 신호등이 있는 곳
                for(Node curr: list){
                    if(curr.cur == cur && curr.state == 1){ // 초록 불
                        cur++;
                        time++;
                        break;
                    }
                    else if(curr.cur == cur && curr.state == 0){ // 빨간 불
                        time++;
                        break;
                    }
                }
            }
            else{ // 신호등이 없는 곳
                cur++;
                time++;
            }
            for(int i = 0 ; i < list.size() ; i ++){
                Node curr = list.get(i);
                if(curr.spare-- == 0){ // 신호가 바뀔 때
                    curr.spare = curr.state == 0 ? curr.G -1 : curr.R -1;
                    curr.state = curr.state == 0 ? 1 : 0;
                }
            }

        }
        System.out.println(time-1);
    }
}