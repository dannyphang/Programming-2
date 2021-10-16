const csv = require('csv-parser');
const fs = require('fs');
const neatCsv = require('neat-csv');
const fetch = require('node-fetch');
const { type } = require('os');

async function readCSV(path){
    const dataFile = fs.readFileSync(path, 'utf8');
    
    const csv = await neatCsv(dataFile);
    
    return csv;
}

async function getGithub(url){
    const response = await fetch(url);
    let data = await response.text();
    
    data = await neatCsv(data);
    
    return data;
}

function stateFunc(args){
    let stateNo = -1;
    let state = args.toString();
    
    switch (state){
        case 'Johor':
            stateNo = 16;
            break;
        case 'Kedah':
            stateNo = 15;
            break;
        case 'Kelantan':
            stateNo = 14;
            break;
        case 'Melaka':
            stateNo = 13;
            break;
        case 'Negeri_Sembilan':
            stateNo = 12;
            break;
        case 'Pahang':
            stateNo = 11;
            break;
        case 'Perak':
            stateNo = 10;
            break;
        case 'Perlis':
            stateNo = 9;
            break;
        case 'Pulau_Pinang':
            stateNo = 8;
            break;
        case 'Sabah':
            stateNo = 7;
            break;
        case 'Sarawak':
            stateNo = 6;
            break;
        case 'Selangor':
            stateNo = 5;
            break;
        case 'Terengganu':
            stateNo = 4;
            break;
        case 'Kuala_Lumpur':
            stateNo = 3;
            break;
        case 'Labuan':
            stateNo = 2;
            break;
        case 'Putrajaya':
            stateNo = 1;
            break;
        default:
            break;
    }
    return stateNo;
}

function stateData(stateArr, datas){
    let stateNo = -1;
    
    for (let i = 0; i < datas.length; i++){
        for(let j = 0; j < 16; j++){
            if(datas[i].vaxtype == j){
                stateArr[j] = parseInt(datas[i].cases_new);
            }
        }
        
    }
    
    switch (state){
        case 'Johor':
            stateNo = 16;
            break;
        case 'Kedah':
            stateNo = 15;
            break;
        case 'Kelantan':
            stateNo = 14;
            break;
        case 'Melaka':
            stateNo = 13;
            break;
        case 'Negeri_Sembilan':
            stateNo = 12;
            break;
        case 'Pahang':
            stateNo = 11;
            break;
        case 'Perak':
            stateNo = 10;
            break;
        case 'Perlis':
            stateNo = 9;
            break;
        case 'Pulau_Pinang':
            stateNo = 8;
            break;
        case 'Sabah':
            stateNo = 7;
            break;
        case 'Sarawak':
            stateNo = 6;
            break;
        case 'Selangor':
            stateNo = 5;
            break;
        case 'Terengganu':
            stateNo = 4;
            break;
        case 'Kuala_Lumpur':
            stateNo = 3;
            break;
        case 'Labuan':
            stateNo = 2;
            break;
        case 'Putrajaya':
            stateNo = 1;
            break;
        default:
            break;
    }
    
    return stateNo;
  }

function prefix(){
    return '>';
}

function vType(args){
    let num = -1;
    var type = args.toString();
    
    switch(type){
        case 'pfizer':
            num = 2;
            break;
        case 'sinovac':
            num = 1;
            break;
        case 'az':
            num = 3;
            break;
        default:
            break;
    }
    return num;
}

module.exports = {
    readCSV,
    getGithub, 
    stateFunc, 
    prefix, 
    vType, 
}