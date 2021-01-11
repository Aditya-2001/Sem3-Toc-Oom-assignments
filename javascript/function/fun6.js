add();

//func expression
const add=function () {
    console.log('Hello.');
}

// var declaration and var assignment supports hoisting
// let declaration and let assignment doesn't supports hoisting
// const declaration and const assignment doesn't supports hoisting
// function declaration(function add(){}) supports hoisting 
// function expression doesn't supports hoisting
// function expression with let, const keyword throws reference error
// function expression with var keyword throws type error
