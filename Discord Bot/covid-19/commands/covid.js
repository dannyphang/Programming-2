const { MessageEmbed } = require('discord.js');
const { readCSV } = require('../util.js');
const { getGithub } = require('../util.js');

module.exports = {
    category: 'covid-19', 
    description: 'covid-19 details', 
    
    callback: async ({ message, text }) => {
        const data = await getGithub('https://raw.githubusercontent.com/MoH-Malaysia/covid19-public/main/epidemic/cases_malaysia.csv');
        
        let total = -1;
        for (let i = 0; i < data.length; i++){
            total += parseInt(data[i].cases_new);
        }
        
        // pre-create embed behind the code
        const embed = new MessageEmbed()
        .setTitle('Malaysia Covid-19 Cases')
        .setColor('BLUE')
        .addFields([
            { 
                name: '```Date```', 
                value: data[data.length - 1].date,
                // inline: true,  
            }, 
            {
                name: '```Total Cases```', 
                value: total.toString(), 
                inline: true, 
            },
            {
                name: '```New Cases```', 
                value: data[data.length - 1].cases_new, 
                inline: true, 
            },
            { 
                name: '```New Recovered```', 
                value: data[data.length - 1].cases_recovered, 
                inline: true, 
            },
            { 
                name: '```New Active Cases```', 
                value: data[data.length - 1].cases_active, 
                inline: true, 
            }, 
        ])
        .setFooter(`update: ${data[data.length - 1].date}`)
        return embed
    },
}