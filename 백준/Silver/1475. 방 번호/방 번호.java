import java.io.*;
import java.util.*;
public class Main {
    static Map<Integer, Integer> map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int res = 0; // 몇 번의 팩을 새로 생성했는지
        map = new LinkedHashMap<>(); // 0~9 수를 확인할 map 자료구조 초기화

        // 주어진 s 순회
        int len = s.length();
        for(int i = 0 ; i < len ; i ++){
            int curr = s.charAt(i) - '0';
            if(curr == 9) curr = 6;

            // 해당 수를 가지지 못했다면
            if(map.getOrDefault(curr, 0) == 0){
                addNewPack();
                res++;
            }
            map.put(curr, map.get(curr)-1);
        }

        System.out.println(res);
    }
    private static void addNewPack(){
        for(int i = 0 ; i < 9 ; i ++){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        map.put(6, map.get(6)+1);
    }
}