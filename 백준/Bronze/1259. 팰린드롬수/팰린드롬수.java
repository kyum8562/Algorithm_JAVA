import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();  //숫자 입력받기
            int n = s.length();  //숫자의 개수
            boolean b = true;
            if (s.equals("0")) break;
            for (int i = 0; i <= n/2; i++) {
                if (s.charAt(i) != s.charAt(n-i-1)) b = false;  //앞뒤가 다르면 팰린드롬이 아니다
            }
            if (b) {  //팰린드롬이면 yes 출력
                sb.append("yes\n");
            } else {  //팰린드롬이 아니면 no 출력
                sb.append("no\n");
            }
        }
        System.out.print(sb);
    }
}