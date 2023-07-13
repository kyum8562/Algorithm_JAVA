import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        LCS2(str1, str2);
        LCSToString(str1, str1.length(), str2.length());

        System.out.println(sb);
    }
        static void LCS2 (String str1, String str2) {
            int r = str1.length();
            int c = str2.length();

            dp = new int[r+1][c+1];
            for(int i=1; i<r+1; i++) {
                for(int j=1; j<c+1; j++) {
                    if(str1.charAt(i-1) == str2.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1] +1;
                    }else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }

            sb.append(dp[r][c] + "\n");
        }

        static void LCSToString(String str, int i, int j) {
            Stack<Character> st = new Stack<>();
            while(i>0 && j>0) {

                if(i == 0 || j ==0)break;

                if(dp[i][j] == dp[i-1][j]) {
                    i--;
                }else if(dp[i][j] == dp[i][j-1]) {
                    j--;
                }else {
                    st.push(str.charAt(i-1));
                    i--;
                    j--;
                }

            }
            while(!st.isEmpty()) {
                sb.append(st.pop());
            }


        }
}