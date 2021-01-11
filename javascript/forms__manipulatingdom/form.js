var valueName = ''

function onload() {
    valueName = document.getElementById("name").value
    document.getElementById("displayName").innerHTML = valueName
}

function load() {
    localStorage.setItem("name", document.getElementById("name").value)
}

function check() {
    var name = document.getElementById("name").value
    if (name === null || name === "") {
        alert("Text Box can't be blanked")
        return false
    }
    return true
}
var totalItem = 0

function addItem() {
    totalItem++
    var paragraph = document.createElement("p")
    paragraph.setAttribute("id", "p" + totalItem)
    var textLabel = document.createTextNode("Hello World" + totalItem)
    paragraph.append(textLabel)
    var item = document.getElementById("append")
    var val = item.childNodes
        //alert(val)
    if (!item.childElementCount)
        item.appendChild(paragraph)
    item.replaceChild(paragraph, item.firstChild)
}

//function Remove() {
//var getID = document.getElementById("p" + totalItem)
//var divID = document.getElementById("append")
//divID.removeChild(getID)
//totalItem--
//}

function Remove() {
    var divID = document.getElementById("append")
    while (divID.firstChild) {
        divID.removeChild(divID.firstChild)
    }
}