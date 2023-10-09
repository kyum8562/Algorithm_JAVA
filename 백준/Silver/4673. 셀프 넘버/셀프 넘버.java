public class Main {
    static boolean[] v;
    public static void main(String[] args){
        v = new boolean[10001];
        for(int i = 1 ; i <= 10000 ; i ++) play(i);

        for(int i = 1 ; i <= 10000 ; i ++)
            if(!v[i]) System.out.println(i);
    }

    private static void play(int n) {
        // n으로 생성자 만들기
        int tmp = n;
        while(n > 0){
            tmp += n%10;
            n /= 10;

            // 생성자가 10000보다 크다면 return;
            if(tmp > 10000) return;
        }

        // 다 만든 생성자를 v배열에 마킹
        v[tmp] = true;
    }
}