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
}
