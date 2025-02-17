![image](https://github.com/user-attachments/assets/54e40ecc-40ea-4edf-aef8-75698d374b31)
![image](https://github.com/user-attachments/assets/bbfbbdc1-b582-44c3-a67e-9afd89e7adbe)

# 디자인 패턴
![image](https://github.com/user-attachments/assets/914d854e-3b3b-48e1-953e-ff400aee3a70)

## 1.생성 패턴(객체 생성과 관련된 패턴으로 객체 생성의 복잡성을 숨기고, 객체생성과정을 캡슐화하여 코드의 유연성과 재사용성을 높인다.)  
- 싱글톤 패턴, 프로토타입 패턴, 빌더 패턴, 팩토리 메서드 패턴(단일객체),추상 팩토리(여러객체) 패턴
- instance => 추상화공장팩토리( 추상화 공장에서 키보드 마우스를 만든다. LG,Samsung회사의 공장에 추상화 공장을 상속해서 키보드 마우스를 만든다. 이렇게 해서 객체의 생성의 확장에 편리하게 객체 설계를 한다.)
  
## 2.구조 패턴(클래스와 객체를 조합하여 더 큰 구조를 만들고, 객체간의 관계를 정의하고 구조를 단순화한다.)
- Adapter(변환) =>어댑터 패턴 (Adapter Pattern -호환되지 않는 인터페이스를 가진 클래스들을 함께 동작[레거시 코드와 새로운 코드 통합] )
  (Print 인터페이스와 Banner 상속을 통해 PrintBanner 클래스에서 인터페이스 다형성을 활용한 변환 구현한다. 이렇게 해서 Print와 Banner의 확장과 변환에 유연하게 설계하고 <b>변환 책임<b>을 PrintBanner에 둔다.)<br>
- Equate(유사패턴)  => 컴포지트 패턴 (Composite Pattern -객체를 트리 구조로 구성하여 부분-전체 계층을 표현[파일 시스템, GUI 구성 요소]) <br>
                     ( 상품, 카테고리의 객체를 각각 상품카테고리 객체의 추상화 메소드 활용해서 구성한다. <b>객체의 확장에 유연하게 설계한다.<b>)<br>
                   => 데코레이터 패턴 (Decorator Pattern- 객체에 추가적인 기능을 동적으로 추가합니다.[스트림 처리 (버퍼링, 암호화)])<br>
                   ( 커피를 추상화하고 커피 종류와(케냐,에티오피아) 데코레이터 객체에 상속한다. 데코레이터객체는 라테,모카,휘핑크림에 상속한다. <br>
                      ,데코레이터를 통해 새로운 기능을 동적으로 추가 활용 가능하다.(커피 종류추가 및 커피데코레이터 추가한다. 이것은 객체 안에 객체를(데코레이터 조합) 계속 생성하는 형태로 나타난다.<br>
                      <b>객체의 장식을 유연하게 다변화 하게 설계한다.<b>
- 브리지 패턴 (Bridge Pattern) : 구현부에서 추상층을 분리하여, 둘이 독립적으로 다형성 있게 변형될 수 있도록 한다.(다양한 데이터베이스 드라이버 지원)
- 퍼사드 패턴 (Facade Pattern) : 복잡한 서브시스템에 대한 단순화된 인터페이스를 제공(라이브러리 초기화 및 설정) 
- 플라이웨이트 패턴 (Flyweight Pattern) : 다수의 작은 객체를 효율적으로 공유하여 메모리 사용울 줄인다.( 문자열 상수 풀, 그래픽 객체)
- 프록시 패턴 (Proxy Pattern) : 실제 객체에 대한 대리 객체를 제공하여 <b>접근을 제어</b>(가상 프록시, 보호 프록시)
                    
## 3.행동 패턴 (객체나 클래스 간의 상호작용과 책임 분배에 관련된 패턴으로 객체간의 통신 방법을 정의한다.)
- 책임 연쇄 패턴 (Chain of Responsibility Pattern) : 요청을 처리할 수 있는 객체의 연쇄(이벤트 처리 시스템, 예외 처리)
- 커맨드 패턴 (Command Pattern) : 요청을 객체로 캡슐화하여 매개변수화된 명령을 처리(작업 취소/재실행, 매크로 기록)
- 인터프리터 패턴 (Interpreter Pattern) : 언어의 문법을 클래스로 표현하여 해석(SQL 파서, 정규 표현식)
- 이터레이터 패턴 (Iterator Pattern) : 집합체의 요소를 순차적으로 접근할 수 있는 방법을 제공(컬렉션 순회)
- 메멘토 패턴 (Memento Pattern) : 객체의 상태를 저장하고 복원할 수 있도록 한다. (되돌리기 기능, 상태 저장) 
- 중재자 패턴 (Mediator Pattern) : 객체 간의 상호작용을 캡슐화하여 객체들이 직접 통신하지 않고 정보집중적으로 <b>중재자</b>를 통해서 하도록한다.(채팅 시스템, GUI 이벤트 처리)
- 옵저버 패턴 (Observer Pattern) : 객체의 상태 변화에 따라 다른 객체들이 통보를 받는다.(이벤트 리스너, 데이터 바인딩)
- 상태 패턴 (State Pattern) : 객체의 상태에 따라 적절하게 행동을 변경한다. (상태 기계, UI 상태 관리)
- 전략 패턴 (Strategy Pattern) : 알고리즘을 캡슐화하여 상황적 효율성에 따라 교체할 수 있도록 한다. (정렬 알고리즘, 경로 탐색)
- 템플릿 메서드 패턴 (Template Method Pattern) : 알고리즘의 구조를 정의하고, 하위 클래스에서 세부 구현을 제공한다.(게임 루프, 데이터 처리 파이프라인)
- 방문자 패턴 (Visitor Pattern) : 객체 구조를 변경하지 않고 새로운 기능을 추가한다.(객체 트리 탐색, 문서 구조 변환)

참고 : https://refactoring.guru/ko/design-patterns

<!--

- interpreter =>
- mandate =>
- separate =>
- simple =>
- state =>
- struct =>
- waste =>

-->
