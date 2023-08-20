FROM openjdk:17-jdk
EXPOSE 9092
ADD target/crm-0.0.1-SNAPSHOT.jar crm.jar
HEALTHCHECK --interval=30s --timeout=10s --retries=3 \
  CMD curl --fail http://localhost:9092/ || exit 1
ENTRYPOINT ["java", "-jar", "crm.jar"]