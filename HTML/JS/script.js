function asd() {
    window.alert("szia faszos");
}
var aloldalak = ["fooldal", "szolg", "szob", "aszf"];
function navbar(n) {
    if (aloldalak.includes(n) && n != aloldalak[0]) {
        aloldalak.forEach(old => {
            if (n == old || old == aloldalak[0]) {
                $(`#${old}`).removeClass("disabled");
            } else {
                $(`#${old}`).addClass("disabled");
            }
        });
    } else if (n == aloldalak[0]) {
        aloldalak.forEach(old => {
            $(`#${old}`).removeClass("disabled");
        })
        $(`#${aloldalak[0]}`).addClass("disabled");
    }
}