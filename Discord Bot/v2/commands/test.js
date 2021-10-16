module.exports = {  
    category: 'Testing',  
    description: 'Replies with test', // Required for slash commands    
    
    slash: 'both', // Create both a slash and legacy command  
    // testOnly: true, // Only register a slash command for the testing guilds    
     
    callback: ({}) => {    
        return 'test reply'
    },
}