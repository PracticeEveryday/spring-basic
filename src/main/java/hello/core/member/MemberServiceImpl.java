package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // 추상화에도 의존하고 구현체에도 의존하고 있다.. 문제임!
//    private final MemberRepository memberRepository


    private MemberRepository memberRepository;

    // 생성자를 통해 구현체를 넣어준다. -> 이떄 들어오는 값은 AppConfig에 들어있는 주입된 값디 들어온다!!
    // 이제 추상화에만 의존한다!! DIP성공! OCP성공!
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
