FROM java:8-jre
MAINTAINER Kamil Turek <kamilptf@gmail.com>

ADD ./target/payment-service-1.0.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/payment-service-1.0.jar"]

EXPOSE 8002