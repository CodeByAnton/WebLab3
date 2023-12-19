const canvas = document.getElementById("canvas");
const ctx = canvas.getContext('2d');

canvas.height = canvas.width=400;
let w = canvas.width, h = canvas.height;

const hatchWidth = 10 / 2;
const baseHatchGap=40;
let hatchGap = 50;


const rValueInput = document.getElementById('j_idt7:rValue_input');
console.log(typeof(rValueInput))
console.log(typeof(rValueInput.value))
if (rValueInput.value==="0.0"){
    redrawGraph("1,0")
    console.log("R is ZERO")
} else {
    redrawGraph(rValueInput.value)
    console.log(rValueInput.value)
    console.log("R NOT ZERO")
}


rValueInput.onchange = function() {
    handleRValueChange();
};

function handleRValueChange() {

    redrawGraph(rValueInput.value);

}

function redrawGraph(rValue) {
    ctx.fillStyle = 'rgba(0,64,255,0.33)';

    ctx.clearRect(0, 0, canvas.width, canvas.height);

    ctx.lineWidth = 2;
    ctx.strokeStyle = 'black';

    // y ось
    ctx.beginPath();
    ctx.moveTo(w / 2, 0);
    ctx.lineTo(w / 2 - 10, 15);
    ctx.moveTo(w / 2, 0);
    ctx.lineTo(w / 2 + 10, 15);
    ctx.moveTo(w / 2, 0);
    ctx.lineTo(w / 2, h);
    ctx.stroke();
    ctx.closePath();

    // x ось
    ctx.beginPath();
    ctx.moveTo(w, h / 2);
    ctx.lineTo(w - 15, h / 2 - 10);
    ctx.moveTo(w, h / 2);
    ctx.lineTo(w - 15, h / 2 + 10);
    ctx.moveTo(w, h / 2);
    ctx.lineTo(0, h / 2);
    ctx.stroke();
    ctx.closePath();

    //рисование меток на графике
    ctx.beginPath();
    ctx.moveTo(w / 2 - hatchWidth, h / 2 - hatchGap);
    ctx.lineTo(w / 2 + hatchWidth, h / 2 - hatchGap);
    ctx.moveTo(w / 2 - hatchWidth, h / 2 - hatchGap * 2);
    ctx.lineTo(w / 2 + hatchWidth, h / 2 - hatchGap * 2);
    ctx.moveTo(w / 2 - hatchWidth, h / 2 + hatchGap);
    ctx.lineTo(w / 2 + hatchWidth, h / 2 + hatchGap);
    ctx.moveTo(w / 2 - hatchWidth, h / 2 + hatchGap * 2);
    ctx.lineTo(w / 2 + hatchWidth, h / 2 + hatchGap * 2);
    ctx.moveTo(w / 2 - hatchGap, h / 2 - hatchWidth);
    ctx.lineTo(w / 2 - hatchGap, h / 2 + hatchWidth);
    ctx.moveTo(w / 2 - hatchGap * 2, h / 2 - hatchWidth);
    ctx.lineTo(w / 2 - hatchGap * 2, h / 2 + hatchWidth);
    ctx.moveTo(w / 2 + hatchGap, h / 2 - hatchWidth);
    ctx.lineTo(w / 2 + hatchGap, h / 2 + hatchWidth);
    ctx.moveTo(w / 2 + hatchGap * 2, h / 2 - hatchWidth);
    ctx.lineTo(w / 2 + hatchGap * 2, h / 2 + hatchWidth);
    ctx.stroke();
    ctx.closePath();

    //рисование четверти круга
    ctx.beginPath();
    ctx.arc(w / 2, h / 2, hatchGap, 0, 1 / 2 * Math.PI, false);
    ctx.lineTo(w/2, h/2+hatchGap);
    ctx.lineTo(w/2,h/2);
    ctx.fill();
    ctx.stroke();
    ctx.closePath();




    //рисование прямоугольника
    ctx.beginPath();
    ctx.moveTo(w / 2 - hatchGap, h / 2);
    ctx.lineTo(w / 2 - hatchGap, h / 2 + 2 * hatchGap);
    ctx.lineTo(w / 2, h / 2 + 2 * hatchGap);
    ctx.lineTo(w / 2, h / 2);
    ctx.fill();
    ctx.stroke();
    ctx.closePath();





    //рисование треугольника
    ctx.beginPath();
    ctx.moveTo(w / 2 - hatchGap, h / 2);
    ctx.lineTo(w / 2, h / 2 - 2 * hatchGap);
    ctx.lineTo(w / 2 , h / 2);
    ctx.lineTo(w / 2 - hatchGap, h / 2);
    ctx.fill();
    ctx.stroke();
    ctx.closePath();




    const axisFontSize = baseHatchGap/2;
    let fontSize = hatchGap / 3.5;
    if(fontSize<10) fontSize=10;
    ctx.fillStyle = 'black';

    ctx.font = `500 ${axisFontSize * 1.4}px Roboto`;
    ctx.fillText('y', w / 2 - hatchWidth * 6, 15)
    ctx.fillText('x', w - 20, h / 2 - hatchWidth * 2.4)

    let label1, label2;
    label1 = parseFloat(rValue.replace(',', '.')) / 2;
    label2=parseFloat(rValue.replace(',','.'));
    // if (isNaN(rValue)) {
    //     label1 = rValue + '/2'
    //     label2 = rValue
    // } else {
    //     label1 = rValue / 2
    //     label2 = rValue
    // }

    ctx.font = `800 ${fontSize}px Roboto`;
    //подпись 0X
    ctx.fillText(label1, w / 2 + hatchGap +3, h / 2 + hatchWidth * 2.8);
    ctx.fillText(label2, w / 2 + hatchGap * 2 , h / 2 + hatchWidth * 2.8);
    ctx.fillText('-' + label1, w / 2 - hatchGap - 24, h / 2 + hatchWidth * 2.8);
    ctx.fillText('-' + label2, w / 2 - hatchGap * 2 - 15, h / 2 + hatchWidth * 2.8);

    //подпись 0Y
    ctx.fillText(label1, w / 2 + hatchWidth * 2, h / 2 - hatchGap + 3);
    ctx.fillText(label2, w / 2 + hatchWidth * 2, h / 2 - hatchGap * 2 + 3);
    ctx.fillText('-' + label1, w / 2 + hatchWidth * 2, h / 2 + hatchGap + 10);
    ctx.fillText('-' + label2, w / 2 + hatchWidth * 2, h / 2 + hatchGap * 2 + 3);
    redrawPointsFromTable();

}
function printDotOnGraph(xCenter, yCenter) {
    let rValue=rValueInput.value;
    rValue=parseFloat(rValue.replace(',', '.'));

    let x = w / 2 + xCenter * hatchGap * (2 / rValue), y = h / 2 - yCenter * hatchGap * (2 / rValue);
    const radius = hatchGap / 20; // Радиус круга

    ctx.beginPath();
    ctx.arc(x, y, radius, 0, 2 * Math.PI);
    const isHIt=checkHit(xCenter,yCenter,rValue);
    if (isHIt){
        ctx.fillStyle='green';
    } else {
        ctx.fillStyle='red';
    }
    ctx.fill();
    ctx.closePath();

}
function getMousePosition(e) {
    let rect = canvas.getBoundingClientRect();

    let mouseX = e.offsetX * canvas.width / canvas.clientWidth | 0;
    let mouseY = e.offsetY * canvas.height / canvas.clientHeight | 0;
    return {x: mouseX, y: mouseY};
}

