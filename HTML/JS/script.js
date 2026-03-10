function asd() {
    window.alert("szia faszos");
    window.location.href = "book.html";
}
// A fooldalnak mindig az elso helyen kell lennie! ˇˇˇ

// !!!! felesleges kódrészlet !!!!

// var aloldalak = ["fooldal", "szolg", "szob", "aszf"];
// function navbar(n) {
//     if (aloldalak.includes(n) && n != aloldalak[0]) {
//         aloldalak.forEach(old => {
//             if (n == old || old == aloldalak[0]) {
//                 $(`#${old}`).removeClass("disabled");
//             } else {
//                 $(`#${old}`).addClass("disabled");
//             }
//         });
//     } else if (n == aloldalak[0]) {
//         aloldalak.forEach(old => {
//             $(`#${old}`).removeClass("disabled");
//         })
//         $(`#${aloldalak[0]}`).addClass("disabled");
//     } else {
//         throw new Error("Az id nem letezik! (rossz parameter)");
//     }
// }

function nav() {
    console.log(window.location.pathname)
    console.log(window.location.pathname == "/HTML/")
    console.log(window.location.pathname == "/HTML/index.html")
    $("body").prepend(`
        <nav class="navbar navbar-light bg-light fixed-top">
            <div class="container-fluid width1400">
                <a class="navbar-brand">Booke Kuuke</a>
                <div class="d-flex">
                    <a id="fooldal" class="p-2 nav-link fd-600 ${(window.location.pathname == "/HTML/" || window.location.pathname == "/HTML") ? "disabled" : ""}" href="/HTML/">
                        <i class="fa-regular fa-arrow-left"></i> Vissza a főoldalra
                    </a>
                    <a id="szolg" class="p-2 nav-link fd-600 ${(window.location.pathname == "/HTML/book") ? "disabled" : ""}" href="/HTML/book">Foglalás</a>
                    <a id="szob" class="p-2 nav-link fd-600 ${(window.location.pathname == "/HTML/szobak") ? "disabled" : ""}" href="/HTML/szobak">Szobák</a>
                    <a id="aszf" class="p-2 nav-link fd-600 ${(window.location.pathname == "/HTML/aszf") ? "disabled" : ""}" href="/HTML/aszf">ÁSZF</a>
                </div>
            </div>
        </nav>
    `);
}
function footer() {
    $("asd").before(`
        <footer id="feet" class="d-flex justify-content-center align-items-center">
            <div id="elso" class="d-flex justify-content-center align-items-center">
                <div>
                    <a href="#" class="fs-50 fd-600 shadow_w">Booke Kuuke</a>
                </div>
            </div>
            <div id="masodik" class="d-flex align-items-center gap-4">
                <div>
                    <h5>Elérhetőségeink</h5>
                    <a class="deco_none" href="#"><p class="smol"><i class="fa-regular fa-phone"></i> +36 70 ott repül batman</p></a>
                    <a class="deco_none" href="https://mail.google.com/mail/?view=cm&to=hotlebaszas@kuki.hu&su=Kérdés+a+hotellal+kapcsolatban" target="_blank"><p class="smol"><i class="fa-regular fa-envelope"></i> hotlebaszas@kuki.hu</p></a>
                    <a href="https://www.google.com/maps/search/?api=1&query=Agartha+portal+in+Hungary" class="deco_none"><p class="smol"><i class="fa-sharp fa-regular fa-location-dot"></i>6769 Salud, Tóth Mihály köz 13.</p></a>
                </div>
                <div class="vonalka"></div>
                <div>
                    <h5>Navigáció</h5>
                    <a class="deco_none" href="/HTML/book"><p class="smol">Foglalás</p></a>
                    <a class="deco_none" href="/HTML/szobak"><p class="smol">Szobák</p></a>
                    <a class="deco_none" href="/HTML/aszf"><p class="smol">ÁSZF</p></a>
                </div>
            </div>
        </footer>
    `)
}