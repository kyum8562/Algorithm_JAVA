import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] map, map2;
	final static int[] dr = {-1, 0, 1, 0};
    final static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        
        for(int i = 0 ; i < N ; i ++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0 ; j < M ; j ++)
        		map[i][j] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        int cnt = 0;
        
        while((cnt = SeparateNum()) < 2) {
        	if( cnt == 0) {
        		ans = 0;
        		break;
        	}
        	Melt();
        	ans++;
        }
        System.out.println(ans);
	}
	static int SeparateNum() {
		boolean[][] isVisited = new boolean[N][M];
		int cnt = 0;
		
		for(int i = 0 ; i < N ; i ++) {
        	for(int j = 0 ; j < M ; j ++)
        		if(map[i][j] != 0 && !isVisited[i][j]) {
        			dfs(i, j, isVisited);
        			cnt++;
        		}
        }
		return cnt;
	}
	static void dfs(int r, int c, boolean[][] isVisited) {
		isVisited[r][c] = true;
		
		for(int d = 0 ; d < 4 ; d ++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(isVaild(nr, nc)) {
				if(map[nr][nc] != 0 && !isVisited[nr][nc]) {
					dfs(nr, nc, isVisited);
				}
			}
		}
		
	}
	private static void Melt() {
		Queue<Coords> q = new ArrayDeque<>();
		boolean[][] isVisited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    q.offer(new Coords(i, j));
                    isVisited[i][j] = true;
                }
            }
        }
 
        int nr, nc;
        while (!q.isEmpty()) {
            Coords curr = q.poll();
 
            int seaNum = 0; // 빙하 상하좌우에 존재하는 바다 영역의 수.
 
            for (int i = 0; i < 4; i++) {
                nr = curr.r + dr[i];
                nc = curr.c + dc[i];
 
                if(isVaild(nr, nc)) {
                	if (!isVisited[nr][nc] && map[nr][nc] == 0) {
                		seaNum++;
                	}
                }
            }
 
            if (map[curr.r][curr.c] - seaNum < 0) {
                map[curr.r][curr.c] = 0;
            } else {
                map[curr.r][curr.c] -= seaNum;
            }
        }
	}
	static class Coords{
        int r;
        int c;

        public Coords(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static boolean isVaild(int nr, int nc) {
        return (nr>=0 && nr<N && nc>=0 && nc<M);
    }
}