package com.example.plugin.listeners

import com.example.plugin.chat.ChatMessageFormatter
import com.hypixel.hytale.server.core.event.events.player.PlayerChatEvent

object PlayerChatListener {
    private val FORMATTER = ChatMessageFormatter()

    fun onPlayerChat(event: PlayerChatEvent) {
        event.formatter = FORMATTER
    }
}
