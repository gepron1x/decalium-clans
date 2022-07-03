package org.gepron1x.clans.api.edition.member;

import org.gepron1x.clans.api.clan.member.ClanMember;
import org.gepron1x.clans.api.clan.member.ClanRole;
import org.gepron1x.clans.api.edition.Edition;
import org.jetbrains.annotations.NotNull;

public interface MemberEdition extends Edition<ClanMember> {

    @Override
    @NotNull
    default Class<ClanMember> getTarget() {
        return ClanMember.class;
    }

    MemberEdition appoint(@NotNull ClanRole role);

}