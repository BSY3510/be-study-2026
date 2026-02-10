# week1
- Stream
  - .filter(): if문 대체
  - .map(): 데이터 변환
  - .forEach(): for문 대체
  - .orElseThrow(): 없으면 예외를 던짐
- 람다식
  - 입력 -> 출력
  - ex. s -> s.getScore()
- 메서드 참조
  - ex. Student::getName()

# week2
## **Controller**
- @RestController: 웹 요청을 받는 것임을 알림
- @SpringBootApplication: 패키지의 내용을 보고 인식
- @RequestParam: 주소창을 통해 변수로 값을 가져옴
- Jackson 라이브러리: 객체를 반환하면 JSON으로 변환
## **Domain**
- @Getter: 모든 필드의 Getter 자동 생성
- @AllArgsConstructor: 모든 필드를 입력받는 생성자 자동 생성
## **Service**
- @Service
- @RequiredArgsConstructor: 의존성 주입, final이 붙은 필드를 자동으로 채움
## **Exception**
- @RestControllerAdvice: 컨트롤러의 예외를 감시
- @ExceptionHandler: 특정 예외에 대한 처리 담당
- ResponseEntity: HTTP 상태 코드를 정밀하게 제어
## **HTTP**
- HTTP Method GET과 POST 차이
  - 멱등성, GET은 서버의 상태가 변하지 않지만 POST는 서버에 데이터가 생길 수 있다.
- HTTP Status Code 401과 403 차이
  - 비인가된 것인지 권한의 문제인지의 차이
  - 로그인 실패는 비인가된 사용자이고, 일반 사용자가 관리자 권한에 접근하는 것은 권한 문제
- Stateless
  - Cookie & Session
## **Raw Socket Web Server**
- Spring Boot를 사용하면 Tomcat으로 가능하지만 ServerSocket을 이용
- 메시지 구성: 상태, 헤더, 빈 줄, 바디
- .flush(): 메시지 전송

# week3
## **JPA**
- Java Persistence API
- 직접 SQL문을 작성하는 것이 아닌 JPA가 SQL문을 만들어 DB로 보냄(ORM기술)
- application.properties 파일에 DB와의 연결 고리 설정
  - DB url, username, password 등 설정
  - ddl-auto: create(실행 시 기존 테이블 지우고 새로 생성), update(데이터 유지하고 변경된 스키마만 반영)
 
## **Entity**
- @Entity 어노테이션을 통해 클래스를 JPA가 관리하는 Entity가 되고, DB 테이블과 매핑되는 대상으로 등록
- @NoArgsConstructor: JPA 엔티티는 기본 생성자가 필수
- @Id: Primary Key 설정
- @Column: DB 컬럼 설정

## **Repository**
- JpaRepository를 상속받는 인터페이스를 생성
- 쿼리 메소드: 메소드 이름을 규칙에 맞게 작성하면 JPA가 이에 맞춰서 SQL문을 작성
  - 규칙: findBy + 필드명
  - 데이터가 없을 수 있으므로 Optional 사용

## **Security**
1. 외부 설정 파일 이용: 별도의 파일을 만들어 관리
2. 환경 변수 활용: 코드에는 변수명만 사용, 실제값은 운영체제 또는 IDE 설정에 저장
3. Spring Profiles 활용: 개발용과 운영용 설정 분리

## **RDBMS**
- PK와 FK
  - 기본키(PK, Primary Key): Unique하고, Not Null하며 행을 특정함
  - 외래키(FK, Foreign Key): 테이블 간의 통로 역할, 참조 무결성을 지킴
- 정규화: 이상 현상(Anomalies) 방지
  - 정규화 Trade-off: 정규화를 많이하면 테이블이 잘게 쪼개지기에 데이터를 가져올 때 여러 테이블을 합치는 JOIN 연산이 많아져 Read 성능이 낮아짐
- 트랜잭션
  - ACID
  - Atomicity: 원자성, 트랜잭션 전체가 성공하거나 완전 실패
  - Consistency: 일관성, 트랜잭션 전후의 데이터 상태가 규칙에 맞아야 함
  - Isolation: 격리성, 서로 간섭되면 안됨
  - Durability: 지속성, 성공한 트랜잭션은 저장되어야 함
- 인덱스: (장점) Read 속도 빨라짐, (단점) 인덱스 업데이트로 Write 속도 느려짐
- 스키마(Schema) 설계
  - 타입: BIGINT, VARCHAR, TIMESTAMP, TEXT 등
  - 자동 증가: AUTO_INCREMENT
  - 중복 방지: UNIQUE, UNIQUE KEY 키명 (컬럼1, 컬럼2, ...)
  - 외래키 설정: FOREIGN KEY (컬럼명) REFERENCES 테이블명(컬럼명)

# week4
## CRUD API
- 데이터 처리의 기본 동작: Create, Read, Update, Delete

## @Transactional
- 작업 중 에러가 발생하면, 아예 없던 일로 되돌리는(Rollback) 안전장치

## Dirty Checking
- JPA가 트랜잭션이 끝나는 순간, 처음 조회했을 때와 Entity의 값이 달라짐(Dirty)을 감지하고 쿼리를 날림.

## 자료구조
- ArrayList vs LinkedList
  - ArrayList: 메모리에 순서대로 저장
  - LinkedList: 링크를 통해 접근하기에 메모리에 산재됨
  - 값 삽입은 LinkedList가 빠르지만 링크를 타고 가기에 접근까지의 시간이 소요됨
- HashMap
  - 해시함수를 활용하여 키-값 쌍을 저장/조회하는 자료구조
  - 해시 충돌: 서로 다른 키들이 같은 해시값을 가질 때 발생
- Stack vs Queue
  - Stack: Last In First Out(ex. 브라우저의 뒤로 가기)
  - Queue: First In First Out(ex. 선착순 대기열)

# week5
## 인증(Authentication)
- ex. 신분증 확인, 로그인 과정

## 인가(Authorization)
- ex. 출입증 확인, 관리자 권한 확인

## Spring Security
- ```implementation 'org.springframework.boot:spring-boot-starter-security'```
- SecurityConfig
  - @Configuration(설정 파일), @EnableWebSecurity(기능 활성화)
  - CSRF: Cross-Site Request Forgery, 교차 사이트 요청 위조, 로그인된 사용자의 권한을 훔쳐, 사용자가 원치 않는 악의적인 요청을 특정 웹사이트에 보내게 만드는 공격 기법

## PasswordEncoder
- DB에 비밀번호를 그대로 저장하지 않고 암호화하여 저장하기 위해 사용

## IoC(Inversion of Control, 제어의 역전)
- 인터페이스만 보고 코딩하면, 프레임워크가 상황에 맞게 부품들을 갈아끼워 줄 수 있다.

## DI(Dependency Injection, 의존성 주입)
- 불변성과 누락 방지를 위해 생성자 주입을 이용
  - final 키워드 사용으로 객체 생성 후 의존성이 바뀔 위험이 없다.
  - 컴파일 시점에 의존성 누락을 잡아낼 수 있다.

## Spring Bean
- @Service: 비즈니스 로직이 들어있음을 명시
- @Repository: DB 접근 로직임을 명시
- @Controller: 웹 요청을 받는 창구임을 명시
- => 모두 @Component의 특수 형태

## @Primary vs @Qualifier
- @Primary: 해당 구현체를 기본으로 사용 명시
- @Qualifier("이름"): 특정 이름의 부품을 사용 명시
