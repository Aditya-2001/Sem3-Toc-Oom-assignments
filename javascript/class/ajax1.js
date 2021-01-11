function ajax(CallBackFun){
    var ajax_object = new XMLHttpRequest()
    
    ajax_object.onreadystatechange = function (){
        if (this.readyState == 4 && this.status == 200) {
            CallBackFun(this)
        }
    }
    ajax_object.open("GET",'https://jsonplaceholder.typicode.com/todos/1',true)
    ajax_object.setRequestHeader("Access-Control-Allow-Origin","*")
    ajax_object.setRequestHeader("Content-Type", "text/plain;charset=UTF-8");
    ajax_object.send()
}

function ajax_new(CallBackFun){
    var ajax_object = new XMLHttpRequest()
    
    ajax_object.onreadystatechange = function (){
        if (this.readyState == 4 && this.status == 200) {
            CallBackFun(this)
        }
    }
    ajax_object.open("GET",'https://jsonplaceholder.typicode.com/todos/1',true)
    ajax_object.setRequestHeader("Access-Control-Allow-Origin","*")
    ajax_object.setRequestHeader("Content-Type", "text/plain;charset=UTF-8");
    ajax_object.send()
}

function PrintLabel(that){
    var res=JSON.parse(that.responseText);
    document.getElementById("ajax_label").innerHTML=res.title;
}