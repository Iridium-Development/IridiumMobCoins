plugins {
    java
    `maven-publish`
    id("com.gradleup.shadow") version "8.3.7"
}

group = "com.iridium"
version = "1.0.6"
description = "IridiumMobCoins"

repositories {
    maven("https://repo.mvdw-software.com/content/groups/public/")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://repo.extendedclip.com/releases/")
    maven("https://ci.ender.zone/plugin/repository/everything/")
    maven("https://jitpack.io")
    maven("https://nexus.iridiumdevelopment.net/repository/maven-releases/")
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://repo.rosewooddev.io/repository/public/")
    maven("https://repo.jeff-media.com/public/")
}

dependencies {
    // Dependencies that we want to shade in
    implementation("com.iridium", "IridiumCore", "2.0.9")
    implementation("org.bstats", "bstats-bukkit", "3.1.0")
    implementation("org.apache.commons", "commons-text", "1.13.1")
    implementation("com.j256.ormlite", "ormlite-core", "6.1")
    implementation("com.j256.ormlite", "ormlite-jdbc", "6.1")
    implementation("de.jeff_media", "SpigotUpdateChecker", "1.3.2")

    // Other dependencies that are not required or already available at runtime
    compileOnly("org.projectlombok", "lombok", "1.18.38")
    compileOnly("org.spigotmc", "spigot-api", "1.17-R0.1-SNAPSHOT")
    compileOnly("me.clip", "placeholderapi", "2.11.6")
    compileOnly("be.maximvdw", "MVdWPlaceholderAPI", "2.1.1-SNAPSHOT") {
        exclude("org.spigotmc")
    }

    // Enable lombok annotation processing
    annotationProcessor("org.projectlombok", "lombok", "1.18.38")
}

tasks {
    // "Replace" the build task with the shadowJar task (probably bad but who cares)
    jar {
        dependsOn("shadowJar")
        enabled = false
    }

    shadowJar {
        fun relocate(origin: String) =
            relocate(origin, "com.iridium.iridiummobcoins.dependencies${origin.substring(origin.lastIndexOf('.'))}")

        // Remove the archive classifier suffix
        archiveClassifier.set("")

        // Relocate dependencies
        relocate("com.iridium.iridiumcore")
        relocate("com.j256.ormlite")
        relocate("de.jeff_media")

        // Relocate IridiumCore dependencies
        relocate("de.tr7zw.changeme.nbtapi")
        relocate("com.iridium.iridiumcolorapi")
        relocate("org.yaml.snakeyaml")
        relocate("io.papermc.lib")
        relocate("com.cryptomorin.xseries")
        relocate("com.fasterxml.jackson")
        relocate("org.apache.commons")

        // Remove unnecessary files from the jar
        minimize()
    }

    // Set UTF-8 as the encoding
    compileJava {
        options.encoding = "UTF-8"
        sourceCompatibility = JavaVersion.VERSION_1_8.toString()
        targetCompatibility = JavaVersion.VERSION_1_8.toString()
    }

    // Process Placeholders for the plugin.yml
    processResources {
        filesMatching("**/plugin.yml") {
            expand(rootProject.project.properties)
        }

        // Always re-run this task
        outputs.upToDateWhen { false }
    }
}

// Maven publishing
publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}
