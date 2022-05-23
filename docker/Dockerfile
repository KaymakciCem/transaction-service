FROM openjdk

VOLUME /tmp

ADD maven/transaction-service-0.0.1-SNAPSHOT.jar transaction-service.jar

ENTRYPOINT ["java","-jar","transaction-service.jar"]