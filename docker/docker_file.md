# 📍 Dockerfile로 이미지를 직접 생성하기

## Dockerfile이란?

- Docker 이미지는 Dockerhub을 통해 다운받아서 사용할 수 있다.
- 이 Docker 이미지들도 누군가 만들어서 Dockerhub에 올려놓은 것.
> 그럼 도대체 이 Dcoker 이미지는 어떻게 만드는 걸까?

- Dockerfile이라는 걸 활용해서 Docker 이미지를 만들 수 있다.
- Dockerhub에 올려놓은 Docker 이미지가 아닌, 나만의 Docker 이미지를 만들고 싶을 수 있다. 

- 예를 들어, 내가 만든 Spring Boot 프로젝트가 있다.
- 내가 만든 Spring Boot 프로젝트 자체를 Docker 이미지로 만들고 싶을 수 있다.
- 이럴 때에도 Dockerfile을 활용하면 나만의 Docker 이미지를 만들 수 있게 된다.

>정리하자면, Dockerfile이란 Docker 이미지를 만들게 해주는 파일이다.


<br>
<br>
<br>

## 베이스 이미지

### ✅ 의미
- FROM 은 베이스 이미지를 생성하는 역할을 한다.
- Docker 컨테이너를 특정 초기 이미지를 기반으로 추가적인 세팅을 할 수 있다.
- 여기서 얘기한 ‘특정 초기 이미지’가 곧 베이스 이미지이다.

>조금 더 쉽게 설명해보겠다.

- 우리가 윈도우 컴퓨터를 새로 사서 실행시켜보면 기본 프로그램들(인터넷, 그림판, 메모장 등)이 많이 깔려있다.
- 베이스 이미지도 이와 똑같다.
- 컨테이너를 새로 띄워서 미니 컴퓨터 환경을 구축할 때 기본 프로그램이 어떤게 깔려있으면 좋겠는 지 선택하는 옵션이라고 생각하면 된다.
- 누군가는 JDK가 깔려있는 컴퓨터 환경이 세팅되기를 바랄 수도 있고, 누군가는 Node가 깔려있는 컴퓨터 환경이 세팅되기를 바랄 수도 있다.
- 필요에 따라 베이스 이미지를 고르면 된다.

### ✅ 사용법
```
FROM [이미지명]
FROM [이미지명]:[태그명]

# 태그명 을 적지 않으면 해당 이미지의 최신(latest) 버전을 사용한다. 
```

<br>
<br>
<br>

## 베이스 이미지 생성하기

- 베이스 이미지 설정
    
    ```
    FROM openjdk:17-jdk
    ```
    - 베이스 이미지
    - 해당 이미지를 사용해서 컨테이너가 생성됐을 때, 기본적으로 설치되어 있도록 설정

- 베이스 이미지 생성

    ```
    docker build -t my-jdk-server .
    ```

    ![alt text](image-7.png)

    생성된 이미지

    ![alt text](image-8.png)

- 생성한 이미지로 컨테이너 생성하기

    - 실행
    ```
    docker run -d my-jdk-server
    
    836d44d61ae608355397990e45ca4f019a0bf57382f544a975f6c82038b309d1

    # 실행 됨
    ```
    
    - 실행됐지만, 바로 종료 
    ```
    docker ps -a

    CONTAINER ID  IMAGE          COMMAND  CREATED       STATUS                     PORTS  NAMES
    836d44d61ae6  my-jdk-server  "jshell" 6 seconds ago Exited (0) 5 seconds ago          trusting_clarke
    ```

    - log 확인하기
    ```
    docker logs 836

    Oct 20, 2025 12:19:37 PM java.util.prefs.FileSystemPreferences$1 run
    INFO: Created user preferences directory.
    |  Welcome to JShell -- Version 17.0.2
    |  For an introduction type: /help intro

    jshell>

    # 특별한 에러 없음
    ```


<br>
<br>
<br>

- 컨테이너는 해야할 내부 작업이 끝나게 되면 자동으로 종료.
- `Dockerfile`은 컨테이너가 작업해야할 목록을 적어놓은 파일.
- `FROM openjdk:17-jdk` 이 외 수행해야할 작업이 없으므로 종료.

