package com.example.tdd.Test;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MembershipErrorResult {

    DUPLICATED_MEMBERSHIP_REGISTER(HttpStatus.BAD_REQUEST, "Duplicated Membership Register Request"),
    ;

    private final HttpStatus httpStatus;
    private final String message;

    /**
     * MembershipException이 throw 되었을 때 RestControllerAdvice를 통해 MembershipErrorResult의 HttpStatus와 message를 반환하기 위함
     */
}
