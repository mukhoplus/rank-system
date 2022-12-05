package com.example.ranksystem.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeService {

    public String getLogTime(){
        return " ** " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + "  ";
    }

}
