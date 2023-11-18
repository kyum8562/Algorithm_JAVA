function solution(n, works) {
    if(works.reduce((a,b) => a+b) <= n) return 0;
    
    works.sort((a,b) => b-a);
    const len = works.length;
    while(n){
        const max = works[0];
        for(let i = 0 ; i < len ; i ++){
            if(works[i] >= max){
                works[i] --;
                n --;
            }
            if(!n) break;
        }
    }
    console.log(works);
    return works.reduce((acc, cur) => acc + Math.pow(cur, 2), 0);
}