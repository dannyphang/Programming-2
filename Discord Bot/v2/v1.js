import DiscordJS, { Intents } from 'discord.js'
import dotenv from 'dotenv'
import WOKCommands from 'wokcommands'
dotenv.config()

const client = new DiscordJS.Client({
    intents: [
        Intents.FLAGS.GUILDS,
        Intents.FLAGS.GUILD_MESSAGES, 
    ]
})
client.on('ready', () => {
    console.log('The bot is ready')
    
    const guildId = '596956215972462603';
    const guild = client.guilds.cache.get(guildId)
    let commands
    
    if (guild){
        commands = guild.commands
    }
    else{
        commands = client.application?.commands
    }
    
    commands?.create({ 
        name: 'ping', 
        description: 'Replies with pong.', 
    })
    
    commands?.create({ 
        name: 'add', 
        description: 'Adds two numbers.', 
        options: [
            {
                name: 'num1', 
                description: 'The first number.', 
                required: true, 
                type: DiscordJS.Constants.ApplicationCommandOptionTypes.NUMBER
            },
            {
                name: 'num2', 
                description: 'The second number.', 
                required: true, 
                type: DiscordJS.Constants.ApplicationCommandOptionTypes.NUMBER
            }
        ]
    })
})

client.on('interactionCreate', async (interaction) => {
    if(!interaction.isCommand()){
        return
    }
    const { commandName, options } = interaction
    
    if (commandName === 'ping') {
        interaction.reply({
            content: 'pong! ' + interaction.member.displayName, 
            ephemeral: true, // it will only allow the sender see the message
        })
    }
    else if (commandName === 'add') {
        const num1 = options.getNumber('num1') || 0
        const num2 = options.getNumber('num2') || 0
        
        // to defer the reply (mroe time to reply)
        await interaction.deferReply({
            ephemeral
        })
        
        await new Promise(resolve => setTimeout(resolve, 5000)) // 5 sec
        
        await interaction.reply({
            content: `The sum is ${num1 + num2}`,
        })
    }
})

client.login(process.env.TOKEN)