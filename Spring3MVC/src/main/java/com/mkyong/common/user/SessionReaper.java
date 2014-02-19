package com.mkyong.common.user;

import com.mkyong.common.config.ApplicationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @version 1.0
 * @author: Iain Porter iain.porter@porterhead.com
 * @since 11/01/2013
 */
public class SessionReaper {

//    Logger LOG = LoggerFactory.getLogger(SessionReaper.class);

//    private UserService userService;

    ApplicationConfig config;

    public void cleanUpExpiredSessions() {
//        Integer sessionCount = userService.deleteExpiredSessions(config.getSessionExpiryTimeInMinutes());
        System.out.println("Session reaper has removed {} expired sessions");
    }

    @Autowired
    public void setConfig(ApplicationConfig config) {
        this.config = config;
    }

//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
}
