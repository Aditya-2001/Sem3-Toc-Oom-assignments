function ajax() {
    var ajax_object = new XMLHttpRequest()

    ajax_object.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var res = JSON.parse(this.responseText);
            document.getElementById("ajax_label").innerHTML = res.title;
        }
    }
    ajax_object.open("GET", 'https://jsonplaceholder.typicode.com/todos/1', true)
    ajax_object.setRequestHeader("Access-Control-Allow-Origin", "*")
    ajax_object.setRequestHeader("Content-Type", "text/plain;charset=UTF-8");
    ajax_object.send()
}

function abcd() {
    $.post("https://api-2001.herokuapp.com//user/login", { "email": "#@abcde.com", "password": "123" }, function(data, status) { alert("Data: " + data + "\nStatus: " + status); });
}

/*
// AJAX -- Async Javascript & XML

// 1. Update a particular section of the page. Not the entire page
// 2. Send data from client to  server ---> Request
// 3. Receive the data from server to client ---> Response
// 4. Background

var req =new XMLHttpRequest()


if (this.readyState == 4 && this.status == 200) {

}

Access-Control-Allow-Origin

setRequestHeader("Access-Control-Allow-Origin", "*");

ajax_object.setRequestHeader("Content-Type", "text/plain;charset=UTF-8");

 --disable-web-security --disable-gpu --user-data-dir=~/chromeTemp
*/