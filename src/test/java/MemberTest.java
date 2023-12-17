import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.time.LocalDate;
import org.example.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemberTest {

    @Test
    @DisplayName("회원 생성")
    void createMember() {
        Member m = new Member(1, "홍길동", 3);
        assertThat(m.toString()).contains("===\n"
                                                  + "회원 아이디 : 1\n"
                                                  + "회원 이름 : 홍길동\n"
                                                  + "가입일 : " + LocalDate.now() + "\n"
                                                  + "구매 횟수 : 3\n"
                                                  + "누적 포인트 점수 : 90\n"
                                                  + "회원 등급 : FAMILY");
    }

    @Test
    @DisplayName("이달의 최고회원 확인")
    void checkBestMember() {
        Member m1 = new Member(1, "홍길동", 4);
        Member m2 = new Member(2, "홍길순", 10);

        assertThat(Member.getBestMember()).isEqualTo(m2);
    }

    @Test
    @DisplayName("환불 후 회원 유효성 검사")
    void validateMemberByAfterRefund() {
        Member m1 = new Member(1, "홍길동", 6);

        assertThat(m1.toString()).contains("===\n"
                                                   + "회원 아이디 : 1\n"
                                                   + "회원 이름 : 홍길동\n"
                                                   + "가입일 : " + LocalDate.now() + "\n"
                                                   + "구매 횟수 : 6\n"
                                                   + "누적 포인트 점수 : 300\n"
                                                   + "회원 등급 : VIP");

        m1.refund();

        assertThat(m1.toString()).contains("===\n"
                                                   + "회원 아이디 : 1\n"
                                                   + "회원 이름 : 홍길동\n"
                                                   + "가입일 : " + LocalDate.now() + "\n"
                                                   + "구매 횟수 : 5\n"
                                                   + "누적 포인트 점수 : 250\n"
                                                   + "회원 등급 : GOLD");
    }

    @Test
    @DisplayName("구매 후 회원 유효성 검사")
    void validateMemberByAfterBuy() {
        Member m1 = new Member(1, "홍길동", 5);

        assertThat(m1.toString()).contains("===\n"
                                                   + "회원 아이디 : 1\n"
                                                   + "회원 이름 : 홍길동\n"
                                                   + "가입일 : " + LocalDate.now() + "\n"
                                                   + "구매 횟수 : 5\n"
                                                   + "누적 포인트 점수 : 250\n"
                                                   + "회원 등급 : GOLD");

        m1.buy();

        assertThat(m1.toString()).contains("===\n"
                                                   + "회원 아이디 : 1\n"
                                                   + "회원 이름 : 홍길동\n"
                                                   + "가입일 : " + LocalDate.now() + "\n"
                                                   + "구매 횟수 : 6\n"
                                                   + "누적 포인트 점수 : 300\n"
                                                   + "회원 등급 : VIP");
    }

    @Test
    @DisplayName("이달의 최고 회원 누적 포인트 합계 정상증가")
    void sumPointByBestMember() {
        Member m1 = new Member(1, "홍길동", 2);
        Member m2 = new Member(2, "홍길순", 9);

        assertThat(Member.getBestMember().toString()).contains("===\n"
                                                                       + "회원 아이디 : 2\n"
                                                                       + "회원 이름 : 홍길순\n"
                                                                       + "가입일 : " + LocalDate.now() + "\n"
                                                                       + "구매 횟수 : 9\n"
                                                                       + "누적 포인트 점수 : 10450\n"
                                                                       + "회원 등급 : VVIP");
        m2.buy();

        assertThat(m2.toString()).contains("===\n"
                                                   + "회원 아이디 : 2\n"
                                                   + "회원 이름 : 홍길순\n"
                                                   + "가입일 : " + LocalDate.now() + "\n"
                                                   + "구매 횟수 : 10\n"
                                                   + "누적 포인트 점수 : 11000\n"
                                                   + "회원 등급 : VVIP");

    }
}
