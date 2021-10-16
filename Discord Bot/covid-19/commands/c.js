const { MessageEmbed } = require('discord.js');
const { getGithub } = require('../util.js');
const { stateFunc } = require('../util.js');
const { prefix } = require('../util.js');
const path = require('path');

module.exports = {
    category: 'covid-19',
    description: 'Show Covid-19 cases on specify date',
    
    // For the correct usage of the command
    expectedArgs: '<yyyy-MM-dd>',
    minArgs: 0,
    maxArgs: 1,
    syntaxError: 'Incorrect usage! Please use "{PREFIX}"',
    
    // Invoked when the command is actually ran
    callback: async ({ channel, args }) => {
        const data = await getGithub('https://raw.githubusercontent.com/MoH-Malaysia/covid19-public/main/epidemic/cases_malaysia.csv');
        const datas = await getGithub('https://raw.githubusercontent.com/MoH-Malaysia/covid19-public/main/epidemic/cases_state.csv');
        
        if(args.length == 0){
            let total = -1;
            for (let i = 0; i < data.length; i++){
                total += parseInt(data[i].cases_new);
            }
            
            const embed = new MessageEmbed()
            .setTitle('Malaysia Covid-19 Cases')
            .setColor('YELLOW')
            .addFields([
                { 
                    name: '`Date`', 
                    value: data[data.length - 1].date,
                    // inline: true,  
                }, 
                {
                    name: '`Total Cases`', 
                    value: total.toString(), 
                    inline: true, 
                },
                {
                    name: '`New Cases`', 
                    value: data[data.length - 1].cases_new, 
                    inline: true, 
                },
                { 
                    name: '`New Recovered`', 
                    value: data[data.length - 1].cases_recovered, 
                    inline: true, 
                },
                { 
                    name: '`New Active Cases`', 
                    value: data[data.length - 1].cases_active, 
                    inline: true, 
                }, 
            ])
            .setFooter(`update: ${data[data.length - 1].date}`)
            return embed
        }
        else if(args.length == 1){
            var index = -1;
        
            data.find(function(item, i){
                if(item.date == args[0].toString()){
                    index = i;
                }
            });
            
            var stateNo = stateFunc(args);
            
            if(stateNo != -1 && index == -1){ // state: true
                const embed = new MessageEmbed()
                .setTitle(`Covid-19 Cases at ${args.toString().replace("_", " ")}`)
                .setColor('YELLOW')
                .addFields([ 
                    {
                        name: '`Date`', 
                        value: datas[datas.length - stateNo].date,
                        // inline: true,
                    },
                    {
                        name: '`Cases`', 
                        value: datas[datas.length - stateNo].cases_new,
                        inline: true,
                    },
                    { 
                        name: '`Recovered`', 
                        value: datas[datas.length - stateNo].cases_recovered,
                        inline: true,
                    },
                    { 
                        name: '`Active Cases`', 
                        value: datas[datas.length - stateNo].cases_active,
                        inline: true,
                    }, 
                ])
                .setFooter(`update: ${datas[datas.length - 1].date}`)
                
                return embed
            }
            else if(stateNo == -1 && index != -1){
                const embed = new MessageEmbed()
                .setTitle(`Malaysia Covid-19 Cases on ${data[index].date}`)
                .setColor('YELLOW')
                .addFields([ 
                    {
                        name: '`Cases`', 
                        value: data[index].cases_new, 
                        inline: true, 
                    },
                    { 
                        name: '`Recovered`', 
                        value: data[index].cases_recovered, 
                        inline: true, 
                    },
                    { 
                        name: '`Active Cases`', 
                        value: data[index].cases_active, 
                        inline: true, 
                    }, 
                ])
                .setFooter(`update: ${data[data.length - 1].date}`)
                
                return embed
            }
            else{
                return `Incorrect usage! Please use "${prefix() + path.basename(__filename, path.extname(__filename))} <State>/<Date>"`
            }
        }
    }
}