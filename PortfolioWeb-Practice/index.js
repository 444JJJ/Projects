

const portfolioItems=document.querySelectorAll('.portfolio-item-wrapper');
portfolioItems.forEach(portfolioItem=>{
    portfolioItem.addEventListener('mouseover',()=>{
        console.log(portfolioItem);
        portfolioItem.childNodes[1].classList.add('img-darken');
    })
    portfolioItem.addEventListener('mouseout',()=>{
        console.log(portfolioItem);
        portfolioItem.childNodes[1].classList.remove('img-darken');
    })
})


//12345