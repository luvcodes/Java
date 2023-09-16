let a = 0;
if (a) {
    console.log("true");
} else {
    console.log("false");
}

let b = null;
if (b) {
    console.log("true");
} else {
    console.log("false");
}

let c = undefined;
if (c) {
    console.log("true");
} else {
    console.log("false");
}

let d = "";
if (d) {
    console.log("true");
} else {
    console.log("false");
}

/*
* && 且运算
* 有两种情况:
* 1. 当表达式全为真的时候，返回最后一个表达式的值。
* 2. 当表达式中，有一个为假的时候，返回第一个假的表达式的值
* */

let a = "abc";
let b = true;
let d = false;
let c = null;

console.log(a && b); // true
console.log(b && a); // true
console.log(a && d); // false
console.log(a && c); // null

console.log(a && d && c); // false

/*
* || 或运算
* 1. 当表达式全为假时，返回最后一个表达式的值
* 2. 只要有一个表达式为真，就会返回第一个为真的表达式的值
* */
console.log(d || c);
console.log(c || d);
console.log(a || c);
console.log(b || c);