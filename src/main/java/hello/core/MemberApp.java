package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        // 직접 main method에서 생성하지 않고
        // MemberService memberService = new MemberServiceImpl();

        // 이제는 appConfig에서 memberService를 꺼내야 한다!
        MemberService memberService = appConfig.memberService();



        // 1L -> Long Type의 1이라는 뜻 just 1은 오류임
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("member = " + member);
        System.out.println("findMember = " + findMember);
    }
}
