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
## **Entity**
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