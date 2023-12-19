const validationMessageY = document.querySelector('.validYMessage');
const inputY = document.querySelector('.yInput');



inputY.addEventListener("input", function() {

    const Y = inputY.value.replace(",", ".");

    if (validateY(Y)) {
        validationMessageY.textContent = '';
    } else {
        inputY.value = '';
        validationMessageY.textContent = "Введите корректное значение Y";
    }
});
function validateY(par){
    const regex=/^(null|-?\d+(\.\d{0,10})?)?$/;

    return ((regex.test(par) && par<3 && par>-5) || par==='-')


}



