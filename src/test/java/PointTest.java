import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.example.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointTest {

    @Test
    @DisplayName("누적 포인트 합계 테스트")
    void sumByPoint() {
        Point point = new Point(4);

        assertThat(point.getPoint()).isEqualTo(120);
    }

    @Test
    @DisplayName("구매 후 누적 포인트 합계 테스트")
    void afterBuyByPoint() {
        Point point = new Point(4);
        point.increaseBuyCnt();

        assertThat(point.getPoint()).isEqualTo(150);
    }

    @Test
    @DisplayName("환불 후 누적 포인트 합계 테스트")
    void afterRefundByPoint() {
        Point point = new Point(4);
        point.decreaseBuyCnt();

        assertThat(point.getPoint()).isEqualTo(90);
    }
}
