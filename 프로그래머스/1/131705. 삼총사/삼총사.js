let len, arr, ans = 0;
let choice;
function solution(number) {
    len = number.length;
    arr = number;
    choice = new Array(len);
    comb(0, 0, 0);
    return ans;
}
function comb(depth, start, sum){
    if(depth == 3){
        let t = choice.reduce((acc, cur, i) => {
            return acc+cur;
        }, 0)
        if(t == 0) ans++;
        return;
    }
    
    for(let i = start ; i < len ; i ++){
        choice[depth] = arr[i];
        comb(depth+1, i+1, sum);
    }
}