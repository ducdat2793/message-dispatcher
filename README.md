# 🔐 Spring Boot Google SSO + Async Multithreading Demo

This project demonstrates the following using **Spring Boot**:

1. **Google Sign-In (SSO)** with `Spring Security` and `OAuth2 Client`.
2. **Asynchronous processing** with `@Async` and `ThreadPoolTaskExecutor`, with performance comparison using **JMeter**.

---

## 🚀 Technologies Used

- Java + Spring Boot
- Spring Security + OAuth2 Client (Google Login)
- ThreadPoolTaskExecutor + @Async
- Swagger UI
- JMeter (for load testing)
- Maven

---

## ✅ Features

| Feature                     | Description                                  |
|----------------------------|----------------------------------------------|
| ✅ Google SSO               | Login with Google account via OAuth2         |
| ✅ Asynchronous processing  | Async task handling using thread pool        |
| ✅ Swagger UI               | API testing via browser                      |
| ✅ Load testing with JMeter | Compare sync vs async performance            |

---

## 🔧 How to Configure Google OAuth2 Login

1. Go to [Google Cloud Console](https://console.cloud.google.com/apis/credentials).
2. Create a new project → Create **OAuth 2.0 Client ID**.
3. Application type: **Web Application**.
4. Add redirect URI:
http://localhost:8080/login/oauth2/code/google
5. Copy the generated `client-id` and `client-secret`.

6. Add them to your `application.properties`:

```properties
spring.security.oauth2.client.registration.google.client-id=YOUR_CLIENT_ID
spring.security.oauth2.client.registration.google.client-secret=YOUR_CLIENT_SECRET
```

## 🔓 Bypass OAuth2 for JMeter Testing
Project allow JMeter to send requests without login, Spring Security is permit access to specific endpoints. For example:
.antMatchers("/api/test-jmeter/**").permitAll()

## 🧱 Limit Tomcat's Thread Capacity to Simulate Load
Project simulate a limited server processing capacity (30 concurrent requests).
```
server.tomcat.threads.max=30
```

## 📘 Load Testing with JMeter
1. Download JMeter Binary version.
2. Create a Thread Group with the following settings:

- Number of Threads: 1000 (1000 match with final variable in Java, using for printing cost time of total request)

- Loop Count:	1

- Ramp-up Period:	1 second

3. Add a HTTP Request Sampler for testing:
POST http://localhost:8080/api/test-jmeter/async?content=Hello

POST http://localhost:8080/api/test-jmeter/sync?content=Hello

4. Use View Results Tree or Summary Report to view timing results.
5. 📊 Real Test Results (depen on machine)
API Endpoint | Requests |	Actual Processing Time	| JMeter Response Time
/api/test-jmeter/sync	1000	~34 seconds	~34 seconds
/api/test-jmeter/async	1000	~3 seconds	~5 seconds
| API Endpoint |  Requests | Actual Processing Time |
|------------|----------------|---------------------|-------------------------|
| /api/test-jmeter/sync | 1000 | ~34 seconds | ~34 seconds|
| /api/test-jmeter/async | 1000 | ~3 seconds | ~5 seconds|


## 🧪 Swagger UI
After logging in via Google, open Swagger:
http://localhost:8080/swagger-ui.html
Or
http://localhost:8080/webjars/swagger-ui/index.html

## 📎 Notes
Do NOT commit client-id or client-secret to GitHub.
This project is a simplified demo.





