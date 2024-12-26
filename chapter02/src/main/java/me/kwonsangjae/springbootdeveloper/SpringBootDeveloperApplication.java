package me.kwonsangjae.kwonsangjae.springbootdeveloper;

/*
    New proejct 생성시 주의점:
        1. build system -> Gradle 설정
        2. DLS -> Groovy 설정
        3. name = ArtifactId
        4. build.gradle 설정을 복사하는데, 복사 후에 -> sync를 눌러줘야함
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
    1. Spring vs SpringBoot

        EnterPrise Application: 대규모의 복잡한 데이터를 관리하는 애플리케이션
        많은 사용자의 요청을 동시에 처리해야 하므로 서버 성능과 안정성, 보안 이슈 등
        모든 걸 신경쓰면서 사이트 기능, 즉 '비즈니스 로직'을 개발하기가 매우 어려워서
        등장하게 된 것이 Spring

    SpringBoot의 등장
        스프링은 매우 많은 장점을 지니고 있지만 설정이 복잡하다는 단점이 있음.
        이런 단점을 보완하고자 등장한 것이 스프링 부트

    특징:
        1) 톰캣, 제티, 언더토우 같은 웹 애플리케이션 서버가 내장돼있어 따로 설치하지 않아도 독립적으로 실행 가능
        2) 빌드 구성을 단순화하는 스프링 부트 스타터를 제공
        3) XML 설정을 하지 않고 자바 코드로 작성 가능
        4) JAR을 이용해서 자바 옵션만으로 배포 가능
        5) 애플리케이션 모니터링 및 관리 도구인 스프링 액츄에이터 제공

    즉, 스프링부트라는 것은 기본적으로 스프링에 속해있는 도구

    차이점:
        1) 구성의 차이 -> 스프링은 애플리케이션 개발에 필요한 환경을 수동으로 구성하고 정의
            하지만 스프링부트는 스프링 코어와 스프링 MVC의 모든 기능을 자동으로 로드
            수동으로 개발 환경을 구성할 필요가 없음
        2) 내장 WAS 유무 -> 스프링 애플리케이션은 일반적으로 톰캣과 같은 WAS에서 배포
            WAS: Web Application Server의 약자
            하지만 스프링 부트는 자체적으로 WAS를 가지고 있어 JAR 파일만 만들면 별도로 WAS 설정을
            하지 않아도 애플리케이션을 실행할 수 있음

    2. 스프링 컨셉
        1) 제어의 역전(IoC)
            Inversion of Control: 다른 객체를 직접 생성하거나 제어하는 것이 아니라
                외부에서 관리하는 객체를 가져와 사용하는 것을 의미함.
                ex) 클래스 A에서 클래스 B의 객체를 생성
                public class A {
                    B b = new B();
                }
                위와는 다르게 어딘가에서 받아와 사용
                ex) 스프링 컨테이너가 객체를 관리하는 방식의 자바 코드
                public class A {
                    private B b;
                }
        2) 의존성 주입(DI)
            Dependency Injection: 어떤 클래스가 다른 클래스에 의존한다는 의미

            @Autowired 중요 -> 스프링 컨테이너에 있는 빈(Bean)을 주입하는 역할
            Bean: 스프링 컨테이너가 관리하는 객체

            ex) 객체를 주입 받는 모습 예제
            public class A {
                @AutoWired
                B b;
            }
        3) 빈과 스프링 컨테이너
            스프링 컨테이너: 빈이 생성되고 소멸되기 까지의 생명주기를 관리함
                또한 @Autowired를 사용해 빈을 주입받을 수 있게 DI를 지원함
            빈: 스프링 컨테이너가 생성하고 관리하는 객체 -> 이상의 코드들에서 B가 빈에 해당
                스프링은 빈을 스프링 컨테이너에 등록하기 위해 XML 파일 설정, 애너테이션 추가 등의 방법을
                제공하는데, 이것이 의마하는 바는
                    1. 빈을 등록하는 방법은 여러가지이다.
                    2. 수업 중 우리가 사용하는 방식은 애너테이션이다.
                ex) 클래스를 빈으로 등록하는 방법 예제
                @Component
                public class MyBean{}

                    이상과 같이 @Component를 붙이면 MyBean 클래스가 빈으로 동록됨
                    이후 스프링 컨테이너에서 이 클래스를 관리하게 되고, 빈의 이름은 첫 문자를
                    소문자로 바꾸어서 관리함. 즉 클래스 MyBean의 빈 이름은 myBean이 됨

                    일반적으로는 스프링이 제공해주는 객체로 받아들이면 됨
        4) 관점 지향 프로그래밍(AOP)
            Aspect-oriented Programming: 프로그래밍에 대한 관심을 핵심 관점 / 부가 관점으로
                나누어 모듈화함을 의미

                ex) 계좌 이체, 고객 관리하는 프로그램이 있다고 가정할 때, 각 프로그램에는
                로깅 조직, 즉 지금까지 일어난 일을 기록하기 위한 로직과
                여러 데이터를 관리하기 위한 데이터베이스 연결 로직이 포함됨 이 때,
                    핵심 관점 - 계좌 이체, 고개 관리 로직
                    부가 관점 - 로깅, 데이터 베이스 연결 로직

        5) 이식 가능한 서비스 추상화(PSA)
            Portable Service Abstraction: 스프링에서 제공하는 다양한 기술들을 '추상화'해
                개발자가 쉽게 사용하는 '인터페이스'
                
                ex) 클라이언트의 매핑 / 클래스, 메소드의 매핑을 위한 애너테이션들
                스프링에서 데이터베이스에 접근하기 위한 기술로 JPA, MyBatis, JDBC emd
                어떤 기술을 사용하든 일관된 방식으로 데이터베이스에 접근하도록 인터페이스를 지원
                WAS 역시 PSA의 예시 중 하나로, 어떤 서버를 사용하더라도(톰캣, 언더토우, 네티 등)
                코드를 동일하게 작성 가능
                
3. 스프링 부트 3 둘러보기
    첫 번째 스프링 부트 3 예제 만들기
        01 단계 -
            springbootdeveloper 패키지에
            TestCo



 */
@SpringBootApplication
public class SpringBootDeveloperApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDeveloperApplication.class, args);

    }
}