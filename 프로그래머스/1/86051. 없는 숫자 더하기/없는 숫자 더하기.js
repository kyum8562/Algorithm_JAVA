function solution(numbers, tmp = 45) {
    // numbers.forEach((v) => tmp -= v)
    return tmp - numbers.reduce((acc, cur) => acc + cur);
}