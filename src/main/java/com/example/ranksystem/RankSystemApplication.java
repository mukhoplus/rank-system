package com.example.ranksystem;

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
java -jar build/libs/rank-system-1.3.0.-SNAPSHOT.jar
 */
