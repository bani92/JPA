//package com.example.tdd.Test;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import static org.assertj.core.api.Assertions.as;
//import static org.assertj.core.api.Assertions.assertThat;
//
//@DataJpaTest
//public class MembershipRepositoryTest {
//
//    @Autowired
//    private MembershipRepository membershipRepository;
//
//
//    @DisplayName("NotNull 테스트")
//    @Test
//    public void MembershipRepositoryIsNotNull() {
//        assertThat(membershipRepository).isNotNull();
//    }
//
//    @DisplayName("멤버십 등록")
//    @Test
//    public void 멤버십등록() {
//
//        // given
//        final Membership membership = Membership.builder()
//                .userId("userId")
//                .membershipType(MembershipType.NAVER)
//                .point(10000)
//                .build();
//
//        // when
//        final Membership result = membershipRepository.save(membership);
//
//        // then
//        assertThat(result.getId()).isNotNull();
//        assertThat(result.getUserId()).isEqualTo("userId");
//        assertThat(result.getMembershipType()).isEqualTo(MembershipType.NAVER);
//        assertThat(result.getPoint()).isEqualTo(10000);
//    }
//
//    @DisplayName("멤버십이존재하는지테스트")
//    @Test
//    public void 멤버십이존재하는지테스트() {
//        //given
//        final Membership membership = Membership.builder()
//                .userId("userId")
//                .membershipType(MembershipType.NAVER)
//                .point(10000)
//                .build();
//
//        // when
//        membershipRepository.save(membership);
//        Membership findResult = membershipRepository.findByUserIdAndMembershipType("userId", MembershipType.NAVER);
//
//        // then
//        assertThat(findResult).isNotNull();
//        assertThat(findResult.getId()).isNotNull();
//        assertThat(findResult.getUserId()).isEqualTo("userId");
//        assertThat(findResult.getMembershipType()).isEqualTo(MembershipType.NAVER);
//        assertThat(findResult.getPoint()).isEqualTo(10000);
//
//        // [ Service 계층 개발 ]
//    }
//}
