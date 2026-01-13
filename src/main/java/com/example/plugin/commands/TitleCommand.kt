package com.example.plugin.commands

import com.example.plugin.utils.ServerUtil.executeWorld
import com.hypixel.hytale.server.core.Message
import com.hypixel.hytale.server.core.command.system.CommandContext
import com.hypixel.hytale.server.core.command.system.arguments.system.RequiredArg
import com.hypixel.hytale.server.core.command.system.arguments.types.ArgTypes
import com.hypixel.hytale.server.core.command.system.basecommands.CommandBase
import com.hypixel.hytale.server.core.util.EventTitleUtil
import javax.annotation.Nonnull

class TitleCommand : CommandBase("example_title", "Show a title to all players", false) {
    @Nonnull
    private val titleArg: RequiredArg<String?> = this.withRequiredArg<String?>(
        "title", "com.example.plugin.commands.title.arg.title",
        ArgTypes.STRING
    )

    @Nonnull
    private val subtitleArg: RequiredArg<String?> = this.withRequiredArg<String?>(
        "subtitle", "com.example.plugin.commands.title.arg.subtitle",
        ArgTypes.STRING
    )

    override fun executeSync(@Nonnull ctx: CommandContext) {
        val title = ctx.get<String?>(this.titleArg) as String
        val subtitle = ctx.get<String?>(this.subtitleArg) as String

        executeWorld(Runnable {
            EventTitleUtil.showEventTitleToUniverse(
                Message.raw(title),
                Message.raw(subtitle),
                false,
                null,
                4f,
                1.5f,
                1.5f
            )
        })
    }
}
