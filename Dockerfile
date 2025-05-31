# 1. Chọn image gốc là OpenJDK (JDK 17)
FROM openjdk:17-jdk-slim

# 2. Copy file JAR từ máy host vào trong image
COPY target/message-dispatcher-0.0.1-SNAPSHOT.jar app.jar

# 3. Lệnh chạy ứng dụng khi container khởi động
ENTRYPOINT ["java", "-jar", "app.jar"]