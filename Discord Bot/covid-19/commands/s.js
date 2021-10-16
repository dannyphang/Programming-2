const { MessageEmbed } = require('discord.js');
const { getGithub } = require('../util.js');
const { stateFunc } = require('../util.js');
const { prefix } = require('../util.js');
const path = require('path');

module.exports = {
    category: 'covid-19',
    description: 'Show Covid-19 cases on State',
    
    // For the correct usage of the command
    expectedArgs: '<DATE>',
    minArgs: 0,
    maxArgs: 1,
    syntaxError: 'Incorrect usage! Please use "{PREFIX}"',
    
    // Invoked when the command is actually ran
    callback: async ({ channel, args }) => {
        const datas = await getGithub('https://raw.githubusercontent.com/MoH-Malaysia/covid19-public/main/epidemic/cases_state.csv');
        
        var index = [];
        
        datas.find(function(item, i){
            if(item.date == args.toString()){
                index.push(i);
            }
        });
        
        if(args.length == 0){
            const embed = new MessageEmbed()
            .setTitle(`Malaysia Covid-19 Cases`)
            .setColor('YELLOW')
            .addFields([ 
                {
                    name: '```Johor```', 
                    value: datas[datas.length - 16].cases_new,
                    inline: true,
                },
                {
                    name: '```Kedah```', 
                    value: datas[datas.length - 15].cases_new,
                    inline: true,
                },
                { 
                    name: '```Kelantan```', 
                    value: datas[datas.length - 14].cases_new,
                    inline: true,
                },
                { 
                    name: '```Melaka```', 
                    value: datas[datas.length - 13].cases_new,
                    inline: true,
                },
                { 
                    name: '```Negeri Sembilan```', 
                    value: datas[datas.length - 12].cases_new,
                    inline: true,
                },
                { 
                    name: '```Pahang```', 
                    value: datas[datas.length - 11].cases_new,
                    inline: true,
                },
                { 
                    name: '```Perak```', 
                    value: datas[datas.length - 10].cases_new,
                    inline: true,
                },
                { 
                    name: '```Perlis```', 
                    value: datas[datas.length - 9].cases_new,
                    inline: true,
                },
                { 
                    name: '```Pulau Pinang```', 
                    value: datas[datas.length - 8].cases_new,
                    inline: true,
                },
                { 
                    name: '```Sabah```', 
                    value: datas[datas.length - 7].cases_new,
                    inline: true,
                },
                { 
                    name: '```Sarawak```', 
                    value: datas[datas.length - 6].cases_new,
                    inline: true,
                }, 
                { 
                    name: '```Selangor```', 
                    value: datas[datas.length - 5].cases_new,
                    inline: true,
                },
                { 
                    name: '```Terengganu```', 
                    value: datas[datas.length - 4].cases_new,
                    inline: true,
                },
                { 
                    name: '```Kuala Lumpur```', 
                    value: datas[datas.length - 3].cases_new,
                    inline: true,
                },
                { 
                    name: '```Labuan```', 
                    value: datas[datas.length - 2].cases_new,
                    inline: true,
                },
                { 
                    name: '```Putrajaya```', 
                    value: datas[datas.length - 1].cases_new,
                    inline: true,
                },
            ])
            .setFooter(`update: ${datas[datas.length - 1].date}`)
            
            return embed
        }
        else if(args.length == 1){
            const embed = new MessageEmbed()
            .setTitle(`Malaysia Covid-19 Cases at ${args.toString()}`)
            .setColor('YELLOW')
            .addFields([ 
                {
                    name: '```Johor```', 
                    value: datas[index[0]].cases_new,
                    inline: true,
                },
                {
                    name: '```Kedah```', 
                    value: datas[index[1]].cases_new,
                    inline: true,
                },
                { 
                    name: '```Kelantan```', 
                    value: datas[index[2]].cases_new,
                    inline: true,
                },
                { 
                    name: '```Melaka```', 
                    value: datas[index[3]].cases_new,
                    inline: true,
                },
                { 
                    name: '```Negeri Sembilan```', 
                    value: datas[index[4]].cases_new,
                    inline: true,
                },
                { 
                    name: '```Pahang```', 
                    value: datas[index[5]].cases_new,
                    inline: true,
                },
                { 
                    name: '```Perak```', 
                    value: datas[index[6]].cases_new,
                    inline: true,
                },
                { 
                    name: '```Perlis```', 
                    value: datas[index[7]].cases_new,
                    inline: true,
                },
                { 
                    name: '```Pulau Pinang```', 
                    value: datas[index[8]].cases_new,
                    inline: true,
                },
                { 
                    name: '```Sabah```', 
                    value: datas[index[9]].cases_new,
                    inline: true,
                },
                { 
                    name: '```Sarawak```', 
                    value: datas[index[10]].cases_new,
                    inline: true,
                }, 
                { 
                    name: '```Selangor```', 
                    value: datas[index[11]].cases_new,
                    inline: true,
                },
                { 
                    name: '```Terengganu```', 
                    value: datas[index[12]].cases_new,
                    inline: true,
                },
                { 
                    name: '```Kuala Lumpur```', 
                    value: datas[index[13]].cases_new,
                    inline: true,
                },
                { 
                    name: '```Labuan```', 
                    value: datas[index[14]].cases_new,
                    inline: true,
                },
                { 
                    name: '```Putrajaya```', 
                    value: datas[index[15]].cases_new,
                    inline: true,
                },
            ])
            .setFooter(`update: ${datas[datas.length - 1].date}`)
            
            return embed
        }
    }
}