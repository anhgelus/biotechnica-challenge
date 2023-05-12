FROM golang:1.19-alpine as builder
		
WORKDIR /app

RUN apk add git && \
	git clone https://github.com/nothub/mrpack-install.git

RUN cd mrpack-install && \
	go build -o mrpack-install .

FROM azul/zulu-openjdk-alpine:17-latest

WORKDIR /data

RUN mkdir -p /app

COPY --from=builder /app/mrpack-install/mrpack-install /app/mrpack-install

ARG MODPACK_LINK

EXPOSE 25565
EXPOSE 24454

CMD /app/mrpack-install $MODPACK_LINK && sleep 360


