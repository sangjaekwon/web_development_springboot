import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JUnitQuiz {
    /*
        문제 01
        String으로 선언한 세 변수가 모두 null이 아니며 name1과 name2는 같은 값을 가지고,
        name3은 다른 값을 가지는 것을 검증하는 테스트 작성
     */
    @Test
    public void junitTest1() {
        String name1 = "아아";
        String name2 = "아아";
        String name3 = "아에";

        assertThat(name1).isNotNull();
        assertThat(name2).isNotNull();
        assertThat(name3).isNotNull();
        assertThat(name1).isEqualTo(name2);
        assertThat(name1).isNotEqualTo(name3);
    }

    @Test
    public void junitTest2() {
        /*
            문제 02
                int로 선언된 세 변수가 각각 양수, 0, 음수 이고 num1은 num2보다 큰 값이고,
                num3은 num2보다 작은 값임을 검증
         */
        int num1 = 15;
        int num2 = 0;
        int num3 = -5;

        assertThat(num1).isPositive();
        assertThat(num2).isZero();
        assertThat(num3).isNegative();

        assertThat(num1).isGreaterThan(num2);
        assertThat(num3).isLessThan(num2);

    }
}
