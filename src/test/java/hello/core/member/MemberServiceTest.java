package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

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