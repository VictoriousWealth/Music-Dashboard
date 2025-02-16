plugins {
	java
	id("org.springframework.boot") version "3.3.8"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.8.0"
	kotlin("plugin.spring") version "1.8.0"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion.set(JavaLanguageVersion.of(17)) // Use Java 17
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// ✅ Core Spring Boot Starters
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web") // Web API
	implementation("org.springframework.boot:spring-boot-starter-security") // Security & JWT

	// ✅ GraphQL dependencies (Use Spring Boot GraphQL instead of graphql-java-tools)
	implementation("org.springframework.boot:spring-boot-starter-graphql")
	implementation("com.graphql-java:graphql-java-extended-scalars:21.0") // Supports custom scalars

	implementation("org.springframework.boot:spring-boot-starter-oauth2-client") // OAuth2 Login
	implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server") // JWT Auth
	implementation("org.springframework.boot:spring-boot-starter-oauth2-authorization-server") // OAuth2 Server

	// ✅ Database & ORM
	implementation("org.springframework.boot:spring-boot-starter-data-jpa") // PostgreSQL ORM
	runtimeOnly("org.postgresql:postgresql") // PostgreSQL Driver
	runtimeOnly("com.h2database:h2") // H2 for Local Testing (Optional)
	implementation("org.flywaydb:flyway-core") // Database Migrations

	// ✅ Event-Driven Messaging
	implementation("org.springframework.kafka:spring-kafka") // Kafka for real-time logs

	// ✅ Monitoring & Developer Tools
	implementation("org.springframework.boot:spring-boot-starter-actuator") // Monitoring & Health Checks
	"developmentOnly"("org.springframework.boot:spring-boot-devtools") // Hot Reload

	// ✅ Caching & Performance
	implementation("org.springframework.boot:spring-boot-starter-cache")

	// ✅ Code Quality & Testing
	implementation("org.projectlombok:lombok") // Reduces Boilerplate Code
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

}

tasks.withType<Test> {
	useJUnitPlatform()
}
