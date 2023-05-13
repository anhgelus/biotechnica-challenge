
MODPACK_LINK=$1
EULA=$2
MEMORY=$3

echo $MEMORY EULA=$EULA

cat /data/eula.txt

echo $MODPACK_LINK && /app/mrpack-install $MODPACK_LINK --server-dir /data
touch /data/eula.txt && echo eula=$EULA | tee /data/eula.txt
cd /data && java -Xmx$MEMORY -Xms2G -jar quilt-server-launch.jar nogui

