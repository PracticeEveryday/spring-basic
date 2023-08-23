package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();
    @Test
    void join() {
        // given ~~ 환경일 때
        Member member = new Member(1L, "memberA", Grade.VIP);
        // when ~~ 게 주어졌을떄
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        // then ~~ 게 된다.
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}