FROM openjdk:17-jdk-slim
WORKDIR /app
COPY . .
RUN ./mvnw clean package
CMD ["java", "-jar", "target/meu_segundo_projeto-0.0.1-SNAPSHOT.jar"]
git add .
git commit -m "feat: add dockerfile"
git push