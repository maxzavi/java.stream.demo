FROM eclipse-temurin:17-jre-alpine
COPY bin/App.class bin/App.class
ENTRYPOINT exec java -cp bin App
