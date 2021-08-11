FROM artifactory.apps.xxxxxx.com/devops/adoptopenjdk/openjdk8-openj9:x86_64-alpine-jre8u275-b01_openj9-0.23.0.v2
EXPOSE 8080
COPY --chown=appuser:appuser *.jar app.jar
ENV JAVA_OPTS="-XX:+UseContainerSupport -Dfile.encoding=UTF-8 -Djava.security.egd=file:/dev/./urandom"
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar app.jar"]