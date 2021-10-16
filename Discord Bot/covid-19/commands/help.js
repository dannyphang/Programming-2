const { MessageEmbed } = require('discord.js');
const { prefix } = require('../util.js');

module.exports = {
    category: 'Help', 
    description: 'Help command', 
    
    permissions: ['ADMINISTRATOR'], 
    
    callback: async ({ message, text }) => {
        
        const cases = new MessageEmbed()
        .setTitle('Help Info')
        .setColor('#000080')
        .addFields([
            { 
                name: '`' + `${prefix()}` + 'c' + '`',
                value: '✨ Today Covid-19 cases.',
                inline: true, 
            }, 
            {
                name: '`' + `${prefix()}` + 'c <Date>' + '`',
                value: '✨ Covid-19 cases on specify date.\nDate Format: yyyy-MM-dd', 
                inline: true, 
            },
            {
                name: '`' + `${prefix()}` + 'c <State>' + '`',
                value: '✨ Covid-19 cases at specify state', 
                inline: true, 
            }, 
            {
                name: '`' + `${prefix()}` + 'd' + '`',
                value: '✨ Covid-19 deaths cases', 
                inline: true, 
            }, 
            {
                name: '`' + `${prefix()}` + 'd <State>' + '`',
                value: '✨ Covid-19 deaths cases at specify state', 
                inline: true, 
            }, 
            {
                name: '`' + `${prefix()}` + 'd <Date>' + '`',
                value: '✨ Covid-19 deaths cases on specify date.\nDate Format: yyyy-MM-dd', 
                inline: true, 
            }, 
            {
                name: '`' + `${prefix()}` + 'v' + '`',
                value: '✨ Covid-19 Vaccination details', 
                inline: true, 
            }, 
            {
                name: '`' + `${prefix()}` + 'v <Date>' + '`',
                value: '✨ Covid-19 total vaccinated on specify date.\nDate Format: yyyy-MM-dd', 
                inline: true, 
            }, 
            {
                name: '`' + `${prefix()}` + 'v <Type>' + '`',
                value: '✨ Covid-19 total vaccinated with specify type.\nOptions: pfizer, sinovac, az', 
                inline: true, 
            }, 
            {
                name: '`' + `${prefix()}` + 'v <State>' + '`',
                value: '✨ Covid-19 total vaccinated at specify state.', 
                inline: true, 
            }, 
            {
                name: '`' + `${prefix()}` + 'v <State> <Date>' + '`',
                value: '✨ Covid-19 total vaccinated at specify state on specify date.\nDate Format: yyyy-MM-dd', 
                inline: true, 
            },
            {
                name: '\u200B',
                value: '\u200B', 
                inline: true, 
            }, 
            {
                name: '`' + `${prefix()}` + 's' + '`',
                value: '✨ Today Covid-19 cases at every states.', 
                inline: true, 
            }, 
            {
                name: '`' + `${prefix()}` + 's <Date>' + '`',
                value: '✨ Covid-19 cases at every states on specify date.\nDate Format: yyyy-MM-dd', 
                inline: true, 
            }
        ])
        return cases;
    },
}