FROM openjdk:11
VOLUME /tmp
WORKDIR /usr/local/bin
ADD target/contactbook-1.0.0.jar ./app.jar
EXPOSE 8080

CMD ["java", "-jar", "app.jar"]