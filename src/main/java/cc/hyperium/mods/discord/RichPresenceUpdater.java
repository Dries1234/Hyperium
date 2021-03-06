/*
 * Hyperium Client, Free client with huds and popular mod
 *     Copyright (C) 2018  Hyperium Dev Team
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published
 *     by the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package cc.hyperium.mods.discord;

import cc.hyperium.Hyperium;
import cc.hyperium.event.*;
import com.jagrosh.discordipc.IPCClient;
import com.jagrosh.discordipc.entities.RichPresence;
import net.minecraft.client.Minecraft;

import java.time.OffsetDateTime;

public class RichPresenceUpdater {

    private IPCClient client;

    RichPresenceUpdater(IPCClient client) {
        this.client = client;
        RichPresence.Builder builder = new RichPresence.Builder();
        client.sendRichPresence(builder
                .setSmallImage("compass")
                .setLargeImage("hyperium", "Hyperium Client")
                .setState("IGN: " + Minecraft.getMinecraft().getSession().getUsername())
                .setStartTimestamp(OffsetDateTime.now())
                .build());
    }

    @InvokeEvent(priority = Priority.LOW)
    public void onServerJoin(ServerJoinEvent event) {
        RichPresence.Builder builder = new RichPresence.Builder();
        if (Hyperium.INSTANCE.getHandlers().getHypixelDetector().isHypixel()) {
            client.sendRichPresence(builder
                    .setSmallImage("compass")
                    .setLargeImage("16", "Hypixel Network")
                    .setState("IGN: " + Minecraft.getMinecraft().getSession().getUsername())
                    .setStartTimestamp(OffsetDateTime.now())
                    .build());
        } else {
            client.sendRichPresence(builder
                    .setSmallImage("compass")
                    .setLargeImage("16", "Hypixel Network")
                    .setState("IGN: " + Minecraft.getMinecraft().getSession().getUsername())
                    .setStartTimestamp(OffsetDateTime.now())
                    .build());
        }
    }

    @InvokeEvent(priority = Priority.LOW)
    public void onMinigameJoin(JoinMinigameEvent event) {
        RichPresence.Builder builder = new RichPresence.Builder();
        client.sendRichPresence(builder
                .setSmallImage("compass")
                .setLargeImage(String.valueOf(event.getMinigame().getId()), event.getMinigame().getScoreName())
                .setState("IGN: " + Minecraft.getMinecraft().getSession().getUsername())
                .setStartTimestamp(OffsetDateTime.now())
                .build());

    }

    @InvokeEvent(priority = Priority.LOW)
    public void onSinglePlayer(SingleplayerJoinEvent event) {
        RichPresence.Builder builder = new RichPresence.Builder();
        client.sendRichPresence(builder
                .setSmallImage("compass")
                .setLargeImage("hyperium", "Hyperium Client")
                .setState("IGN: " + Minecraft.getMinecraft().getSession().getUsername())
                .setStartTimestamp(OffsetDateTime.now())
                .build());
    }
}
