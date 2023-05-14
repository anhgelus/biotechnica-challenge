# BioTechnica Challenge

Official repository of the BioTechnica Challenge.

## What is this?

BioTechnica Challenge is a Minecraft event like a Terminator (the opposite of the Manhunt).

- Several players (the heros) with one life against one speedrunner (the hunter) with multiple life
- The goal of the heros is to kill the Ender Dragon and to build a house with farms and redstone systems
- The goal of the hunter is to kill the heros

## Play

To play with this modpack, you must install it on the server-side and on the client-side.

### Client Side

To install it on the client-side, install it as a normal Modrinth modpack.

Follow [these instructions](https://docs.modrinth.com/docs/modpacks/playing_modpacks/) if you don't know how to install it.

If you don't know wich launcher used, I recommend you to use the [PrismLauncher](https://prismlauncher.org/).

### Server Side

There are two ways to install the modpack on the server side: [Docker](https://www.docker.com) and [mrpack-install](https://github.com/nothub/mrpack-install).

After installing the server, don't forget to setup Simple Voice Chat by editing the file `config/voicechat/voicechat-server.properties` (necessary if you are using Docker or a custom setup) and to look at the [Player Tracking Compass](https://modrinth.com/mod/player-tracking-compass) mod.

#### Docker

Follow these steps to install it with Docker:

1. Install Docker
2. Clone the repo `git clone https://github.com/anhgelus/biotechnica-challenge.git`
3. Go into the folder called "docker" inside the cloned repo `cd biotechnica-challenge/docker`
4. Rename the `.env.exemple` into `.env` `mv .env.exemple .env`
5. Setup the environment variables inside the `.env`
    * `MODPACK_LINK` - Direct link to download the modpack (get it from Modrinth). It should look like this `https://cdn.modrinth.com/data/t8UHSB82/versions/IDTqzFur/BioTechnica-Challenge-0.6.0.mrpack`
    * `EULA` - Accept the Minecraft's EULA
    * `MEMORY` - The memory used by the server (at least 2G)
6. And start the container ! `docker compose up -d --build`

#### mrpack-install

Follow these steps to install the modpack with mrpack-install:

1. Install mrpack-install
2. Get a direct link to download the modpack. It should look like this `https://cdn.modrinth.com/data/t8UHSB82/versions/IDTqzFur/BioTechnica-Challenge-0.6.0.mrpack`.
3. Run `mrpack-install LINK_TO_THE_MODPACK`. It will create a folder called `mc`
4. Go into this folder `cd mc`
5. Start the server with `java -jar quilt-server-launch.jar nogui`.

:warning: Actually, the version of mrpack-install do not work with Quilt! I have made a PR fixing this issue. As long as this error was not fixed, use my fork available [here](https://github.com/anhgelus/mrpack-install).

#### Generating the server with Docker but running it outside of Docker

You don't want to install mrpack-install? 

Just follow the steps to install it with Docker and stop it when Minecraft server start (you can see when it starts with `docker compose logs`).

It will create a folder called `minecraft-data` and follow these steps:

1. Give you the own of the folder `chown -R user:user minecraft-data`
2. Go into this folder `cd minecraft-data`
3. Start the server with `java -jar quilt-server-launch.jar nogui`.

## Content

In this repo you will see two folder:

- The "modpack" folder
- The "datapacks" folder
- The "docker" folder

### Modpack folder

The modpack to play with, [Modrinth](https://modrinth.com/) format.

Made with [packwiz](https://github.com/packwiz/packwiz/).

### Datapacks folder

Contains every datapacks needed by the BioTechnica Challenge.

- **biotechnica-life** - managed the life of every players: unlimited for the killer (He must run `/function biotechnica-life:killer/i_am_the_killer` to become the killer) and one life for the heroes

### Docker folder

Everything related to Docker.

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

