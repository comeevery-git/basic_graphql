import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
	id("org.springframework.boot") version "2.6.3"
	id("io.spring.dependency-management") version "1.0.14.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	kotlin("plugin.jpa") version "1.6.21"
}

group = "com.wonderland"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	runtimeOnly("mysql:mysql-connector-java")

	implementation("org.springframework.boot:spring-boot-starter-data-jpa")

	implementation("com.graphql-java-kickstart:graphql-spring-boot-starter:6.0.1") //graphql
	runtimeOnly("com.graphql-java-kickstart:graphiql-spring-boot-starter:6.0.1")   //graphql

	testImplementation("org.springframework.boot:spring-boot-starter-test")

	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = true
jar.enabled = false

// submodule get private data
val copyPrivateData by tasks.registering(Copy::class) {
	from(file("./project_submodule_data/submodule-data/aws-rds-dev/application-dev.yml"))
	into(file("./src/main/resources"))
}

tasks.build<DefaultTask> {
	dependsOn(copyPrivateData)
}