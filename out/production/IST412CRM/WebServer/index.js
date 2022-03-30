let url = 'localhost'

const {readFile} = require('fs').promises;

async function getFile(){
    const file = await readFile('./hello.txt')
}


const express = require('express');

const app = express();

app.get('/', (request, response) => {

    readFile('./hello.txt', 'utf-8', (err, html) => {
        if(err){
            response.status(500).send('issues')
        }
    
        response.send(getFile());
    })
});

app.listen(process.env.PORT || 3000, () => console.log(`App available on ${url}`))