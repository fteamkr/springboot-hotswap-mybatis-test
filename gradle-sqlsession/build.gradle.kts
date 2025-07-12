plugins {
	java
	id("org.springframework.boot") version "3.3.13"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "hotswap.mybatis"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

sourceSets {
	// https://docs.gradle.org/current/dsl/org.gradle.api.tasks.SourceSet.html
	main {
		resources {
			// https://docs.gradle.org/current/dsl/org.gradle.api.tasks.SourceSet.html#org.gradle.api.tasks.SourceSet:resources
			srcDirs("src/main/java")
			include("**/*.properties", "**/*.xml")
		}
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.4")
	compileOnly("org.projectlombok:lombok")
	runtimeOnly("com.h2database:h2")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.mybatis.spring.boot:mybatis-spring-boot-starter-test:3.0.4")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
