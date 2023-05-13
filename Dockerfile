FROM golang:1.19-alpine as builder
		
WORKDIR /app

RUN apk add git && \
	git clone https://github.com/anhgelus/mrpack-install.git

RUN cd mrpack-install && \
	go build -o mrpack-install .

FROM azul/zulu-openjdk-alpine:17-latest

WORKDIR /data

RUN mkdir -p /app && mkdir -p /data/mc

COPY --from=builder /app/mrpack-install/mrpack-install /app/mrpack-install

ARG MODPACK_LINK
ARG MEMORY=4G
ARG EULA=false

RUN touch /data/mc/eula.txt && echo $EULA=true | tee /data/mc/eula.txt

EXPOSE 25565
EXPOSE 24454

CMD /app/mrpack-install $MODPACK_LINK && java -jar /data/mc/quilt-server-launch.jar nogui -Xmx $MEMORY -Xms 2G


