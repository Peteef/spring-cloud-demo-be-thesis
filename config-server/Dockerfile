FROM java:8-jre
MAINTAINER Kamil Turek <kamilptf@gmail.com>

ADD ./target/config-server-1.0.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/config-server-1.0.jar"]

HEALTHCHECK --interval=30s --timeout=30s CMD curl -f http://localhost:8888/actuator/health || exit 1

EXPOSE 8888