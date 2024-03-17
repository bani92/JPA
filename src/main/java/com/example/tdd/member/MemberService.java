package com.example.tdd.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);


}
