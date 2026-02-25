function asd() {
    window.alert("szia faszos");
    // $("#fejlec").addClass("disabled");
}
function navbar(n) {
    if (n == "fooldal") {
        $("#foold").addClass("disabled");
        $("#szolg").removeClass("disabled");
        $("#szob").removeClass("disabled");
        $("#aszf").removeClass("disabled");
    }
    else if (n == "szolg") {
        $("#szolg").removeClass("disabled");
        $("#foold").removeClass("disabled");
        $("#szob").addClass("disabled");
        $("#aszf").addClass("disabled");
    }
    else if (n == "szob") {
        $("#szob").removeClass("disabled");
        $("#foold").removeClass("disabled");
        $("#szolg").addClass("disabled");
        $("#aszf").addClass("disabled");
    }
    else if (n == "aszf") {
        $("#aszf").removeClass("disabled");
        $("#foold").removeClass("disabled");
        $("#szolg").addClass("disabled");
        $("#szob").addClass("disabled");
    }
}