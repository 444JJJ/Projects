
const btnEl=document.getElementById('btn');
const quoteEl=document.getElementById('quote');
const authorEl=document.getElementById('author');
const apiURL="https://api.quotable.io/random";


async function getQuote(){

    try {
        btnEl.innerText="Loading...";
        btnEl.disabled=true;
        quoteEl.innerText="Updating...";
        authorEl.innerText="Updating...";


            //use the method fetch to get the information.
            const response= await fetch(apiURL);
            //convert the response from fetch to json file
            const data=await response.json();
            console.log(data);
            //fill info of content and author from data to innerText
            const quoteContent=data.content;
            const quoteAuthor=data.author;
            quoteEl.innerText=quoteContent;
            authorEl.innerText="~ "+quoteAuthor;

            ////Extra work - Loading screen
            btnEl.innerText="Get a quote";
            btnEl.disabled=false;


        
    } catch (error) {
        console.log(error);
        quoteEl.innerText="Error occured, try again later...";
        authorEl.innerText="Error occured";
        btnEl.innerText="Loading...";
        btnEl.disabled=true;
        
    }


}

getQuote();

btnEl.addEventListener("click", getQuote);