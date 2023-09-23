package com.mukho.ranksystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RankSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RankSystemApplication.class, args);
	}

}

/* Use snapshot
./gradlew build
java -jar build/libs/rank-system-2.0.0-SNAPSHOT.jar
 */
