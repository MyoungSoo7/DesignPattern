[디자인 패턴]
- Adapter(변환) => Adapter (Print 인터페이스와 Banner 상속을 통해 PrintBanner 클래스에서 인터페이스 다형성을 활용한 변환 구현한다. 이렇게 해서 Print와 Banner의 확장과 변환에 유연하게 설계하고 <b>변환 책임<b>을 PrintBanner에 둔다.)
- Equate(유사패턴)  => Composite ( 상품, 카테고리의 객체를 각각 상품카테고리 객체의 추상화 메소드 활용해서 구성한다. <b>객체의 확장에 유연하게 설계한다.<b>)
                   => Decorator( 커피를 추상화하고 커피 종류와(케냐,에티오피아) 데코레이터 객체에 상속한다. 데코레이터객체는 라테,모카,휘핑크림에 상속한다. <br>
                      ,데코레이터를 통해 새로운 기능을 동적으로 추가 활용 가능하다.(커피 종류추가 및 커피데코레이터 추가한다. 이것은 객체 안에 객체를(데코레이터 조합) 계속 생성하는 형태로 나타난다.<br>
                      <b>객체의 장식을 유연하게 다변화 하게 설계한다.<b>
- instance => 추상화공장팩토리( 추상화 공장에서 키보드 마우스를 만든다. LG,Samsung회사의 공장에 추상화 공장을 상속해서 키보드 마우스를 만든다. 이렇게 해서 객체의 생성의 확장에 편리하게 객체 설계를 한다.)
              빌더 패턴
- interpreter =>
- mandate =>
- separate =>
- simple =>
- state =>
- struct =>
- waste =>

