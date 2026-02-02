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