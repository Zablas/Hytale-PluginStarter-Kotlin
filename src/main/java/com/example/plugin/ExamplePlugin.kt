package com.example.plugin

import com.example.plugin.commands.CameraCommand
import com.example.plugin.commands.ExampleCommand
import com.example.plugin.commands.TitleCommand
import com.example.plugin.listeners.PlayerChatListener
import com.example.plugin.listeners.PlayerReadyListener
import com.hypixel.hytale.server.core.event.events.player.PlayerChatEvent
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent
import com.hypixel.hytale.server.core.plugin.JavaPlugin
import com.hypixel.hytale.server.core.plugin.JavaPluginInit
import java.util.function.Consumer
import javax.annotation.Nonnull

class ExamplePlugin(@Nonnull init: JavaPluginInit) : JavaPlugin(init) {
    override fun setup() {
        // Commands
        commandRegistry.registerCommand(CameraCommand())
        commandRegistry.registerCommand(ExampleCommand())
        commandRegistry.registerCommand(TitleCommand())

        // Events
        eventRegistry.registerGlobal<String?, PlayerChatEvent?>(
            PlayerChatEvent::class.java,
            Consumer { event: PlayerChatEvent? -> PlayerChatListener.onPlayerChat(event!!) })
        eventRegistry.registerGlobal<String?, PlayerReadyEvent?>(
            PlayerReadyEvent::class.java,
            Consumer { event: PlayerReadyEvent? -> PlayerReadyListener.onPlayerReady(event!!) })
    }
}