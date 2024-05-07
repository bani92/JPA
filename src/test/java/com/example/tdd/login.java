package com.example.tdd;


import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class login {

    @Test
    @DisplayName("존재하는 회원의 account로 로그인시 로그인을 성공하여 로그를 남긴다.")
    void login() {
        // given
        final ListAppender<ILoggingEvent> appender = new ListAppender<>();
        final Logger logger = LoggerFactory.getLogger(LoginHandler.class);

        // when

        // then

    }
}