## 컨테이너에 접속해서 openjdk:17-jdk 설치 확인하기

- 실행하기

    ```
    docker exec -it my-jdk17-server
    ```

    - 컨테이너가 실행 중이지 않으므로, 접속 불가.

- 접속 가능하게 하기, `Dockerfile` 수정

    ```
    ENTRYPOINT ["/bin/bash", "-c", "sleeep 500"]
    ```

- Docker Build

    ```
    docker build -t my-jdk-server .

    # Dockerfile의 현재 경로
    ```

- Docker run

    ```
    docker run -d my-jdk-server
    ```

- Check

    ```
    docker ps
    ```

- logs

    ```
    docker logs my-jdk-server
    ```

- 컨테이너 접속하기

    ```
    docker exec -it my-jdk-server bash
    ```

- 자바 버전 확인하기

    ```
    java -version
    ```


<br>
<br>
<br>

## 컨테이너에 접속해서 node 설치 확인하기

- `Dockerfile` 수정

    ```
    FROM node

    ENTRYPOINT ["/bin/bash", "-c", "sleeep 500"]
    ```

- Docker Build

    ```
    docker build -t my-node-server .

    # Dockerfile의 현재 경로
    ```

- Docker run

    ```
    docker run -d my-node-server
    ```

- Check

    ```
    docker ps
    ```

- logs

    ```
    docker logs my-node-server
    ```

- 컨테이너 접속하기

    ```
    docker exec -it my-node-server bash
    ```

- 노드 버전 확인하기

    ```
    node -v
    ```


<br>
<br>
<br>

## 종료된 컨테이너에 접속해서 디버깅하기

> 프로그래밍을 할 때 중간중간 잘 작동하는 지 확인하는 습관은 굉장히 중요.

- 어떤 명령어를 입력하고 난 뒤에 명령어가 정상적으로 수행됐는 지 어떻게 확인할 수 있는 지 방법을 찾아봐야 한다.
- 이 습관이 몸에 익으면 어떤 명령어를 수행하더라도 그 명령어가 어떻게 작동하는 지 파헤칠 수 있게 된다. - 또한 어떤 명령어를 실행시킨 뒤에 에러가 생기더라도 금방 발견할 수 있어서 디버깅도 훨씬 수월하다.

> Docker를 사용하면 대부분의 코드가 컨테이너 내부에서 작동한다.
- 그러다보니 어떤 과정으로 처리됐는 지, 잘 처리는 됐는 지를 직접적으로 눈에 보이지 않는다.
- 이 때문에 Docker 학습에 어려움을 겪는다.

> 이를 해결하기 위해 우리는 2가지 방법을 이미 익혔다.
- docker logs 를 활용해 컨테이너 로그 확인하기
- docker exec -it 를 활용해 컨테이너 내부에 직접 들어가보기
- 위 방법 중 docker exec -it 은 실행 중인 컨테이너에만 쓸 수 있는 명령어이다.
- 종료된 컨테이너는 아래와 같은 에러가 발생한다.

>하지만 이미지를 만들면서 컨테이너를 실행시켜보면, 컨테이너의 특성상 명령어 처리가 다 끝나는대로 컨테이너가 종료된다.
- 그러다보니 내부적으로 어떻게 컨테이너가 형성됐는 지 디버깅을 하는데 어려움을 겪는다.

### 어떻게 해야 할까?

#### Dockerfile
```
FROM openjdk:17-jdk

...

# 500초 동안 시스템을 일시정지 시키는 명령어
ENTRYPOINT ["/bin/bash", "-c", "sleep 500"] 
```

- 위 명령어를 추가함으로써 컨테이너가 바로 종료되는 걸 막을 수 있다.
- 그런 뒤에 docker exec -it 를 활용해 컨테이너 내부에 직접 들어가서 디버깅을 하면 된다.


<br>
<br>
<br>

## COPY : 파일 복사(이동)

