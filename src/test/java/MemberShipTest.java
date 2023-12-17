import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.example.MemberShip;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemberShipTest {

    @Test
    @DisplayName("회원 등급 테스트")
    void checkMemberShip() {
        MemberShip memberShip = new MemberShip(500);

        assertThat(memberShip.getMemberShip()).isEqualTo("VVIP");
    }
}
