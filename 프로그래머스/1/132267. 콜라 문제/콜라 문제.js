function solution(a, b, n) {
    let ans = 0;
    while(true){
        // a > 보유중인 빈병 개수: break;
        if(a > n) break;
        
        
        let giving = Math.floor(n/a)*b; // 받을 개수: 마트에 줄 빈병 개수*b
        let spare = n%a; // 남은 빈병
        
        // 빈병개수 갱신
        n = spare + giving;
        
        // ans 갱신
        ans += giving;
    }
    
    return ans;
}