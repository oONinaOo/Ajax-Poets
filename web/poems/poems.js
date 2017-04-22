var btn = document.getElementById("poems");
var getpoems = document.getElementById("getpoems");
var poemContent = document.getElementById("poemContent");
var getName = document.cookie.split("=");
var author = getName[1];


btn.addEventListener("click", function() {
    btn.style.display = "none";
    var ourRequest = new XMLHttpRequest();
    ourRequest.open('GET', 'poems/' + author + '.json');
    ourRequest.onload = function() {
        if (ourRequest.status >= 200 && ourRequest.status < 400) {
            var ourData = JSON.parse(ourRequest.responseText);
            renderHTML(ourData);
        } else {
            console.log("We connected to the server, but it returned an error.");
        }

    };

    ourRequest.onerror = function() {
        console.log("Connection error");
    };

    ourRequest.send();

})


function loadDoc(url) {

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("poemContent").innerHTML =
                this.responseText;
        }
    };
    xhttp.open("GET", url, true);
    xhttp.send();
    
}

function renderHTML(data) {
    var htmlString = "";

    for (var i = 0; i < data.length; i++) {

        htmlString += "<center><button class=\"poemsloaded\" type=\"button\" onclick=\"loadDoc(" + "'" + data[i].filePath + "'" + ")\">"  + data[i].title + "</button></center><br>";
        htmlString += "<center><b> was published in " + data[i].publication + "</b></center><br></br>";


    }
    getpoems.insertAdjacentHTML('beforeend', htmlString);

}

