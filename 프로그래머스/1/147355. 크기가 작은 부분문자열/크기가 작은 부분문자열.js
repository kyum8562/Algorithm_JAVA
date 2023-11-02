let left = right = len = ans = s = 0;
function solution(t, p) {
    len = p.length;
    right = len;
    let tLen = t.length;
    let tgt = parseInt(p);
    while(right <= tLen){
        s = t.substring(left, right);
        if(tgt >= parseInt(s)) ans++;
        left ++;
        right ++;
        
    }
    
    return ans;
}