/*
 * This file was generated by the Gradle "init" task.
 */

plugins {
    id("com.github.johnrengelman.shadow") version "7.0.0"
    java
    id ("maven-publish")
    id("io.papermc.paperweight.userdev") version "1.1.11"
}


// apply plugin: "io.papermc.paperweight.userdev"

apply(plugin = "com.github.johnrengelman.shadow")

repositories {
    mavenLocal()
    maven { url = uri("https://maven.enginehub.org/repo/") }
    maven { url = uri("https://papermc.io/repo/repository/maven-public/") }
    maven { url = uri("https://oss.sonatype.org/content/groups/public/") }
    maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots/") }
    maven { url = uri("https://repo.aikar.co/content/groups/aikar/") }
    maven { url = uri("https://repo.extendedclip.com/content/repositories/placeholderapi/") }
    maven { url = uri("https://repo.maven.apache.org/maven2/") }
}

dependencies {
    //compileOnly("io.papermc.paper:paper-api:1.17.1-R0.1-SNAPSHOT")
    paperDevBundle("1.17.1-R0.1-SNAPSHOT")
    implementation("co.aikar:acf-paper:0.5.0-SNAPSHOT")
    implementation("com.zaxxer:HikariCP:5.0.0")
    implementation("com.h2database:h2:1.4.200")
    implementation("space.arim.dazzleconf:dazzleconf-ext-snakeyaml:1.2.1") {
        exclude(group = "org.yaml", module = "snakeyaml")
    }
    implementation ("net.kyori:adventure-text-minimessage:4.1.0-SNAPSHOT") {
        exclude(group = "net.kyori", module = "adventure-api")
    }
    implementation("org.jdbi:jdbi3-core:3.21.0")
    implementation("org.jdbi:jdbi3-sqlobject:3.21.0")
    compileOnly("me.clip:placeholderapi:2.10.0")
    compileOnly("com.sk89q.worldguard:worldguard-bukkit:7.0.6-SNAPSHOT")
    compileOnly("org.slf4j:slf4j-api:1.7.32")
}



var libsPackage = "org.gepron1x.libraries"

group = "org.gepron1x.clans"
version = "1.0-SNAPSHOT"
description = "DecaliumClans"

java.sourceCompatibility = JavaVersion.VERSION_16



tasks {
    compileJava {
        options.encoding = "UTF-8"
        options.compilerArgs.add("-parameters")
    }
    processResources {
        expand("version" to version)
    }
    build {
        dependsOn(reobfJar)
        dependsOn(shadowJar)
    }
    shadowJar {
        relocate("org.h2", "$libsPackage.h2")
        relocate("com.zaxxer.hikari", "$libsPackage.hikari")
        relocate("org.jdbi", "$libsPackage.jdbi")
        relocate("space.arim.dazzleconf", "$libsPackage.dazzleconf")
        relocate("net.kyori.adventure.text.minimessage", "$libsPackage.minimessage")
        relocate("co.aikar.commands", "$libsPackage.acf")
        relocate("co.aikar.locales", "$libsPackage.locales")
        relocate("com.github.benmanes.caffeine", "$libsPackage.caffeine")
        relocate("io.leangen.geantyref", "$libsPackage.geantyref")

    }
}
