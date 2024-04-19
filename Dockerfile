FROM openjdk:21
WORKDIR /app
COPY ./Service/target/Service-1.0-SNAPSHOT.jar/ /app
COPY ./Provider/target/Provider-1.0-SNAPSHOT.jar/ /app
COPY ./Consumer/target/Consumer-1.0-SNAPSHOT.jar/ /app
CMD ["java", "--module-path","/app","--module","se.iths.consumer/se.iths.consumer.Main"]