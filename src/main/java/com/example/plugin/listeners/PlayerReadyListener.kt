package com.example.plugin.listeners

import com.hypixel.hytale.server.core.Message
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent

object PlayerReadyListener {
    fun onPlayerReady(event: PlayerReadyEvent) {
        val player = event.player
        player.sendMessage(Message.raw("Welcome " + player.displayName))
    }
}