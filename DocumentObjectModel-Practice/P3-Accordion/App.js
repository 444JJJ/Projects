

const accordion=document.getElementById('content-container');

for(i=0;i<accordion.length.length;i++){

    accordion[i].addEventListener('click',function(){
        this.classList.toggle('active');
    })

};