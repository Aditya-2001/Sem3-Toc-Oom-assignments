function initialization() {
    var json = $.getJSON("users.json");
    $.getJSON("users.json", function(json) {
        console.log(json); // this will show the info it in firebug console
    });
    var user = [
        ["aditya", "aditya.iiita2001@gmail.com", "Aditya@123"],
        ["mayank", "mayank123@gmail.com", "Mayank@123"]
    ]
    return [user]
}

function validateUser(username, login) {
    var ls = 1
    if (login)
        ls = 0
    for (i = 0; i < user.length; i++) {
        if (username === user[i][ls]) {
            return i
        }
    }
    alert("This user doesn't matched")
    exit(-1)
}

function validatepassword(password, index) {
    if (password === user[index][2])
        return
    alert("Username and Password doesn't matched")
    exit(-1)
}


function checkUser() {
    var username = document.getElementById("user").value
    var password = document.getElementById("password").value
    var getindex = validateUser(username, true)
    validatepassword(password, getindex)
    alert("Hi")
}

function validatepasswords(p1, p2) {
    if (p1 != p2) {
        alert("Boths passwords are different")
        exit(-2)
    }
    var i = 0
    for (i = 0; i < p1.length; i++) {
        if (p1[i] === '@')
            break
    }
    if (i === p1.length || p1.length < 8) {
        alert("Password not valid, must have 8 characters with atleast 1 @")
        exit(-2)
    }
    return
}

function changePassword(index, password) {
    user[index][2] = password
    alert(user[index][2])
}

function newpassword() {
    var email = document.getElementById("email").value
    var password1 = document.getElementById("password1").value
    var password2 = document.getElementById("password2").value
    validatepasswords(password1, password2)
    var userindex = validateUser(email, false)
    changePassword(userindex, password2)
    alert("Password Changed Successfully")
}

var initalize = initialization()
user = initalize[0]

function fetchjson() {
    fetch("https://github.com/Aditya-2001/practice/blob/master/users.json")
        .then(response => response.json())
        .then(data => console.log(data));
}