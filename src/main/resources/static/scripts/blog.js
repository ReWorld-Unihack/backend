const loveBtns = document.querySelectorAll('.love-btn')
const favoriteBtns = document.querySelectorAll('.favorite-btn')
loveBtns.forEach(btn => {
    btn.onclick = () => {
        btn.classList.toggle('active')
    }
})
favoriteBtns.forEach(btn => {
    btn.onclick = () => {
        btn.classList.toggle('active')
    }
})