import java.io.*;
import java.util.*;

public class Main {
	static int R, C, ans = Integer.MIN_VALUE;
	static int[][] map;
//	static int[] dr = {-1, 0, 1, 0};
//	static int[] dc = {0, 1, 0, -1};
	static int[][][] blocks_R = {
			{{0, 0, 0, 0}, {0, 1, 2, 3}, {0, 0, 0, 0}, {0, -1, -2, -3}}, // 1번의 R
			{{0, 0, 1, 1}, {0, 0, 1, 1}, {0, 0, -1, -1}, {0, 0, -1, -1}},
			{{0, 1, 2, 2}, {0, 0, 0, 1}, {0, 0, 1, 2}, {0, 0, 0, -1}, {0, 1, 2, 2}, {0, 0, 0, 1}, {0, 0, 1, 2}, {0, 0, 0, -1}},
			{{0, 1, 1, 2}, {0, 0, -1, -1}, {0, 0, 1, 1}, {0, 1, 1, 2}},
			{{0, 0, 0, 1}, {0, 0, -1, 1}, {0, 0, 0, -1}, {0, 0, -1, 1}}
	};
	static int[][][] blocks_C = {
			{{0, 1, 2, 3}, {0, 0, 0, 0}, {0, -1, -2, -3}, {0, 0, 0, 0}}, // 1번의 C
			{{0, 1, 0, 1}, {0, -1, -1, 0}, {0, -1, 0, -1}, {0, 1, 0, 1}},
			{{0, 0, 0, 1}, {0, 1, 2, 0}, {0, 1, 1, 1}, {0, 1, 2, 2}, {0, 0, 0, -1}, {0, -1, -2, 0}, {0, -1, -1, -1}, {0, -1, -2, -2}},
			{{0, 0, 1, 1}, {0, 1, 1, 2}, {0, 1, 1, 2}, {0, 0, -1, -1}},
			{{0, 1, 2, 1}, {0, 1, 1, 1}, {0, 1, 2, 1}, {0, 1, 0, 0}}
	};
	static int[] blocks_dir = {4, 4, 8, 4, 4};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];

		for(int i = 0 ; i < R ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < C ; j ++) {
				map[i][j] = stoi(st.nextToken());
			}
		}

		for(int i = 0 ; i < R ; i ++) {
			for(int j = 0 ; j < C ; j ++) {
				game(i, j);
			}
		}

		System.out.println(ans);
	}

	static void game(int r, int c) {

		for(int a = 0 ; a < 5 ; a ++) {
			for(int i = 0 ; i < blocks_dir[a] ; i ++) {
				int cnt = 0;
				boolean flag = true;
				// 4가지 블럭
				for(int d = 0 ; d < 4 ; d ++) {
					int nr = r + blocks_R[a][i][d];
					int nc = c + blocks_C[a][i][d];

					if(isVaild(nr, nc)) {
						// 가려는 방향의 값을 더해줌
						cnt += map[nr][nc];
					}
					else {
						// 가려는 방향 중 하나라도 map에서 벗어난다면 -> 해당 루프 탈출
						flag = false;
						break;
					}
				}

				// 4칸 모두 유효하다면
				if(flag) {
					// ans 중 큰 값을 ans에 저장함
					ans = Math.max(ans, cnt);
				}
			}
		}
	}
	static boolean isVaild(int nr, int nc) {
		return (nr>=0 && nc>=0 && nr<R && nc<C);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}