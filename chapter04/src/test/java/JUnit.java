import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnit {
    @DisplayName("1+2는 3이다.")
    @Test
    public void junitTest() {
        // given
        int a = 1;
        int b = 2;

        // when
        int sum = 3;

        // then
        Assertions.assertEquals(sum, a + b);
    }

//    @DisplayName("1+3는 4이다.")
//    @Test
//    public void junitFailedTest() {
//        int a = 1;
//        int b = 3;
//
//        int sum = 3;
//
//        Assertions.assertEquals(sum, a + b);
//    }
}
/*
    @Display: 테스트 이름 명시
    @Test를 붙인 메소드는 테스트를 수행하기 위한 메소드가 됨
        JUnit은 테스트 끼리 영향을 주지 않도록 각 테스트를 실행할 때마다
        테스트를 위한 객체를 만들고, 테스트 종료 시점에 실행 객체를 소멸시킴

    .assertEquals() 메소드: 첫 번째 인수에는 기대하는 값, 두 번째 인수에는 실제로 검증할 값
 */
