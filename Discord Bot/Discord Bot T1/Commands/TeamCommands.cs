using DSharpPlus.CommandsNext;
using DSharpPlus.CommandsNext.Attributes;
using DSharpPlus.Entities;
using DSharpPlus.Interactivity.Extensions;
using System.Threading.Tasks;

namespace Discord_Bot_T1.Commands
{
    public class TeamCommands : BaseCommandModule
    {
        [Command("join")]
        [Description("Returns pong")]
        public async Task Join(CommandContext ctx)
        {
            DiscordEmbedBuilder.EmbedThumbnail thumbnailWorkAround = new DiscordEmbedBuilder.EmbedThumbnail();
            thumbnailWorkAround.Url = ctx.Client.CurrentUser.AvatarUrl;

            var joinEmbed = new DiscordEmbedBuilder
            {
                Title = "Would you like to join?", 
                Thumbnail = thumbnailWorkAround, 
                Color = DiscordColor.Green, 

            };

            var joinMsg = await ctx.Channel.SendMessageAsync(embed: joinEmbed).ConfigureAwait(false);

            var thumbsUpEmoji = DiscordEmoji.FromName(ctx.Client, ":+1:");
            var thumbsDownEmoji = DiscordEmoji.FromName(ctx.Client, ":-1:");

            await joinMsg.CreateReactionAsync(thumbsUpEmoji).ConfigureAwait(false);
            await joinMsg.CreateReactionAsync(thumbsDownEmoji).ConfigureAwait(false);

            var interactivity = ctx.Client.GetInteractivity();

            var reactionResult = await interactivity.WaitForReactionAsync(
                x => x.Message == joinMsg &&
                x.User == ctx.User &&
                (x.Emoji == thumbsUpEmoji || x.Emoji == thumbsDownEmoji)).ConfigureAwait(false);

            if(reactionResult.Result.Emoji == thumbsUpEmoji)
            {
                var role = ctx.Guild.GetRole(897900037126889502);
                await ctx.Member.GrantRoleAsync(role).ConfigureAwait(false);
            }

            await joinMsg.DeleteAsync().ConfigureAwait(false);
        }

       
    }
}
