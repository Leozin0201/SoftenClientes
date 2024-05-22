# Use a imagem oficial do OpenJDK como base
FROM openjdk:21-jdk-slim

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo JAR gerado para o diretório de trabalho
COPY build/libs/*.jar app.jar

# Expõe a porta em que a aplicação vai rodar
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]