- 호스트 컴퓨터의 (파일) ➡️ 컨테이너로 전달하는 기능

    ### app.txt

    - `config.txt` 생성

        ```
        Config File
        ```

    
    - `Dockerfile` 생성

        ```
        FROM ubuntu

        # HOST 컴퓨터의 app.txt를 컨테이너의 절대 경로인 /app.txt 경로로 복사
        COPY app.txt /app.txt
        # '/' = 절대 경로


        ENTRYPOINT ["/bin/bash", "-c", "sleep 500"]  
        ```

    - Build

        ```
        docker build -t my-server .
        ```

    - 컨테이너 실행

        ```
        docker run -d my-server
        ```

    - 컨테이너 접속

        ```
        docker exec -it my-server bash
        ```

    - `ls` and `cat app.txt`
        - 컨테이너로 복사 됨


<br>
<br>

- 호스트 컴퓨터의 (폴더) ➡️ 컨테이너로 전달하는 기능

    ### my-app/config.txt
    
    - `config.txt` 생성

        ```
        Config File
        ```

    - `Dockerfile` 생성

        ```
        FROM ubuntu

        # HOST 컴퓨터의 config.txt를 복사할거야
        # 컨테이너 안, 절대 경로인 /my-app 경로로 복사할거야
        COPY my-app /my-app/

        # '/' = 절대 경로
        # 디렉터리 복사 = 끝 부분 '/' 입력


        ENTRYPOINT ["/bin/bash", "-c", "sleep 500"]  
        ```

    - Build

        ```
        docker build -t my-server .
        ``` 

    - 컨테이너 실행

        ```
        docker run -d my-server
        ```

    - 컨테이너 접속

        ```
        docker exec -it my-server bash
        ```

    - `ls` and `cat app.txt`
        - 컨테이너로 복사 됨

<br>
<br>

- 호스트 컴퓨터의 (폴더) ➡️ 컨테이너로 전달하는 기능

    ### readme.txt

    - `readme.txt` 생성

        ```
        My Readme
        ```
    
    - `Dockerfile` 생성

        ```
        FROM ubuntu

        # HOST 컴퓨터의 .txt로 끝나는 모든 파일을 복사할거야
        # wild card 사용

        # 컨테이너 안, 절대 경로인 text-files/ 폴더를 생성해서 복사할거야
        COPY *.txt  /text-files/

        # '/' = 절대 경로
        # 디렉터리 복사 = 끝 부분 '/' 입력


        ENTRYPOINT ["/bin/bash", "-c", "sleep 500"]  
        ```

    - Build

        ```
        docker build -t my-server .
        ``` 

    - 컨테이너 실행

        ```
        docker run -d my-server
        ```

    - 컨테이너 접속

        ```
        docker exec -it my-server bash
        ```

    - `ls` and `cd text-files`
        - 컨테이너로 복사 됨

<br>
<br>

- 특정 파일만 제외하고, 호스트 컴퓨터의 (파일) ➡️ 컨테이너로 전달하는 기능

    ### .dockerignore

    - `.dockerignore` 생성

        ```
        # 제외할 파일을 작성
        readme.txt
        ```
    
    - `Dockerfile` 생성

        ```
        FROM ubuntu

        # HOST 컴퓨터의 모든 파일을 복사할거야
        # 컨테이너 안, 절대 경로인 / (root) 경로로 복사할거야
        COPY ./ /

        # '/' = 절대 경로
        # 디렉터리 복사 = 끝 부분 '/' 입력


        ENTRYPOINT ["/bin/bash", "-c", "sleep 500"]  
        ```

    - Build

        ```
        docker build -t my-server .
        ``` 

    - 컨테이너 실행

        ```
        docker run -d my-server
        ```

    - 컨테이너 접속

        ```
        docker exec -it my-server bash
        ```

    - `ls` and `cd text-files`
        - 컨테이너로 복사 됨

<br>
<br>
<br>

## ENTRYPOINT : 컨테이너가 시작할 때 실행되는 명령어

### ✅ 의미
- ENTRYPOINT 는 컨테이너가 생성되고 최초로 실행할 때 수행되는 명령어를 뜻한다.
- 쉽게 설명하자면 ENTRYPOINT 에는 미니 컴퓨터의 전원을 키고나서 실행시키고 싶은 명령어를 적으면 된다.

### ✅ 사용법
- 문법
    ```
    ENTRYPOINT [명령문...]
    ```
