## Comparable Comparator 의 차이 

* 둘다 인터페이스 
* 즉 이 둘을 사용하고자 한다면 인터페이스 내에 선언된 메서드를 반드시 **구현**해야한다.

> Comparable - lang 패키지
>
> - compareTo(T o) 

> Comparator - util
>
> - compare(T o1, T o2)

* 이 두 인터페이스는 객체를 비교할 수 있도록 만든다.
* Comparable은 "자기자신"과 "매개변수" 객체를 비교 한다.
* Comparator 는 자기자신이 어떻든 "매개변수로 들어온 2객체"를 비교한다. 

* 즉 본질적으로 비교한다는 것 자체는 같지만 비교대상이 다르다.

  
