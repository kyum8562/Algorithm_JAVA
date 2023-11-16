let numbers = ["zero","one","two","three","four","five","six","seven","eight","nine"];
function solution(s) {
    let ans = s;
    for(let i = 0 ; i < numbers.length ; i ++){
        let arr = ans.split(numbers[i]);
        ans = arr.join(i);
        // console.log(ans)
        
    }
    return parseInt(ans);
}

// function solution(s) {
//     s = s.replaceAll("zero", "0")
//     .replaceAll("one", "1")
//     .replaceAll("two", "2")
//     .replaceAll("three", "3")
//     .replaceAll("four", "4")
//     .replaceAll("five", "5")
//     .replaceAll("six", "6")
//     .replaceAll("seven", "7")
//     .replaceAll("eight", "8")
//     .replaceAll("nine", "9")
//     return parseInt(s);
// }