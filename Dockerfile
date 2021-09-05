FROM openjdk:11
COPY ./target/tg-meme-bot-1.1.jar /
WORKDIR /
EXPOSE 6080
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "tg-meme-bot-1.1.jar"]