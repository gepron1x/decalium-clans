/*
 * decalium-clans
 * Copyright © 2022 George Pronyuk <https://vk.com/gpronyuk>
 *
 * decalium-clans is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * decalium-clans is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with decalium-clans. If not, see <https://www.gnu.org/licenses/>
 * and navigate to version 3 of the GNU Lesser General Public License.
 */
package org.gepron1x.clans.plugin.command.parser;

import cloud.commandframework.arguments.parser.ArgumentParseResult;
import cloud.commandframework.arguments.parser.ArgumentParser;
import cloud.commandframework.context.CommandContext;
import cloud.commandframework.exceptions.parsing.ParserException;
import net.kyori.adventure.audience.Audience;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.gepron1x.clans.plugin.util.message.Message;

import java.util.Queue;

public final class MessagingParser<C extends Audience, T> implements ArgumentParser<C, T> {

    private final ArgumentParser<C, T> argumentParser;
    private final Message fail;

    public MessagingParser(ArgumentParser<C, T> argumentParser, Message fail) {

        this.argumentParser = argumentParser;
        this.fail = fail;
    }
    @Override
    public @NonNull ArgumentParseResult<@NonNull T> parse(@NonNull CommandContext<@NonNull C> commandContext, @NonNull Queue<@NonNull String> inputQueue) {
        ArgumentParseResult<T> result = this.argumentParser.parse(commandContext, inputQueue);
        result.getFailure().filter(ParserException.class::isInstance)
                .map(ParserException.class::cast)
                .map(CaptionTagResolver::new)
                .map(fail::with)
                .ifPresent(commandContext.getSender()::sendMessage);
        return result;
    }


}
