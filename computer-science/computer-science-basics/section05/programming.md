# 프로그래밍의 다른 이름, 절차적 글쓰기

- 프로그래밍은 프로그래밍 언어로 글쓰기를 하는 것
- 프로그래밍을 배우려면 문법부터 배움
- 배운 문법을 가지고 절차적 글쓰는 능력을 키우는 것
- 인간의 언어가 아닌 컴퓨터가 이해할 수 있는 특수 언어
- 절차적인 논리가 없으면 글이 써지지 않듯이
- 프로그램을 작성할 수가 없음
- <u>모든 실행은 고유한 흐름을 갖는다</u>
- 프로그램의 근본적인 목표 = `자동화`

<br>
<br>

# 일단 써놓고 규칙을 찾기

- 알고리즘 문제를 풀 때, 무식할 정도로, 이렇게 쓰는게 맞나 싶을 정도로 풀어서 작성하면서 연습하기
- 최소 3개월을 프로그래밍적 사고 방식을 훈련해야 함.

<br>
<br>

# 고급어와 저급어

- High Level과 Low Level의 직역
- Low Level = 기계어 (Machine Code)
- 기계어는 사람이 알아보기 어려움
- High Level은 사람이 이해하기 쉬운 표현 방식
- High Level Code는 함수 단위로 묶어서 표현
- ### `High Level` -> `(Compile) 번역` -> `Low Level`

---

- User Mode의 Application Program을 실행하면 Process가 되는데
- 이런 Program을 개발할 때 High Level언어를 사용한다.
- 이 Program을 CPU가 이해하고 연산할 수 있도록 Compile을 한다.
    - C언어 = Native Code
        - 운영체제를 의존한다.

---
- CPU를 User mode의 Application으로 구현할 수 있을까?
- 가능하다.
- S/W = logical = virtual -> virtual machine => Managed
- OS에 의존하지 않음. 
- 직접 CPU가 하지 않고 대행하는 S/W가 있는 것.

<br>
<br>

# 인터프리터(Interpreter)

- 고급어 소스 코드를 직접 실행하는 프로그램이나 환경
- 한 번에 한 줄 단위로 실행
- 성능면에서 컴파일러보다 느림
- JavaScript, Python

<br>
<br>

# API, SDK

- API
    - Application Programming Interface
- SDK
    - Software Development Kit

- 함수와 함수 세트를 의미
    - ex)공구와 공구 세트