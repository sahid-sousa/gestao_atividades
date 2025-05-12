FROM azul/zulu-openjdk-alpine:8

ARG ARG_GRAILS_ENV
ENV GRAILS_ENV=${ARG_GRAILS_ENV}

WORKDIR /opt/app

COPY build/libs/gestao-atividades-0.1.war app.jar

RUN apk --update add fontconfig ttf-dejavu

RUN apk add --no-cache tzdata
ENV TZ America/Belem
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

CMD java $JAVA_OPTS -Dgrails.env=$GRAILS_ENV -server -jar app.jar
