const { MessageEmbed } = require('discord.js');
const { getGithub } = require('../util.js');
const { vType } = require('../util.js');
const { stateFunc } = require('../util.js');
const { prefix } = require('../util.js');
const path = require('path');

module.exports = {
    category: 'covid-19',
    description: 'Show Covid-19 cases on specify date',
    
    // For the correct usage of the command
    expectedArgs: '<State><yyyy-MM-dd>',
    minArgs: 0,
    maxArgs: 2,
    syntaxError: 'Incorrect usage! Please use "{PREFIX}"',
    
    // Invoked when the command is actually ran
    callback: async ({ channel, args }) => {
        const data = await getGithub('https://raw.githubusercontent.com/MoH-Malaysia/covid19-public/main/vaccination/aefi.csv');
        const dataS = await getGithub('https://raw.githubusercontent.com/CITF-Malaysia/citf-public/main/vaccination/vax_state.csv');
        
        if(args.length == 0){
            let total = -1;
            for (let i = 0; i < data.length; i++){
                total += parseInt(data[i].daily_total);
            }
            
            const embed = new MessageEmbed()
            .setTitle('Malaysia Covid-19 Vaccination')
            .setColor('#20b2aa')
            .addFields([
                { 
                    name: '`Date`', 
                    value: data[data.length - 1].date,
                    inline: true,  
                }, 
                {
                    name: '`Total Vaccinated`', 
                    value: total.toString(), 
                    // inline: true, 
                },
                {
                    name: '`Pfizer`', 
                    value: data[data.length - 2].daily_total, 
                    inline: true, 
                },
                { 
                    name: '`Sinovac`', 
                    value: data[data.length - 1].daily_total, 
                    inline: true, 
                },
                { 
                    name: '`Astrazeneca`', 
                    value: data[data.length - 3].daily_total, 
                    inline: true, 
                }, 
            ])
            .setFooter(`update: ${data[data.length - 1].date}`)
            return embed
        }
        else if(args.length == 1){
            // check date
            var isDate = false;
            var index2 = [];
            var stateNo = stateFunc(args);
            
            data.find(function(item, i){
                if(item.date == args.toString()){
                    isDate = true;
                    index2.push(i);
                }
            });
            
            console.log(index2);
            var typeNo = vType(args);
            
            var vtype = args.toString();
            if(vtype == 'az'){
                vtype = 'astrazeneca';
            }
            
            if(typeNo != -1 && !isDate && stateNo == -1){ // type: true
                
                var total = 0;
                
                for (let i = 0; i < data.length; i++){
                    if(data[i].vaxtype == vtype){
                        total += parseInt(data[i].daily_total);
                    }
                }
                
                const embed = new MessageEmbed()
                .setTitle(`Covid-19 Vaccination type: ${vtype.toUpperCase()}`)
                .setColor('#20b2aa')
                .addFields([ 
                    {
                        name: '`Date`', 
                        value: data[data.length - 1].date,
                        // inline: true,
                    },
                    {
                        name: '`Total Vaccinated`', 
                        value: total.toString(),
                        inline: true,
                    },
                    { 
                        name: '`Daily Vaccinated`', 
                        value: data[data.length - typeNo].daily_total,
                        inline: true,
                    }, 
                ])
                .setFooter(`update: ${data[data.length - 1].date}`)
                
                return embed
            }
            else if(typeNo == -1 && isDate && stateNo == -1){ // date: true
                const embed = new MessageEmbed()
                .setTitle(`Malaysia Covid-19 Vaccination on ${args.toString()}`)
                .setColor('#20b2aa')
                .addFields([ 
                    {
                        name: '`Astrazeneca`', 
                        value: data[index2[0]].daily_total,
                        inline: true, 
                    },
                    { 
                        name: '`Pfizer`', 
                        value: data[index2[1]].daily_total,
                        inline: true, 
                    },
                    { 
                        name: '`Sinovac`', 
                        value: data[index2[2]].daily_total,
                        inline: true, 
                    }, 
                ])
                .setFooter(`update: ${data[data.length - 1].date}`)
                
                return embed
            }
            else if(typeNo == -1 && !isDate && stateNo != -1){ // state: true
                const embed = new MessageEmbed()
                .setTitle(`Covid-19 Vaccination at ${args.toString().replace("_", " ")}`)
                .setColor('#20b2aa')
                .addFields([
                    { 
                        name: '`Date`', 
                        value: dataS[dataS.length - stateNo].date,
                        // inline: true,  
                    },
                    {
                        name: '`Total 1st Dose`', 
                        value: dataS[dataS.length - stateNo].cumul_partial, 
                        inline: true, 
                    },
                    {
                        name: '`Total 2nd Dose`', 
                        value: dataS[dataS.length - stateNo].cumul_full, 
                        inline: true, 
                    },
                    {
                        name: '`Total 3rd Dose`', 
                        value: dataS[dataS.length - stateNo].cumul_booster, 
                        inline: true, 
                    },
                    {
                        name: '`Astrazeneca(1)`', 
                        value: dataS[dataS.length - stateNo].astra1, 
                        inline: true, 
                    },
                    {
                        name: '`Pfizer(1)`', 
                        value: dataS[dataS.length - stateNo].pfizer1, 
                        inline: true, 
                    },
                    {
                        name: '`Sinovac(1)`', 
                        value: dataS[dataS.length - stateNo].sinovac1, 
                        inline: true, 
                    },
                    {
                        name: '`Astrazeneca(2)`', 
                        value: dataS[dataS.length - stateNo].astra2, 
                        inline: true, 
                    },
                    {
                        name: '`Pfizer(2)`', 
                        value: dataS[dataS.length - stateNo].pfizer2, 
                        inline: true, 
                    },
                    {
                        name: '`Sinovac(2)`', 
                        value: dataS[dataS.length - stateNo].sinovac2, 
                        inline: true, 
                    },
                ])
                .setFooter(`update: ${dataS[dataS.length - 1].date}`)
                return embed
            }
            else{
                return `Incorrect usage! Please use "${prefix() + path.basename(__filename, path.extname(__filename))} <Type>/<Date>"`
            }
        }
        else if(args.length == 2){
            let index = -1;
            var stateArgs = args[0].toString();
            
            if (stateArgs == 'Kuala_Lumpur' || stateArgs == 'Labuan' || stateArgs == 'Putrajaya'){
                stateArgs = 'W.P. ' + stateArgs.replace("_", " ");
            }
            
            dataS.find(function(item, i){
                if(item.date == args[1].toString() && item.state == stateArgs){
                    index = i;
                }
            });
            
            if(index != -1){
                const embed = new MessageEmbed()
                .setTitle(`Covid-19 Vaccination at ${args[0].toString().replace("_", " ")} on ${args[1].toString()}`)
                .setColor('#20b2aa')
                .addFields([
                    {
                        name: '`Total 1st Dose`', 
                        value: dataS[index].cumul_partial, 
                        inline: true, 
                    },
                    {
                        name: '`Total 2nd Dose`', 
                        value: dataS[index].cumul_full, 
                        inline: true, 
                    },
                    {
                        name: '`Total 3rd Dose`', 
                        value: dataS[index].cumul_booster, 
                        inline: true, 
                    },
                    {
                        name: '`Astrazeneca(1)`', 
                        value: dataS[index].astra1, 
                        inline: true, 
                    },
                    {
                        name: '`Pfizer(1)`', 
                        value: dataS[index].pfizer1, 
                        inline: true, 
                    },
                    {
                        name: '`Sinovac(1)`', 
                        value: dataS[index].sinovac1, 
                        inline: true, 
                    },
                    {
                        name: '`Astrazeneca(2)`', 
                        value: dataS[index].astra2, 
                        inline: true, 
                    },
                    {
                        name: '`Pfizer(2)`', 
                        value: dataS[index].pfizer2, 
                        inline: true, 
                    },
                    {
                        name: '`Sinovac(2)`', 
                        value: dataS[index].sinovac2, 
                        inline: true, 
                    },
                ])
                .setFooter(`update: ${dataS[dataS.length - 1].date}`)
                return embed
            }
            else{
                return `Incorrect usage! Please use "${prefix() + path.basename(__filename, path.extname(__filename))} <State> <Date>"`
            }
        }
    }
}
// date,state,daily_partial,daily_full,daily,daily_partial_child,daily_full_child,
// daily_booster,cumul_partial,cumul_full,cumul,cumul_partial_child,
// cumul_full_child,cumul_booster,
// pfizer1,pfizer2,sinovac1,sinovac2,astra1,astra2,cansino,pending