import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N+1][8];
        for(int i = 1 ; i <= N ; i ++){
            String s = br.readLine();
            for(int j = 0 ; j < s.length() ; j ++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        // n극:0, S극:1
        int cnt = Integer.parseInt(br.readLine());
        while(cnt-- > 0){
            st = new StringTokenizer(br.readLine());
            int curr = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()); // 시계:1, 반시계:-1

            // 3번을 기준으로 양 옆에 전이 되는지 확인(다른 극이다)
            int[] check = new int[N+1];
            // 우측
            int tmpD = d;
            for(int i = curr ; i < N ; i ++){
                if(map[i][2] != map[i+1][6]){
                    // 반대방향 이동
                    tmpD = (tmpD == 1) ? -1 : 1;
                    check[i+1] = tmpD;
                }
                else break;
            }
            // 좌측
            tmpD = d;
            for(int i = curr ; i > 1 ; i --){
                if(map[i][6] != map[i-1][2]){
                    // 반대방향 이동
                    tmpD = (tmpD == 1) ? -1 : 1;
                    check[i-1] = tmpD;
                }
                else break;
            }
            for(int i = 1 ; i <= N ; i ++){
                if(check[i] != 0)
                    rotation(i, check[i]);
                else if(curr == i)
                    rotation(curr, d);
            }
        }

        int ans = 0;
        for(int i = 1 ; i <= N ; i ++){
            if(map[i][0] == 1) ans++;
        }
        System.out.println(ans);
    }

    private static void rotation(int curr, int type) {

        if(type == 1){ // 시계
            int tmp = map[curr][7];
            for(int i = 6 ; i >= 0 ; i -- ){
                map[curr][i+1] = map[curr][i];
            }
            map[curr][0] = tmp;
        }
        else{ // 반시계
            int tmp = map[curr][0];
            for(int i = 0 ; i < 7 ; i ++ ){
                map[curr][i] = map[curr][i+1];
            }
            map[curr][7] = tmp;
        }
    }
}