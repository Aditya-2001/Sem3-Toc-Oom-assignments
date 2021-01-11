array = ["a","bc","cde","gf"]
function check(array){
    function inner(x){
        output_array=[]
        for(i=0;i<array.length;i++){
            if(array[i].length==x){
                output_array.push(array[i])
            }
        }
        if(output_array.length==0)
            console.log("No string of length = " + x)
        else{
            console.log(output_array)
        }
    }
    return inner
}

fun = check(array)
while(1){
    t=prompt("Enter number and enter -1 to exit")
    if(t==-1)
        break
    fun(t)
}