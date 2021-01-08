package tk.patsite.Patserverdiscordbot.Events;

import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import tk.patsite.Patserverdiscordbot.MyLibs.Log;
import tk.patsite.Patserverdiscordbot.Settings;

public class MemberJoinEvent extends ListenerAdapter {

    private final Log log;

    public MemberJoinEvent(Log log) {
        this.log = log;
    }

    @Override
    public void onGuildMemberRoleAdd(final GuildMemberRoleAddEvent event) {
        log.info("event ran");
        if (event.getRoles().contains(event.getGuild().getRoleById(Settings.MEMBER_ROLE))) {
            log.info("tru if");
            // Welcome user
            event.getGuild().getTextChannelById(Settings.WELCOME_CHANNEL).sendMessage(Settings.RANDOM_WELCOME().replaceFirst("\\{user}", event.getMember().getAsMention())).queue();
        }
    }
}