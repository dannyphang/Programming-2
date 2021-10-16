const { MessageEmbed } = require('discord.js');
module.exports = {
    category: 'Testing', 
    description: 'Sends an embed', 
    
    permissions: ['ADMINISTRATOR'], 
    
    callback: async ({ message, text }) => {
        const json = JSON.parse(text);
        
        // -------------------------------
        // allow user to create the embed in the discord
        const embed = new MessageEmbed(json)
        
        return embed
        
        // -------------------------------
        // pre-create embed behind the code
        // const embed = new MessageEmbed()
        // .setDescription('Hello world')
        // .setTitle('Title')
        // .setColor('RED')
        // .setAuthor('Alex')
        // .setFooter('Footer')
        // .addFields([
        //     { 
        //         name: 'name', 
        //         value: 'value',
        //         inline: true,  
        //     }, 
        //     {
        //         name: 'name 2', 
        //         value: 'value 2', 
        //         inline: true, 
        //     }, 
        // ])
        // .addField('name 3', 'value 3')
            
        // const newMessage = await message.reply({
        //     embeds: [embed]
        // })
        
        // await new Promise((resolve) => setTimeout(resolve, 5000))
        
        // const newEmbed = newMessage.embeds[0]
        // newEmbed.setTitle('Edited Title')
        
        // newMessage.edit({
        //     embeds: [newEmbed], 
        // })
        
        // return embed
    },
}