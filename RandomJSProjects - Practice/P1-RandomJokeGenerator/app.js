const btnEl=document.getElementById('btn');
const jokeEl=document.getElementById('joke');

const apiKey="dfg6FElXjwKdOS75JYvIDw==HSrn3lU87B9yCM2I";

const options={
    method:"GET",
    headers:{
        "X-Api-Key":apiKey,
    },
};

const apiURL="https://api.api-ninjas.com/v1/dadjokes?limit=1";

btnEl.addEventListener("click",async function(){
    try {
        jokeEl.innerText="Updating...";

        btnEl.disabled=true;
        btnEl.innerText="Loading...";
    
        console.log("clicked");
        const response=await fetch(apiURL, options)
        const data=await response.json();
    
        btnEl.disabled=false;
        btnEl.innerText="NEXT JK";
    
        jokeEl.innerText=data[0].joke;
        
    } catch (error) {
        jokeEl.innerText="An error occured, try again later";
        console.log(error);
    }
});