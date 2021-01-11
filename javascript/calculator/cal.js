function add(array){
    return array[0]+array[1]
}

function sub(array){
    return array[0]-array[1]
}

function mul(array){
    return array[0]*array[1]
}

function pow(array){
    return array[0]**array[1]
}

function parseno(n){
    var array=[]
    var i=0
    while((i++)<n){
        var number=parseFloat(prompt("Enter number: "))
        array.push(number)
    }
    return array
}

function scientific_calculator(){
    var sc_cal_active=true
    while(sc_cal_active){
        choice = parseInt(prompt("1->add, 2->sub, 3->mul, 4->pow, 0->exit"))
        if(choice>=1 && choice<=4)
            var array=parseno(2)
        switch(choice){
            case 1:     var result=add(array)
                        alert(array[0] + " + " + array[1] + " = " + result)
                        break
            case 2:     var result=sub(array)
                        alert(array[0] + " - " + array[1] + " = " + result)
                        break
            case 3:     var result=mul(array)
                        alert(array[0] + " * " + array[1] + " = " + result)
                        break
            case 4:     var result=pow(array)
                        alert(array[0] + " ^ " + array[1] + " = " + result)
                        break
            case 0:     sc_cal_active=false
                        break
            default:    alert("Invalid Input")   
        }
    }
}

function simple_calculator(){
    var cal_active=true
    while(cal_active){
        choice = parseInt(prompt("1->add, 2->sub, 3->mul, 0->exit"))
        if(choice>=1 && choice<=3)
            var array=parseno(2)
        switch(choice){
            case 1:     var result=add(array)
                        alert(array[0] + " + " + array[1] + " = " + result)
                        break
            case 2:     var result=sub(array)
                        alert(array[0] + " - " + array[1] + " = " + result)
                        break
            case 3:     var result=mul(array)
                        alert(array[0] + " * " + array[1] + " = " + result)
                        break
            case 0:     cal_active=false
                        break
            default:    alert("Invalid Input")   
        }
    }
}

function hybrid_calculator(){
    choosen=true
    while(choosen){
        choice=parseInt(promt("Hey! user press 1 for simple calculator or 2 for scientific calculator and 0 to exit: "))
        switch(choice){
            case 1:     simple_calculator()
                        break
            case 2:     scientific_calculator()
                        break
            case 0:     choosen=false
                        break
            default:    alert("Invalid Input")   
        }    
    }
}

function getmessage(calltype){
    return (calltype==1)?"1->add, 2->sub, 3->mul, 0->exit":"1->add, 2->sub, 3->mul, 4->pow, 0->exit"
}  

function hybrid_cal(){
    var cal_active=true
    while(cal_active){
        caltype = parseInt(prompt("Hey! user press 1 for simple calculator or 2 for scientific calculator: "))
        if(caltype!=1 && caltype!=2){
            alert("Invalid Input")
            continue
        }
        var choice=parseInt(prompt(getmessage(caltype)))
        if(choice>=1 && choice<=((caltype==1)?3:4))
            var array=parseno(2)
        switch(caltype.toString() + choice){
            case "11":
            case "21":  var result=add(array)
                        alert(array[0] + " + " + array[1] + " = " + result)
                        break
            case "12": 
            case "22":  var result=sub(array)
                        alert(array[0] + " - " + array[1] + " = " + result)
                        break
            case "13":
            case "23":  var result=mul(array)
                        alert(array[0] + " * " + array[1] + " = " + result)
                        break
            case "24":  var result=pow(array)
                        alert(array[0] + " ^ " + array[1] + " = " + result)
                        break
            case "10": 
            case "20":  cal_active=false
                        break
            default:    alert("Invalid Input")   
        }
    }
}

hybrid_cal()