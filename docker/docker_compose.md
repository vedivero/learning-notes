# 📍 Docker Compose를 활용해 컨테이너 관리하기

## Docker Compose를 사용하는 이유

### ✅ Docker Copmose란?
여러 개의 Docker 컨테이너들을, 하나의 서비스로 정의하고 구성해 하나의 묶음으로 관리할 수 있게 도와주는 툴이다.

### ✅ Docker Compose를 사용하는 이유

#### 1. 여러 개의 컨테이너를 관리하는 데 용이
    여러 개의 컨테이너로 이루어진 복잡한 애플리케이션을 한 번에 관리할 수 있게 해준다.
    여러 컨테이너를 하나의 환경에서 실행하고 관리하는 데 도움이 된다.

#### 2. 복잡한 명령어로 실행시키던 걸 간소화 시킬 수 있음

- 이전에 MySQL 이미지를 컨테이너로 실행시킬 때 아래와 같은 명령어를 실행시켰다.

```
$ docker run -e MYSQL_ROOT_PASSWORD=password123 -p 3306:3306 -v /Users/jaeseong/Documents/
Develop/doc
```

- 너무 복잡하지 않은가? Docker Compose를 사용하면 위와 같이 컨테이너를 실행시킬 때마다 복잡한 명령어를 입력하지 않아도 된다.
- 단순히 docker compose up 명령어만 실행시키면 된다. 

<br>
<br>
<br>

## Docker Compose 전체 흐름 느껴보기(with Nginx)

### ✅ 기존 Docker CLI로 컨테이너를 실행시킬 때

```
$ docker run --name webserver -d -p 80:80 nginx
```

### ✅ Docker Compose로 컨테이너를 실행시킬 때


### 1. compose.yml 파일 작성하기

`compose.yml`
    ```
    services:
        my-web-server:
            container_name: webserver
            image: nginx
            ports:
                - 80:80
    ```

`compose.yml` 파일 해석
    ```
    # Docker Compose에서는 하나의 컨테이너를 `service`라고 함
    services:
        
        # 서비스에 대한 이름을 설정
        my-web-server:

            # 컨테이너의 이름을 설정
            container_name: webserver

            # 이미지
            image: nginx

            # PORT Mapping
            ports:
                - 80:80
    ```

- `services: my-web-server` : Docekr Compose에서 하나의 컨테이너를 서비스(service)라고 부른다. 이 옵션은 서비스에 이름을 붙이는
기능이다.
- `container_name: web-server` : 컨테이너를 띄울 때 붙이는 별칭이다. CLI에서 --name web-server 역할과 동일하다.
- `image: nginx` : 컨테이너를 실행시킬 때 어떤 이미지를 사용할 지 정의하는 명령어이다. $ docker run [이미지명] 와 동일한 역할이다.
- `ports` : 포트 매핑은 어떻게 할 지를 설정하는 옵션이다. CLI에서 -p 80:80 역할과 동일하다.

### 2. compose 파일 실행시키기

```
$ docker compose up -d
```

![alt text](image-26.png)

### 3. compose 실행 현황 보기

```
$ docker compose ps
$ docker ps
```
![alt text](image-29.png)

### 4. localhost:80 들어가보기

![alt text](image-27.png)

### 5. compose로 실행된 컨테이너 삭제

```
$ docker compose down
```

![alt text](image-28.png)