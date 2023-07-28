import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for(int i = 1 ; i <= N ; i ++){
            st = new StringTokenizer(br.readLine());
            String curr = st.nextToken();
            if(st.countTokens() == 1) stack.push(Integer.parseInt(st.nextToken()));
            else if(curr.equals("top")) System.out.println(stack.size() == 0 ? -1 : stack.peek());
            else if(curr.equals("empty")) System.out.println(stack.empty() ? 1 : 0);
            else if(curr.equals("size")) System.out.println(stack.size());
            else if(curr.equals("pop")) System.out.println(stack.size() == 0 ? -1 : stack.pop());
        }
    }
}