FROM golang:1.19-alpine as builder
		
WORKDIR /app

RUN apk add git && \
	git clone https://github.com/anhgelus/mrpack-install.git

RUN cd mrpack-install && \
	go build -o mrpack-install .

FROM azul/zulu-openjdk-alpine:17-latest

WORKDIR /

VOLUME /data 

RUN mkdir -p /app

COPY --from=builder /app/mrpack-install/mrpack-install /app/mrpack-install

COPY ./start.sh /app/start.sh

ARG MODPACK_LINK
ARG MEMORY
ARG EULA

EXPOSE 25565
EXPOSE 24454

CMD sh /app/start.sh ${MODPACK_LINK} ${EULA} ${MEMORY}

