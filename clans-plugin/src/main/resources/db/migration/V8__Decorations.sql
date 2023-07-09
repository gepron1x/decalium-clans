ALTER TABLE `clans` ADD `decoration` JSON DEFAULT 'null';

CREATE OR REPLACE VIEW `clans_simple` AS SELECT
`C`.`id` `clan_id`, `C`.`tag` `clan_tag`, `C`.`owner` `clan_owner`, `C`.`display_name` `clan_display_name`, `C`.`decoration` `clan_decoration`,
`M`.`uuid` `member_uuid`, `M`.`role` `member_role`, `M`.`joined` `member_joined`,
`H`.`name` `home_name`, `H`.`creator` `home_creator`, `H`.`display_name` `home_display_name`, `H`.`icon` `home_icon`, `H`.`level` `home_level`,
`L`.`x` `location_x`, `L`.`y` `location_y`, `L`.`z` `location_z`, `L`.`world` `location_world`,
`S`.`type` `statistic_type`, `S`.`value` `statistic_value`
FROM `clans` `C`
LEFT JOIN `members` `M` ON `C`.`id` = `M`.`clan_id`
LEFT JOIN `homes` `H` ON `C`.`id` = `H`.`clan_id`
LEFT JOIN `locations` `L` ON `H`.`id` = `L`.`home_id`
LEFT JOIN `statistics` `S` ON `C`.`id` = `S`.`clan_id`;