- 예시

    ```
    ENTRYPOINT ["node", "dist/main.js"]
    ```

### 🎯 예제

#### Dockerfile

```
FROM ubuntu

ENTRYPOINT ["/bin/bash", "-c", "echo hello"]
```

```
$ docker build -t my-server .
$ docker run -d my-server
$ docker ps -a
$ docker logs [Container ID]
```

<br>
<br>
<br>

### 실습

- `Dockerfile` 생성

    ```
    FROM ubuntu

    ENTRYPOINT ["/bin/bash", "-c", "echo hello"]
    ```

    - ubuntu 베이스 이미지를 생성
    - 이미지를 컨테이너로 실행하는 순간, ENTRYPOINT ["/bin/bash", "-c", "echo hello"] 명령어 입력


- Build

    ```
    docker build -t my-server .
    ``` 

- 컨테이너 실행

    ```
    docker run -d my-server
    ```

- 컨테이너 확인

    ```
    docker ps
    ```

    - ENTRYPOINT ["/bin/bash", "-c", "echo hello"]를 실행하고 컨테이너가 종료 됨

- 로그 확인

    ```
    docker logs my-server

    hello
    ```

<br>
<br>
<br>

## Spring Boot - Dokcer

- https://start.spring.io/ 접속 및 프로젝트 설정

    - Spring Web 추가
    - Spring Boot DevTools 추가

    - GENERATE

- IDE로 프로젝트 열기

    - AppController.java

        ```
        @RestController
        public class AppController {

            @GetMapping("/")
            public String home() {
                return "Hello, World";
            }
        }
        ```
    
    - 프로그램 실행 및 접속 테스트

        ![alt text](image-9.png)

- 프로젝트 이미지 생성하기 - Dockerfile

    - root 경로에 `Dockerfile` 생성

- Dockerfile 작성

    `Dockerfile`
    ```
    # Spring Boot Proejct를 실행하기위한 JDK
    FROM openjdk:17-jdk
    ```

- Spring Boot Project 종료 및 Build

    ```
    ./gradlew clean build
    ```

- Build된 Jar파일을 컨테이너로 복사되게 설정

    `Dockerfile`
    ```
    FROM openjdk:17-jdk

    # Copy를 통해 빌드한 파일(Jar)을 컨테이너로 복사
    # 컨테이너 안에서 빌드한 파일(Jar)을 실행시키려고 함
    COPY build/libs/*SNAPSHOT.jar app.jar

    # SNAPSHOT.jar로 끝나는 파일을 지정
    # 컨테이너 안 app.jar라는 이름으로 복사하겠다
    # (app.jar) 상대 경로를 작성해도 컨테이너 내부 절대 경로에 파일이 복사가 됨
    # /app.jar로 작성해도 됨

    # 컨테이너가 실행될 때, 최초로 실행시킬 명령어
    ENTRYPOINT ["java", "-jar" "/app.jar"]
    ```

- 다시, Spring Boot Project Build

    ```
    ./gradlew clean build
    ```

- Docker Image 생성하기

    ```
    docker build -t hello-server .
    ```
    - `.` = Dockerfile이 위치한 경로

- 생성한 이미지 컨테이너에 실행

    - 8080 port mapping

    ```
    docker run -d -p 8080:8080 hello-server
    ```

- `docker ps` 및 `docker logs <CONTAINER ID>`로 확인

### Docker로 가동한 Spring Boot Project
![alt text](image-10.png)

### 접속 화면
![alt text](image-11.png)

### 아키텍처
![alt text](image-12.png)

<br>
<br>
<br>

## RUN : 이미지 생성 과정에서 사용할 명령문 실행

### ✅ 의미
RUN 은 이미지 생성 과정에서 명령어를 실행시켜야 할 때 사용한다.

### ✅ 사용법

- 문법
```
RUN [명령문]
```

- 예시
```
RUN npm install
```

<br>

### ✅ RUN vs ENTRYPOINT
- RUN 명령어와 ENTRYPOINT 명령어가 헷갈릴 때가 있다.
- 둘 다 같이 명령어를 실행시키기 때문이다.
> 하지만 엄연히 둘의 사용 용도는 다르다.
- RUN 은 `이미지 생성 과정`에서 필요한 명령어를 실행시킬 때 사용.
- ENTRYPOINT 는 생성된 이미지를 기반으로 `컨테이너를 생성한 직후`에 명령어를 실행시킬 때 사용.

