debugger
var a=5
function add(){
    b=45
    console.log(b)
    function sub(){
        c=43
        console.log(c)
        console.log(b)
    }
    sub()
}
console.log(a)
add()
console.log(a)