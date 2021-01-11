function loadCookie() {
    document.cookie = "Name=Aditya"
    var x = decodeURIComponent(document.cookie)
    alert(x)
}

function addCookie() {
    document.cookie = "name=aditya; rollNo=IIT2019210"
    alert(document.cookie)
}

//We can't remove the key of the cookie without giving its expiry
function deleteCookie() {
    document.cookie = "name="
}

//If want to expire after 1 hr then can expire when we are defining it
function expireCookie() {
    document.cookie = "name=;expires=Sun,15 Nov 2020 00:00:00 UTC;"
}

function addCookieinDiffpath() {
    document.cookie = "name=aditya;path=/objective;domain=abc.com"
}
//in domain avoid www or http