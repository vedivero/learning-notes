### ✅ Redis란?

레디스(Redis)는 Remote Dictionary Server의 약자.

“키-값” 구조의 비정형 데이터를 저장하고 관리하기 위한 오픈 소스 기반의 비관계형 데이터베이스 관리 시스템(DBMS)

> Redis는 데이터 처리 속도가 엄청 빠른 NoSQL 데이터베이스

---

### ✅ Redis의 장점

> Redis 여러 특징 중, 1가지만 확실하게 기억하기. 레디스(Redis)는 인메모리(in-memory)에 모든 데이터를 저장.그래서 데이터의 처리 성능이 굉장히 빠름.

---

### ✅ Redis 사용 사례

- ✅ **캐싱 (Caching)** 
- 세션 관리 (Session Management)
- 실시간 분석 및 통계 (Real-time Analystics)
- 메시지 큐 (Message Queue)
- 지리공간 인덱싱 (Geospatial Indexing)
- 속도 제한 (Rate Limiting)
- 실시간 채팅 및 메시징 (Real-time Chat And Messaging)

---

<br>
<br>

## Redis 기본 명령어

### ✅ 데이터(Key, Value) 저장하기

```
# set [key 이름] [value]

$ set vedivero:hobby soccer

# 띄워쓰기 해서 저장하려면 쌍따옴표로 묶어주면 됨

$ set vedivero:name "vedivero lee" 
```

### ✅ 데이터 조회하기 (Key로 Value 값 조회하기)

```
# get [key 이름]
$ get vedivero:name
$ get vedivero:hobby

# 없는 데이터를 조회할 경우 (nil)이라고 출력됨
$ get james:name 
```

### ✅ 저장된 모든 key 조회하기

```
$ keys *
```

### ✅ 데이터 삭제하기 (Key로 데이터 삭제하기)

```
# del [key 이름]
$ del vedivero:hobby
$ get vedivero:hobby # 삭제됐는 지 확인
Redis 기본 명령어 익히기 1
```

### ✅ 데이터 저장 시 만료시간(TTL) 정하기
```
레디스는 RDBMS와는 다르게 데이터 저장 시 만료시간을 설정할 수 있다. 즉, 영구적으로 데이터를 저장하지 않고 일정 시간이 되면 데이터가
삭제되도록 셋팅할 수 있다.
레디스의 특성상 메모리 공간이 한정 되어 있기 때문에 모든 데이터를 레디스에 저장할 수 없다. 따라서 만료시간(TTL)을 활용해 자주 사용하
는 데이터만 레디스에 저장해놓고 쓰는 식으로 활용한다.
# set [key 이름] [value] ex [만료 시간(초)]
$ set vedivero:pet dog ex 30
```

### ✅ 만료시간(TTL) 확인하기

```
# ttl [key 이름]

# 만료 시간이 몇 초 남았는 지 반환
# 키가 없는 경우 -2를 반환
# 키는 존재하지만 만료 시간이 설정돼 있지 않은 경우에는 -1을 반환

$ ttl vedivero:pet
$ ttl vedivero:name
$ ttl james:name
```

### ✅ 모든 데이터 삭제하기
```
$ flushall
```