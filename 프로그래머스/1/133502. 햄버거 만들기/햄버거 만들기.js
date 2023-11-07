function solution(ingredient) {
    let stk = [];
    let count = 0;
    for (let i = 0; i < ingredient.length; i++) {
        stk.push(ingredient[i]);
        if (
            stk[stk.length-1] === 1 &&
            stk[stk.length-2] === 3 &&
            stk[stk.length-3] === 2 &&
            stk[stk.length-4] === 1
        ) {
            count++;
            stk.splice(-4);
        }
    }
    return count;
}

/**
function solution(ingredient) {
    const stk = [];
    let cnt = 0;
    
    ingredient.forEach((ing, idx)=>{
        stk.push(ing);  
       
        if(stk.length >= 4){
            const find = stk.slice(-4).join('');
            if(find === '1231'){
                stk.pop();
                stk.pop();
                stk.pop();
                stk.pop();   
                cnt++;
            }
        } 
    })
    
    return cnt;
}
**/