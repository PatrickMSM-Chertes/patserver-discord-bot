package tk.patsite.Patserverdiscordbot.Command.Commands;
/*
MIT License

Copyright (c) 2021 PatrickMSM

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import tk.patsite.Patserverdiscordbot.Command.Command;
import tk.patsite.Patserverdiscordbot.Settings;

public class KickCommand extends Command {



    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void perform(Message message, String[] args) {
        // Check admin
        if (message.getAuthor().getIdLong() != Settings.Misc.PATRICK_ID)
            return;

        // Check args
        if (args.length < 1) {
            message.getAuthor().openPrivateChannel().complete().sendMessage("No arguments!").queue();
            message.delete().queue();
            return;
        }

        Member member = message.getJDA().getGuildById(Settings.Misc.GUILD_ID).getMemberById(args[1]);
    }
}