<br>

### 🎯 예제

미니 컴퓨터 환경이 ubuntu로 구성되었으면 좋겠고 git이 깔려있으면 좋겠다고 가정하자.
> 이런 환경을 구성하기 위해 `Dockerfile`을 활용해 `ubuntu`, `git`이 깔려있는 이미지를 만들면 된다.

<br>

#### 1. Dockerfile 작성하기
`Dockerfile`

```
FROM ubuntu

# Git을 설치하고 Image를 만들어
RUN apt update && apt install -y git

# Image를 다 만들고, 컨테이너에 실행시킬 때, 이 명령어를 수행해
ENTRYPOINT ["/bin/bash", "-c", "sleep 500"]
```

#### 2. 이미지 빌드 및 컨테이너 실행

```
$ docker build -t my-server .

$ docker run -d my-server

$ docker exec -it [Container ID] bash

$ git -v # 컨테이너 내에 git이 잘 설치됐는 지 확인
```

<br>
<br>
<br>

## WORKDIR : 작업 디렉토리 지정

### ✅ 의미
- WORKDIR 으로 작업 디렉터리를 전환하면, 그 이후에 등장하는 모든 RUN, CMD, ENTRYPOINT, COPY, ADD 명령문은 해당 디렉터리를 기준으로 실행된다.
- 작업 디렉터리를 굳이 지정해주는 이유는 컨테이너 내부의 폴더를 깔끔하게 관리하기 위해서이다. 
- 컨테이너도 미니 컴퓨터와 같기 때문에 `Dockerfile` 을 통해 생성되는 파일들을 특정 폴더에 정리해두는 것이 추후에 관리가 쉽다.

> 만약 WORKDIR 을 쓰지 않으면 컨테이너 내부에 존재하는 기존 파일들과 뒤섞여버린다.

### ✅ 사용법

- 문법
    ```
    WORKDIR [작업 디렉토리로 사용할 절대 경로]
    ```
- 예시
    ```
    WORKDIR /usr/src/app
    ```
- 예제
1. app.txt , src , config.json 파일 만들기

2. Dockerfile 만들어서 이미지 생성 및 컨테이너 실행


> WORKDIR 을 안 썼을 때 파일이 어떻게 구성되는 지 먼저 확인해보자.

`Dockerfile`

```
FROM ubuntu

COPY ./ ./

ENTRYPOINT ["/bin/bash", "-c", "sleep 500"] # 디버깅용 코드
```
```
$ docker build -t my-server .
$ docker run -d my-server
$ docker exec -it [Container ID] bash

$ ls
```

> WORKDIR 을 썼을 때 파일이 어떻게 구성되는 지 확인해보자.
`Dockerfile`

```
FROM ubuntu

# WORKDIR : 작업 디렉토리를 지정 1
WORKDIR /my-dir

COPY ./ ./

ENTRYPOINT ["/bin/bash", "-c", "sleep 500"]
```

```
$ docker build -t my-server .
$ docker run -d my-server
$ docker exec -it [Container ID] bash

$ ls
```

---

## docker-workdir 폴더 생성으로 실습하기

- Dockerfile 생성

    ```
    FROM ubuntu

    # 둘 다 상대 경로
    COPY ./ ./

    # Dubugging용
    ENTRYPOINT [ "/bin/bash", "-c", "sleep 500" ]
    ```

- 여러 가지 파일 생성

    ```
    app.txt
    /src
    config.json
    ```

- 생성한 Dockerfile로 Build하기 - Docker Build

    ```
    # my-server라는 title로 이미지 생성하기
    docker build -t my-server
    ```

- Build를 통해 생성한 이미지를 컨테이너로 실행하기

    ```
    docker run -d my-server
    ```

- 컨테이너 접속하기

    ```
    docker exec -it <CONTAINER ID>
    ```

- `ls` 명령어로 파일 및 폴더 확인하기

    - 많은 파일 및 폴더로 인해 구분하기 어려움
    - `workdir`를 통해 이 불편함을 해결하기

