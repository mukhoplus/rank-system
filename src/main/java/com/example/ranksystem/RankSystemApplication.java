package com.example.ranksystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class RankSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RankSystemApplication.class, args);
	}

}

/* Use snapshot
./gradlew build
java -jar build/libs/rank-system-0.2.1-SNAPSHOT.jar
 */
