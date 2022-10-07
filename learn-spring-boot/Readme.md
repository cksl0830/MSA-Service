### 스프링부트 (자바17 / SpringBoot 3.0.0)

- What  
웹서비스는 애플리케이션간에 상호작용을 지원해야한다   

> a- java    
> b- php     이 있을 때 하나의 서비스와 **네트워크**를 통해 모두 통신된다면 이것을 “**웹서비스**” 라고 할 수 있음     
> c- dotnet        
즉 , 각 플랫폼이 독립적이어야함 !     

- How
웹서비스의 요청 및 응답의 형식 2가지 → 요청 / 응답 구조 설정 → 서비스 호출 방법 

1. XML 
2. JSON

- Rest     
요청과 응답의 형식이 무엇인지 - - HTTP 형식     
restful 을 정의하기 위해 **swagger** 사용 !      

------


1. 빠르게!! 
 - Starter Projects : pom.xml 에 다 자동으로 종속되어있는 설정들을 말한다     
ex) web 에 모든 설정들 내재되어있음    
 - Auto Configuration : 디스페처 서블릿,톰캣,json변환 (http message converter) 등 ,, 자동구성      
ex) url 매핑 잘못했을때 whitelabel 페이지 그것도 다 자동으로 되게끔 설정해놓은것!     
 - Devtools : 개발자의 생산성을 높임 (자동으로 서버 재시작)     

2. 프로덕션 준비 기능
- 로깅     
- 모니터링    

** 참고 
스프링에서 요청이 들어오면 url에 관계없이 먼저 디스패처 서블릿으로 간다 → 그리고 나서 올바른 url에 매핑한다     
JSON 변환 부분은 **http메시지 컨버터 + @Responsebody**    
error → 스프링부트의 자동구성에 의해 나타남     