canvas.addEventListener('click', (event) => {
    let rValue=rValueInput.value;
    rValue=parseFloat(rValue.replace(',', '.'));



    const x = getMousePosition(event).x;
    const y = getMousePosition(event).y;


    const xCenter = Math.round((x - w / 2) / (hatchGap * (2 / rValue)) * 1000) / 1000,
        yCenter = Math.round((h / 2 - y) / (hatchGap * (2 / rValue)) * 1000) / 1000;
    setValue(xCenter,yCenter,rValue);



    printDotOnGraph(xCenter, yCenter);



})
function setValue(x,y,r){
    document.getElementById('j_idt32:xHidden').value=x;
    document.getElementById('j_idt32:yHidden').value=y;
    document.getElementById('j_idt32:rHidden').value=r;
    document.getElementById('j_idt32:submitHidden').click();


}
function checkHit(x,y,r){
    if (x>0&&y>0){
        return false;
    }
    if (x>=0 &&y<=0){
        return (x*x+y*y<=r*r/4);
    }
    if (x<=0 && y>=0){
        return (y<=2*x+r);

    }
    if (x<=0 && y<=0){
        return ((x>=-r/2) &&(y<=r));
    }
    return true;
}
function redrawPointsFromTable(){
    const table = document.getElementById('result-table');
    const tableRows = table.getElementsByTagName('tr');

// Создаем массив для хранения данных точек

    for (let i = 1; i < tableRows.length; i++) {
        const row = tableRows[i];
        const rowData = row.getElementsByTagName('td');

        const x = parseFloat(rowData[0].textContent);
        const y = parseFloat(rowData[1].textContent);
        const r = parseFloat(rowData[2].textContent);

        printDotOnGraph(x,y);
    }

}
