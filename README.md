# BioTechnica Challenge

Official repository of the BioTechnica Challenge.

## What is this?

BioTechnica Challenge is a Minecraft event like a Terminator (the opposite of the Manhunt).

- Several players (the heros) with one life against one speedrunner (the hunter) with multiple life
- The goal of the heros is to kill the Ender Dragon and to build a house with farms and redstone systems
- The goal of the hunter is to kill the heros

## Content

In this repo you will see two folder:

- The "modpack" folder
- The "datapacks" folder

### Modpack folder

The modpack to play with, [Modrinth](https://modrinth.com/) format.

Made with [packwiz](https://github.com/packwiz/packwiz/).

### Datapacks folder

Contains every datapacks needed by the BioTechnica Challenge.

- **biotechnica-life** - managed the life of every players: unlimited for the killer (He must run `/function biotechnica-life:killer/i_am_the_killer` to become the killer) and one life for the heroes

## Versioning

The versioning used here is based on the [semver](https://semver.org).

Rules:

> Every version will follow this schem: `B.M.m-T`

- `B` is the breaking change update. It will change when a breaking change will happened.
- `M` is the major update. When a new feature comes, this number will change.
- `m` is the minor update. When a patch comes, this number will change.
- `T` is the type version. It has a unique ID for each project inside this repo: `modpack` for the modpack, `biotechnica-life` for the datapack with the same name.

## Credits

Thanks to

- @SuperNoobYT for the configuration of CraftPresence!
- @aypierre42 for the configuration of the Complementary Shader

