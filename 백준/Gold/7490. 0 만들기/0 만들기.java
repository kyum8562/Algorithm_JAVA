import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int t=1; t<=TC; t++) {
            int N = Integer.parseInt(br.readLine());

            dfs(N, 1, new char[N]);
            ans.append('\n');
        }
        System.out.printf("%s", ans.toString());
    }

    public static void dfs(int N, int cnt, char[] arr) {
        if(cnt==N) {
            if(result(arr, N)) {
                for(int i=1; i<=N; i++) {
                    if(i!=N) {
                        ans.append(i).append(arr[i]);
                    } else {
                        ans.append(i);
                    }
                }
                ans.append('\n');
            }
            return;
        }

        arr[cnt] = ' ';
        dfs(N, cnt+1, arr);
        arr[cnt] = '+';
        dfs(N, cnt+1, arr);
        arr[cnt] = '-';
        dfs(N, cnt+1, arr);
    }

    public static boolean result(char[] arr, int N) {
        int sum = 0;
        for(int i=N; i>1; i--) {
            int num = i;
            if(arr[i-1] == '+') {
                sum+=num;
            } else if(arr[i-1] == '-') {
                sum-=num;
            } else {
                int result = i;
                int cnt = 1;
                while(arr[i-1] == ' ') {
                    i--;
                    result = i*(int)Math.pow(10, cnt++)+result;
                }
                if(i-1 >=1 && arr[i-1] == '-') {
                    sum-=result;
                } else {
                    sum+=result;
                }
            }
        }
        if(arr[1] != ' ') {
            sum+=1;
        }
        if(sum == 0) return true;
        else return false;
    }
}