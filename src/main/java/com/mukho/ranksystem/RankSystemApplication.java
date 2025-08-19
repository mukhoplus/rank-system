package com.mukho.ranksystem;

import com.mukho.ranksystem.Utils.LogUtil;
import com.mukho.ranksystem.Utils.TimeUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import org.slf4j.Logger;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class RankSystemApplication {

	public static void main(String[] args) {
		TimeUtil logTime = TimeUtil.getInstance();
		Logger logger = LogUtil.getInstance();

		SpringApplication.run(RankSystemApplication.class, args);
		logger.info(logTime.getLogTime() + "서버가 실행되었습니다.");
	}

}

/* Use snapshot
./gradlew clean build -x test
java -jar build/libs/rank-system-2.1.0-SNAPSHOT.jar
 */
