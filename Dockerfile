FROM registry.bose.io/core-operations/openjdk:8
MAINTAINER Ric-Schnur-Bose <rick_schnur@bose.com>

ENV APP_HOME=/home/app
ENV JAVA_HOME=/usr/lib/jvm/jre-1.8.0-openjdk
RUN /bin/mkdir $APP_HOME

ADD target/eco2-data-reconciliation-core-0.0.1-SNAPSHOT.jar $APP_HOME/eco2-data-reconciliation.jar
RUN /bin/mkdir -p /mount/log
VOLUME /mount/log
##
# Start the Java App
#
WORKDIR /home/app
ENTRYPOINT java $JAVA_OPTS -Xms256m -Xmx1024m -Djava.security.egd=file:/dev/./urandom -jar eco2-data-reconciliation.jar
