## 디자인 패턴 코드 

### observer 패턴
* 한 객체의 상태가 바뀌면 그 객체에 의존하는 다른 객체들한테 연락이 가고 자동으로 내용이 갱신되는 방식으로 일대다(one-to-many) 의존성을 정의한다.
* 구독의 개념과 유사한데 , 주제(subject)와 구독자(observer)간의 정보를 알려주는 패턴을 정의한다.
subject에 변화가 발생하면 해당 subject의 정보를 구독하고 있는 observer들에게 변경된 정보가 전달될 수 있도록 알려주는 패턴.
* subject가 observer들에게 알려주는 push 방식과, observer들이 subject에게 정보를 받아가는 pull방식이 있다.
* java의 내장 옵저버 패턴인 `java.util.Observable` 클래스를 활용할 수 있다. 
* 옵저버들에게 알람이 가는 순서는 절대 의존하면 안된다. 
