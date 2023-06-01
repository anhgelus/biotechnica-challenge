MODPACK_LINK=$1
EULA=$2
MEMORY=$3

rm -fr /data/mods
rm -fr /data/config
rm -fr /data/global_packs

touch /data/eula.txt && echo eula=$EULA | tee /data/eula.txt
cd /data && java -Xmx$MEMORY -Xms2G -jar quilt-server-launch.jar nogui

