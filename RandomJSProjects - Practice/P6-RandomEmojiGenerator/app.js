
const btnEl=document.getElementById('btn');
const emojiNameEl=document.getElementById('emoji-name');

const emoji=[];
async function getEmoji(){
    let response = await fetch("https://emoji-api.com/emojis?access_key=40cf30d69e95ce83f71b1000a7ca619d7c15555e");

    data=await response.json();
    for(let i=0;i<1500;i++){
        emoji.push({
            emojiname:data[i].character,
            emojiCode:data[i].unicodeName,
        });
    }    
}

getEmoji();

btnEl.addEventListener('click', ()=>{
    const randomNumber=Math.floor(Math.random()*emoji.length); //creating radom number
    btnEl.innerText=emoji[randomNumber].emojiname;
    emojiNameEl.innerText=emoji[randomNumber].emojiCode;

})
