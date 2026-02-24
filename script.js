function asd() {
    window.alert("szia faszos");
}
const fooldal = document.getElementById("food");
const szolg = document.getElementById("szolg");
const szob = document.getElementById("szob");
const aszf = document.getElementById("aszf");
function navbar(n) {
    if (n == "fooldal") {
        fooldal.className = "p-2 nav-link disabled";
        szolg.className = "p-2 nav-link";
        szob.className = "p-2 nav-link";
        aszf.className = "p-2 nav-link";
    }
    else if (n = "szolg") {
        szolg.className = "p-2 nav-link";
        fooldal.className = "p-2 nav-link";
        szob.className = "p-2 nav-link disabled";
        aszf.className = "p-2 nav-link disabled";
    }
    else if (n = "szob") {
        szob.className = "p-2 nav-link";
        fooldal.className = "p-2 nav-link";
        szolg.className = "p-2 nav-link disabled";
        aszf.className = "p-2 nav-link disabled";
    }
    else if (n = "aszf") {
        aszf.className = "p-2 nav-link";
        fooldal.className = "p-2 nav-link";
        szolg.className = "p-2 nav-link disabled";
        szob.className = "p-2 nav-link disabled";
    }
}