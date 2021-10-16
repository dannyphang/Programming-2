const { MessageEmbed } = require('discord.js');
const { getGithub } = require('../util.js');
const { stateFunc } = require('../util.js');
const { prefix } = require('../util.js');
const path = require('path');

module.exports = {
    category: 'covid-19', 
    description: 'covid-19 details', 
    
    expectedArgs: '<State>',
    minArgs: 0,
    maxArgs: 1,
    syntaxError: 'Incorrect usage! Please use "{PREFIX}"',
    
    callback: async ({ channel, args }) => {
        const dataD = await getGithub('https://raw.githubusercontent.com/MoH-Malaysia/covid19-public/main/epidemic/deaths_malaysia.csv');
        const dataS = await getGithub('https://raw.githubusercontent.com/MoH-Malaysia/covid19-public/main/epidemic/deaths_state.csv');
        
        let total = -1;
        for (let i = 0; i < dataD.length; i++){
            total += parseInt(dataD[i].deaths_new);
        }
        
        if(args.length == 0){
            const embed = new MessageEmbed()
            .setTitle('Malaysia Covid-19 Deaths Cases')
            .setColor('RED')
            .addFields([
                { 
                    name: '`Date`', 
                    value: dataD[dataD.length - 1].date,
                    // inline: true,  
                }, 
                {
                    name: '`Total Death`', 
                    value: total.toString(), 
                    inline: true, 
                },
                {
                    name: '`New Death`', 
                    value: dataD[dataD.length - 1].deaths_new, 
                    inline: true, 
                },
            ])
            .setFooter(`update: ${dataD[dataD.length - 1].date}`)
            return embed
        }
        else if (args.length == 1){
            var stateNo = stateFunc(args);
            
            var index = -1;
        
            dataD.find(function(item, i){
                if(item.date == args.toString()){
                    index = i;
                }
            });
            
            if(stateNo != -1 && index == -1){ // state: true, date: false
                const embed = new MessageEmbed()
                .setTitle(`Covid-19 Death Cases at ${args.toString()}`)
                .setColor('RED')
                .addFields([
                    { 
                        name: '`Date`', 
                        value: dataS[dataS.length - stateNo].date,
                        // inline: true,  
                    },
                    {
                        name: '`New Death`', 
                        value: dataS[dataS.length - stateNo].deaths_new, 
                        inline: true, 
                    },
                ])
                .setFooter(`update: ${dataS[dataS.length - 1].date}`)
                return embed
            }
            else if(stateNo == -1 && index != -1){ // state: false, date: true
                const embed = new MessageEmbed()
                .setTitle(`Malaysia Covid-19 Death Cases on ${dataD[index].date}`)
                .setColor('RED')
                .addFields([ 
                    {
                        name: '`Death Cases`', 
                        value: dataD[index].deaths_new, 
                        inline: true, 
                    },
                ])
                .setFooter(`update: ${dataD[dataD.length - 1].date}`)
                
                return embed
            }
            else{
                return `Incorrect usage! Please use "${prefix() + path.basename(__filename, path.extname(__filename))} <State>/<Date>"`
            }
        }
    },
}