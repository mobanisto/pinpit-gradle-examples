import org.jetbrains.compose.jetbrainsCompose

plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.compose")
    id("de.mobanisto.pinpit")
}

repositories {
    jetbrainsCompose()
    mavenCentral()
    google()
}

val attributeUsage = Attribute.of("org.gradle.usage", String::class.java)

val currentOs: Configuration by configurations.creating {
    extendsFrom(configurations.implementation.get())
    attributes { attribute(attributeUsage, "java-runtime") }
}

val windowsX64: Configuration by configurations.creating {
    extendsFrom(configurations.implementation.get())
    attributes { attribute(attributeUsage, "java-runtime") }
}

val linuxX64: Configuration by configurations.creating {
    extendsFrom(configurations.implementation.get())
    attributes { attribute(attributeUsage, "java-runtime") }
}

val linuxArm64: Configuration by configurations.creating {
    extendsFrom(configurations.implementation.get())
    attributes { attribute(attributeUsage, "java-runtime") }
}

sourceSets {
    main {
        java {
            compileClasspath = currentOs
            runtimeClasspath = currentOs
        }
    }
}

dependencies {
    implementation("com.google.guava:guava:19.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    currentOs(compose.desktop.currentOs)
    windowsX64(compose.desktop.windows_x64)
    linuxX64(compose.desktop.linux_x64)
    linuxArm64(compose.desktop.linux_arm64)
}

val versionCode by extra("1.0.0")

pinpit.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            jvmVendor = "adoptium"
            jvmVersion = "17.0.5+8"

            packageVersion = versionCode
            packageName = "PinpitComposeHelloWorld"
            description = "Test description"
            copyright = "Test Copyright Holder"
            vendor = "Test Vendor"

            linux {
                shortcut = true
                packageName = "pinpit-compose-hello-world"
                debMaintainer = "example@example.com"
                debPackageVersion = versionCode
                appCategory = "utils"
                menuGroup = "System;Utility"
                iconFile.set(project.file("src/main/packaging/deb/hello.png"))
                debPreInst.set(project.file("src/main/packaging/deb/preinst"))
                debPostInst.set(project.file("src/main/packaging/deb/postinst"))
                debPreRm.set(project.file("src/main/packaging/deb/prerm"))
                debPostRm.set(project.file("src/main/packaging/deb/postrm"))
                debCopyright.set(project.file("src/main/packaging/deb/copyright"))
                debLauncher.set(project.file("src/main/packaging/deb/launcher.desktop"))
                deb("UbuntuFocalX64") {
                    qualifier = "ubuntu-20.04"
                    arch = "x64"
                    depends(
                        "libc6", "libexpat1", "libgcc-s1", "libpcre3", "libuuid1", "xdg-utils",
                        "zlib1g", "libnotify4"
                    )
                }
                deb("UbuntuBionicX64") {
                    qualifier = "ubuntu-18.04"
                    arch = "x64"
                    depends(
                        "libasound2", "libc6", "libexpat1", "libfontconfig1", "libfreetype6",
                        "libgcc1", "libglib2.0-0", "libgraphite2-3", "libharfbuzz0b",
                        "libjpeg-turbo8", "liblcms2-2", "libpcre3", "libpng16-16", "libstdc++6",
                        "xdg-utils", "zlib1g", "libnotify4"
                    )
                }
                deb("DebianBullseyeX64") {
                    qualifier = "debian-bullseye"
                    arch = "x64"
                    depends(
                        "libasound2", "libbrotli1", "libc6", "libexpat1", "libfontconfig1",
                        "libfreetype6", "libgcc-s1", "libglib2.0-0", "libgraphite2-3",
                        "libharfbuzz0b", "libjpeg62-turbo", "liblcms2-2", "libpcre3",
                        "libpng16-16", "libstdc++6", "libuuid1", "xdg-utils", "zlib1g",
                        "libnotify4"
                    )
                }
                distributableArchive {
                    format = "tar.gz"
                    arch = "arm64"
                }
            }
            windows {
                dirChooser = true
                shortcut = true
                menuGroup = "pinpit"
                upgradeUuid = "64BFBE38-36BA-43A4-B843-F3B98E39B24F"
                packageVersion = versionCode
                iconFile.set(project.file("src/main/packaging/windows/hello.ico"))
                msi {
                    arch = "x64"
                    bitmapBanner.set(project.file("src/main/packaging/windows/banner.bmp"))
                    bitmapDialog.set(project.file("src/main/packaging/windows/dialog.bmp"))
                }
            }
        }
    }
}
