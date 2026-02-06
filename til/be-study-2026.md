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