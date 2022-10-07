1. #### CustomizedResponseEntityExceptionHandler 클래스

@ContrpllerAdvice : 전역에서 발생할 예외를 처리할수 있게 한다. 모든 컨트롤러가 실행될 때 이 클래스가 실행 될 것이다.     
@ExceptionHandler : @Controller와 @RestController이 적용된 Bean 내에서 발생하는예외를 처리하는 메소드 기능을 하게 해준다.     
handleAllExceptions의 매개변수로 에러난 객체를 ex, 에러 리퀘스트를 request로 받아오도록 선언하였다.      

그리고 각 에러에 대한 객체를 만들고 날짜, 에러난 객체, 요청에 대한 상세정보를 리턴하도록 구성하였다.      


2. #### API 버전 관리
- 주의해야할 점     
  - URI에 정보를 노출시키지 말아야 함     
  - 잘못된 헤더값 지양   
  - 웹에서 실행이 가능해야함   
  - API의 정확한 문서를 제공하는 것이 좋음   
