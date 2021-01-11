function send() {
    var qs = document.querySelector("#dropdown")
        //alert(qs[document.querySelector("#dropdown").selectedIndex].innerHTML)
        //alert(document.querySelector("#dropdown option:checked").innerHTML)
    var DS = document.getElementById("dropdown")
    var x = DS.options[DS.selectedIndex]
    alert(x.value + x.text)
}

function sendJQUERY() {
    alert($("#dropdown option:selected").text())
}