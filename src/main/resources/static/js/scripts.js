function actorSelected(select){
    let index = select.selectedIndex;
    let option = select.options[index];
    let id = option.value;
    let name = option.text;
    let urlImage = option.dataset.url;

    option.disabled = "disabled";
    select.selectedIndex = 0;

    addActor(id, name, urlImage);

    let ids = $("#ids").val();

    if (ids == ""){
        $("#ids").val(id);
    }else{
        $("#ids").val(ids + ", " + id);
    }

}

function addActor(id, name, urlImage){
    let htmlString = `<div class="card col-md-3 m-2" style="width: 10rem">
                        <img src="{URL-IMAGE}" class="card-img-top">
                        <div class="card-body">
                            <p class="card-text">{NAME}</p>
                            <button class="btn-danger" data-id="{ID}" onclick="deleteActor(this); return false;">Delete</button>
                        </div>
                     </div>`;

    htmlString = htmlString.replace("{URL-IMAGE}", urlImage);
    htmlString = htmlString.replace("{NAME}", name);
    htmlString = htmlString.replace("{ID}", id);

    $("#actors-container").append(htmlString);
}

function deleteActor(btn){
    let id = btn.dataset.id;
    let node = btn.parentElement.parentElement;
    let arrayIds = $("#ids").val().split(", ").filter(idActor => idActor != id);

    $("#ids").val(arrayIds.join(", "));

    $("#actors option[value='" + id + "']").prop("disabled", false);

    $(node).remove();
}

function preview(){
    let reader = new FileReader();
    reader.readAsDataURL(document.getElementById("file").files[0]);

    reader.onload = function(e){
        let view = document.getElementById("preview");
        view.classList.remove("d-none");
        view.style.backgroundImage = 'url("' + e.target.result + '")';
    }
}