- Dockerfile 수정

    ```
    FROM ubuntu

    WORKDIR /my-dir ✅추가

    COPY ./ ./

    ENTRYPOINT [ "/bin/bash", "-c", "sleep 500" ]
    ```

- Dockerfile을 수정했으니 다시 Build하기 

    ```
    docker build -t my-server
    ```

- 컨테이너 접속하기

    ```
    docker exec -it <CONTAINER ID>
    ```

- 컨테이너에 접석할 때 부터 기본 경로가 `WORKDIR`에서 정의한 경로로 설정

    ```
    root@a04928d939f:/my-dir# 
    ```

    - workdir = 최초 경로를 설정하는 역할도 있음

- `ls` 명령어로 파일 및 폴더 확인하기

    - `Dockerfile`에 정의해 둔 파일들이 `my-dir` 폴더에 저장되어 있다.

<br>
<br>
<br>

## EXPOSE : 컨테이너 내부에서 사용 중인 포트 문서화

### ✅ 의미
- `EXPOSE`는 컨테이너 내부에서 어떤 포트에 프로그램이 실행되는 지를 문서화하는 역할만 한다.
- docker -p 8080:8080 … 와 같은 명령어의 -p 옵션과 같은 역할은 일체 하지 않는다.
- 쉽게 표현하자면 EXPOSE 명령어는 쓰나, 안 쓰나 작동하는 방식에는 영향을 미치지 않는다.

### ✅ 사용법

```
# 문법
EXPOSE [포트 번호]

# 예시
EXPOSE 3000
```

<br>
<br>
<br>

## Nest.js를 Docker로 실행시키기

### 1. Nest.js 프로젝트 만들기

```
# Nest CLI 설치
$ npm i -g @nestjs/cli

# nest new {프로젝트명}
$ nest new my-server
```

<br>

### 2. Dockerfile 작성하기
`Dockerfile`

```
# 베이스 이미지 - node가 설치되어 있는 컨테이너 환경
FROM node

# `app`이란 폴더 안에 COPY에 작성한 파일 및 폴더들을 저장
WORKDIR /app

# `my-server` 프로젝트의 모든 파일을 컨테이너로 복사
COPY . .

# 이미지를 생성하는 과정, 컨테이너가 실행되기 전 사전 세팅을 원하는 명령어
# package.json에 정의된 라이브러리를 설치하기 위한 설정
RUN npm install

# 이미지를 생성하는 과정에서 빌드되도록 설정
RUN npm run build

# 3000번 포트에서 실행됨을 명시
EXPOSE 3000

# 컨테이너가 실행되고 나서, 실행할 명령어 설정
ENTRYPOINT [ "node", "dist/main.js" ]
```

> 💡Docker 이미지 생성 시 캐시를 활용해서 최적화할 수 있는 방법은 아래 링크를 참고.
Docker Layer와 Cache
https://medium.com/@hee98.09.14/docker-layer와-cache-574c12a1e9f7

<br>

### 3. .dockerignore 작성하기
`.dockerignore`

```
node_modules
```

- 이미지를 생성할 때 npm install 을 통해 처음부터 깔끔하게 필요한 의존성만 설치한다. 
- 따라서 호스트 컴퓨터에 있는 node_modules 는 컨테이너로 복사해갈 필요가 없다.

<br>

### 4. Dockerfile을 바탕으로 이미지 빌드하기

```
$ docker build -t my-server .
```

<br>

### 5. 이미지가 잘 생성됐는 지 확인하기

```
$ docker image ls
```

![alt text](image-13.png)

<br>

### 6. 생성한 이미지를 컨테이너로 실행시켜보기
```
$ docker run -d -p 3000:3000 my-server
```

<br>

### 7. 컨테이너 잘 실행되고 있는 지 확인하기
```
$ docker ps
```
![alt text](image-14.png)

<br>

### 8. localhost:3000으로 들어가보기

<br>

![alt text](image-15.png)

### 9. 실행시킨 컨테이너 중지 / 삭제하기, 이미지 삭제하기
```
$ docker stop <CONTAINER ID>
$ docker rm <CONTAINER ID>
$ docker image rm <CONTAINER ID>
```

