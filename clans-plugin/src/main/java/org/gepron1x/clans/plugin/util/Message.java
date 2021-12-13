package org.gepron1x.clans.plugin.util;

import com.google.common.collect.Lists;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.Template;
import net.kyori.adventure.text.minimessage.template.TemplateResolver;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public record Message(MiniMessage miniMessage,
                      String value) implements ComponentLike, TemplateHolder<Message.Container> {

    @Override
    public @NotNull Component asComponent() {
        return miniMessage.deserialize(value);
    }

    @Override
    public Container with(Template template) {
        return with(Collections.singleton(template));
    }

    @Override
    public Container with(Iterable<Template> templates) {
        if (templates instanceof Collection<Template> collection) {
            return with(collection);
        }
        return with(Lists.newArrayList(templates));
    }

    public static Message message(@NotNull String value, @NotNull MiniMessage miniMessage) {
        return new Message(miniMessage, value);
    }

    public static Message message(@NotNull String value) {
        return message(value, MiniMessage.miniMessage());
    }

    @Override
    public Container with(Collection<Template> templates) {
        return new Container(value, miniMessage, templates);
    }


    public static final class Container implements ComponentLike, TemplateHolder<Container> {
        private final String value;
        private final MiniMessage miniMessage;
        private final List<Template> templates;

        private Container(String value, MiniMessage miniMessage, Collection<Template> templates) {

            this.value = value;
            this.miniMessage = miniMessage;
            this.templates = new ArrayList<>(templates);
        }

        @Override
        public @NotNull
        Component asComponent() {
            return miniMessage.deserialize(value, TemplateResolver.templates(templates));
        }


        @Override
        public Container with(Template template) {
            this.templates.add(template);
            return this;
        }

        @Override
        public Container with(Iterable<Template> templates) {
            if (templates instanceof Collection<Template> collection) return with(collection);
            for (Template template : templates) this.templates.add(template);
            return this;
        }

        @Override
        public Container with(Collection<Template> templates) {
            this.templates.addAll(templates);
            return this;
        }
    }


}
