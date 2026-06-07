const modalConsultar = document.getElementById("modalConsultar");
const modalAtualizar = document.getElementById("modalAtualizar");
const modalExcluir = document.getElementById("modalExcluir");

document.getElementById("btnConsultar")
    .addEventListener("click", (e) => {
        e.preventDefault();
        modalConsultar.style.display = "flex";
    });

document.getElementById("btnAtualizar")
    .addEventListener("click", (e) => {
        e.preventDefault();
        modalAtualizar.style.display = "flex";
    });

document.getElementById("btnExcluir")
    .addEventListener("click", (e) => {
        e.preventDefault();
        modalExcluir.style.display = "flex";
    });

document.querySelectorAll(".btn-fechar")
    .forEach(btn => {
        btn.addEventListener("click", () => {
            btn.closest(".modal").style.display = "none";
        });
    });

window.addEventListener("click", (e) => {
    if (e.target.classList.contains("modal")) {
        e.target.style.display = "none";
    }
});