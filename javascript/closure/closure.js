// Closure function

// Nested function
// Inner function can access the variable/object of outer function ( enclosing scope / lexical scope )
// outer function must return inner function ( this is the differentiator b/w nested function and closure function)

//Closure function
function forgotpassword(email){
    // validate email id
    function generesendotp(){
        // logic 2
        a=a+b
        console.log(a) // a is neither a local scope nor global scope. a is enclosing scope with respect to inner function
    }
    return [inner,iner1]
}

// Forgot Password
r= forgotpassword('anasnak@gmai,co')
r()
r()
r()
r()

//Nested function
function add(a){
    function inner(b){
        console.log(a) // a is neither a local scope nor global scope. a is enclosing scope with respect to inner function
    }
}


//--------------------------------------------

l=["qwerty","abc","bad","sadest"]
length=3
