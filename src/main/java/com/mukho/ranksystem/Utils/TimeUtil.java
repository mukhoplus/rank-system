package com.mukho.ranksystem.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {

    private static TimeUtil instance; // 정적 변수로 인스턴스를 저장합니다.

    // private 생성자를 사용하여 외부에서 인스턴스를 생성하는 것을 막습니다.
    private TimeUtil() {
    }

    // 인스턴스를 반환하는 정적 메서드를 제공합니다.
    public static synchronized TimeUtil getInstance() {
        if (instance == null) {
            instance = new TimeUtil();
        }
        return instance;
    }

    public String getLogTime(){
        return " ** " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "  ";
    }

}
