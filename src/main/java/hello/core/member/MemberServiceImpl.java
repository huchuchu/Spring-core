package hello.core.member;

public class MemberServiceImpl  implements MemberService{

    // 구현체 없이 인터페이스만 있으면 널포인트 터짐. 구현객체 선택해줘야함
    // 문제점!! MemberServiceImpl은 추상화와 구현체 모두에게 의존한고있다.-> DIP위반
    // 추상화에만 의존. AppConfig에서 구현체를 넣어줌 ==> 생성자주입
    private final MemberRepository memberRepository ;

    // 생성자를 통해서 MemberRepository의 구현체가 어떤것이될지 선택
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
