document.addEventListener("DOMContentLoaded", function () {
    update();
    setInterval(update, 9000);
});


function update() {
    const timeElement = document.querySelector(".datetime_time")
    const dateElement = document.querySelector(".datetime_date");

    const currentDate = new Date();
    const dateOptions = {year: 'numeric', month: 'long', day: 'numeric'};
    const timeOptions = {hour: '2-digit', minute: '2-digit', second: '2-digit'};

    timeElement.textContent = currentDate.toLocaleTimeString('ru-RU', timeOptions);
    dateElement.textContent = currentDate.toLocaleDateString('ru-RU', dateOptions);
}