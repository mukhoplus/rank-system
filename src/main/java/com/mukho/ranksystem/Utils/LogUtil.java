package com.mukho.ranksystem.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {
    private static final Logger logger = LoggerFactory.getLogger(LogUtil.class);

    public static Logger getInstance() {
        return logger;
    }

}
