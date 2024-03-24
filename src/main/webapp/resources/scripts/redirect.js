function toVenda(id){
    window.location.href = "venda?id=" + id;
}

function confirmAction(action,location){
    let confirmed = confirm("Quer continuar a "+action+"?")
    if(confirmed){
        window.location.href = location
    }
}