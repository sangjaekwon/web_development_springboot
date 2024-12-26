package me.kwonsangjae.springbootdeveloper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
    1. 테스트 코드 개념 익히기
        테스트 코드는 작성한 코드가 의도대로 잘 작동하고 예상치 못한 문제가 없는 지 확인할 목적으로 작성하는 코드.

        장점:
            1) 유지 보수 편리
            2) 코드 수정 시 걱정 x

        테스트 코드란?
            테스트 코드는 test 디렉토리에서 작업
            테스트 코드에는 다양한 패턴이 있는데, given-when-then 사용할 예정
                1) given: 테스트 실행 준비 단계
                2) when: 테스트 진행 단계
                3) then: 테스트 결과 검증 단계

            ex) 새로운 메뉴를 저장하는 코드를 테스트한다고 가정했을 때의 테스트 코드

                @Display("새로운 메뉴를 저장한다")
                @Test
                public void savedMenuTest() {
                    // 1. given
                    final String name = "아메리카노"
                    final int price = 2000;
                    final Menu americano = new Menu(name, price);

                    // 2. when
                    final long savedId = menuService.save(americano)

                    // 3. then
                    final Menu savedMenu = menuService.findByID(savedId).get();
                    assertThat(savedMenu.getName()).iseEqualTo(name);
                    assertThat(savedMenu.getPrice()).isEqualTo(price);
    2. 스프링 부트 3와 테스트
        스프링 부트는 애플리케이션을 테스트하기 위한 도구와 애너테이션을 제공
        spring-boot-starter-test 스타터에 테스트를 위한 도구가 모여있음.

        스프링 부트 스타터 테스트 많이 사용되는 목록
            1) JUnit: 자바 프로그래밍 언어용 단위 테스트 프레임워크
            2) AssertJ: 검증문인 assertion을 작성하는 데 사용하는 라이브러리

            JUnit이란?
                자바 언어를 위한 단위 테스트 프레임워크
                    단위 테스트: 작성한 코드가 의도대로 작동하는지 작은 단위로 검증함을 의미
                        보통 그 단위는 메소드 기준
                JUnit을 사용하면 단위 테스트의 결과가 직관적으로 나오는 편

                특징:
                    1) 테스트 방식을 구분할 수 있는 애너테이션 제공
                    2) @Test 애너테이션으로 메소드를 호출할 때 마다 새 인스턴스를 생성,
                        독립테스트가 가능
                    3) 예상 결과를 검증하는 assertion 메소드 제공
                    4) 사용 방법 단순, 테스트 코드 작성 시간 적음
                    5) 자동 실행, 자체 결과 확인 실패한 지점 보여줌

    AssertJ로 검증문 가독성 높이기

        AssertJ는 JUnit과 함께 사용해 검증문의 가독성르 높여주는 라이브러리
        예를 들어 아까 작성한(JUnitTest.Java에서)
        Assertions.assertEquals(sum, a+b);를 보면 기대값 비교값 구분이 잘 안됨

        AssertJ를 사용한 코드 라인
        assertThat(a+b).isEqualTo(sum);
        로 사용

        자주 사용하는 메소드 목록
        1) isEqualTo(A): A와 같은지 검증
        2) isNotEqualTo(A): A와 다른지 검증
        3) contains(A): A를 포함하는지 검증
        4) doesNotContain(A): A를 포함하지 않는지 검증
        5) startsWith(A): 접두사가 A인지 검증
        6) endsWith(A): 접미사가 A인지 검증
        7) isEmpty(): 비어있는 값인지 검증
        8) isNotEmpty(): 비어 있지 않은 값은지 검증
        9) isPositive(): 양수인지 검증
        10) isNegative(): 음수인지 검증
        11) isGreaterThan(1): 1보다 큰 값인지 검증
        12) isLessThan(1): 1보다 작은 값인지 검증
        13) isNotNUll(): Null이 아닌지 검증
        14) isNull(): Null인지 검증
 */
@SpringBootApplication
public class SpringBootDeveloperApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDeveloperApplication.class, args);

    }
}