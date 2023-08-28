import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static Stack<Node> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    static Queue<Node> q = new ArrayDeque<>();
    static class Node{
        int n;
        int idx;
        Node(int n, int idx){
            this.n = n;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i ++)
            q.offer(new Node(Integer.parseInt(st.nextToken()), i));

        while(!q.isEmpty()){
            
            if(stack.size() == 0){
                stack.push(q.poll());
                sb.append(0).append(" ");
            }
            else if(stack.peek().n > q.peek().n){
                sb.append(stack.peek().idx).append(" ");
                stack.push(q.poll());
            }
            else stack.pop();
        }

        System.out.println(sb);
    }
}