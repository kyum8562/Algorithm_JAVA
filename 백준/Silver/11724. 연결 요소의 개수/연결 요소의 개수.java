import java.io.*;
import java.util.*;

public class Main {

	static List<ArrayList<Integer>> list;
	static Queue<Integer> q = new ArrayDeque<>();
	static boolean isVisited[];
	static int N, E, start;
	static StringBuilder sb;
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken()); // 노드
		E = stoi(st.nextToken()); // 간선

		list = new ArrayList<>();
		isVisited = new boolean[N+1];

		for(int i = 0 ; i <= N ; i ++) {
			list.add(new ArrayList<>());
		}

		for(int i = 0 ; i < E ; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());

			list.get(a).add(b);
			list.get(b).add(a);
		}

		for(int j = 1 ; j <= N ; j ++) {
			start = j;
			if(!isVisited[start])
				bfs(start);
		}
		System.out.println(ans);
	}

	private static void bfs(int start) {
		q.offer(start);
		isVisited[start] = true;

		while(!q.isEmpty()) {
			start = q.poll();

			for (int j = 0; j < list.get(start).size(); j++) {
				int tmp = list.get(start).get(j);
				if(!isVisited[tmp]) {
					isVisited[tmp] = true;
					q.offer(tmp);
				}
			}
		}
		ans++;
	}

	static int stoi(String a) {
		return Integer.parseInt(a);
	}
}