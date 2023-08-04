import java.io.*;
import java.util.*;

/**
 * 1. 입력을 받으면서  CCTV(1~5)를 리스트에 좌표(r, c)를 담는다.
 * 2. 백트래킹(dfs)을 진행하면서 순열로 cctv 개수만큼 뽑는다.
 * 3. (2에서 다 뽑았다면) cctv별 번호(1~5)를 확인하고 움직이는 방향을 map3에 담음
 * 3-1. map2에 map을 복사
 * 4. 방향을 담은 map3를 순회하면서 map2안에 범위 포함 + 벽이 아니면 해당 값을 7로 변경
 * 5. 4를 유효범위까지 감시처리
 * 6. map2를 전부 순회하면서 0 카운트 후 ans 업데이트
 * 7. 2~6 반복이 끝나면 ans 출력
 */
public class Main {
	static int N, M, K, ans = Integer.MAX_VALUE;
	static int[][] map;
	static List<Coords> cctvList;
	static Stack<Integer> cctv = new Stack<>();
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		map = new int[N][M];
		cctvList = new ArrayList<>();
		
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j ++) {
				int tmp = stoi(st.nextToken());
				map[i][j] = tmp;
				if(tmp > 0 && tmp < 6)
					cctvList.add(new Coords(i, j));
			}
			K = cctvList.size();
		}
		dfs();
		System.out.println(ans);
	}

	static void dfs() {
		if(cctv.size() == K) {
			action();
			return;
		}
		
		for(int d = 0 ; d < 4 ; d ++) {
			cctv.push(d);
			dfs();
			cctv.pop();
		}
	}

	static void action() {
		int[][] map2 = new int[N][M];
		for(int i = 0 ; i < N ; i ++) map2[i] = map[i].clone();
		
		for(int i = 0 ; i < K ; i ++) {
			int r = cctvList.get(i).r;
			int c = cctvList.get(i).c;
			int d = cctv.get(i);
			int[] map3;
			
			if(map[r][c] == 1)
				map3 = new int[] {d};
			else if(map[r][c] == 2)
				map3 = new int[] {d, d+2};
			else if(map[r][c] == 3)
				map3 = new int[] {d, d+1};
			else if(map[r][c] == 4)
				map3 = new int[] {d, d+1, d+2};
			else
				map3 = new int[] {d, d+1, d+2, d+3};
			
			for(int idx : map3) {
				int dd = (idx) % 4;
				int nr = r + dr[dd];
				int nc = c + dc[dd];
				
				while(isVaild(nr, nc) && map[nr][nc] != 6) {
					map2[nr][nc] = 7;
					nr += dr[dd];
					nc += dc[dd];
				}
			}
		}
		int cnt = 0;
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < M ; j ++) {
				if(map2[i][j] == 0) cnt++;
			}
		}
		
		ans = Math.min(cnt, ans);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static boolean isVaild(int nr, int nc) {
		return (nr>=0 && nr<N && nc>=0 && nc<M);
	}

	static class Coords{
		int r;
		int c;

		public Coords(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}