### 10. 아키텍처

![alt text](image-16.png)

<br>
<br>
<br>

## Next.js를 Docker로 배포하기


### 1. Next.js 프로젝트 만들기

```
$ npx create-next-app@latest
```

### 2. Dockerfile 작성하기
`Dockerfile`

```
# `베이스 이미지` - node:20-alpine가 설치되어 있는 컨테이너 환경을 구성
# `alpine` : 필요한 것만 경량화 처리한 이미지
FROM node:20-alpine

# `app` 폴더에 COPY에서 지정한 파일을 복사하겠다
WORKDIR /app

# 모든 파일을 가져가겠다
COPY . .

# 이미지를 생성하는 과정 중 실행할 명령어
RUN npm install
RUN npm run build

# 실행될 PORT
EXPOSE 3000

# 컨테이너가 생성된 후, `Next.js`를 실행하기 위한 명령어 설정
ENTRYPOINT [ "npm", "run", "start" ]
```

- Docker 이미지 생성 시 캐시를 활용해서 최적화할 수 있는 방법은 아래 링크를 참고.
    - Docker Layer와 Cache
        - https://medium.com/@hee98.09.14/docker-layer와-cache-574c12a1e9f7

- `alpine` : 불필요한 프로그램을 포함하지 않고 이미지 크기를 최소화한 버전. 실제 배포 할 때도 되도록이면 alpine 버전을 사용.

### 3. .dockerignore 작성하기
`.dockerignore`

```
node_modules
```

- 이미지를 생성할 때 npm install 을 통해 처음부터 깔끔하게 필요한 의존성만 설치.
- 따라서 호스트 컴퓨터에 있는 node_modules 는 컨테이너로 복사해갈 필요가 없다.

### 4. Dockerfile을 바탕으로 이미지 빌드하기

```
$ docker build -t my-web-server .
```

![alt text](image-17.png)

### 5. 이미지가 잘 생성됐는 지 확인하기

```
$ docker image ls
```

### 6. 생성한 이미지를 컨테이너로 실행시켜보기

```
$ docker run -d -p 80:3000 my-web-server
```

![alt text](image-18.png)

### 7. 컨테이너 잘 실행되고 있는 지 확인하기

```
$ docker ps
```

### 8. localhost:80으로 들어가보기

![alt text](image-19.png)

### 9. 실행시킨 컨테이너 중지 / 삭제하기, 이미지 삭제하기

```
$ docker stop <CONTAINER ID>
$ docker rm <CONTAINER ID>
$ docker image rm <CONTAINER ID>
```

### 10. 아키텍처

![alt text](image-20.png)

<br>
<br>
<br>

## HTML, CSS, Nginx를 Docker로 배포하기

### 1. HTML, CSS 파일 만들기
`index.html`

```
<!DOCTYPE html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="style.css">
    </head>
        <body>
            <h1>My Web Page</h1>
        </body>
</html>
```

> 💡 Nginx의 기본 설정에 의하면 메인 페이지(첫 페이지)의 파일명을 index.html 이라고 지어야 한다.

`style.css`

```
* {
    color: blue;
}
```

### 2. Dockerfile 작성하기
`Dockerfile`

```
FROM nginx
COPY ./ /usr/share/nginx/html
```

### 3. Dockerfile을 바탕으로 이미지 빌드하기
```
$ docker build -t my-web-server .
```

![alt text](image-21.png)


### 4. 이미지가 잘 생성됐는 지 확인하기
```
$ docker image ls
```

![alt text](image-22.png)

### 5. 생성한 이미지를 컨테이너로 실행시켜보기
```
$ docker run -d -p 80:80 my-web-server
```

![alt text](image-23.png)

### 6. 컨테이너 잘 실행되고 있는 지 확인하기

```
$ docker ps
```

![alt text](image-24.png)

### 7. localhost:80으로 들어가보기

![alt text](image-25.png)

### 8. 실행시킨 컨테이너 중지 / 삭제하기, 이미지 삭제하기

```
$ docker stop <CONTAINER ID>
$ docker rm <CONTAINER ID>
$ docker image rm <CONTAINER ID>
```