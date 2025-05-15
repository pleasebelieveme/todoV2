![header](https://capsule-render.vercel.app/api?type=waving&color=auto&height=250&section=header&text=TODO_V2%20Project&fontSize=80)

## 🤔 개요
- 이 프로젝트는 스프링부트와 JPA를 사용해 회원 C, 일정 CRUD, 댓글 CRUD, 대댓글 CRUD를 구현한 애플리케이션입니다.

##  🌳 개발환경
언어 : ![Static Badge](https://img.shields.io/badge/Java-red?style=flat-square)

JDK : ![Static Badge](https://img.shields.io/badge/JDK-17-yellow?style=flat-square)

프레임워크 : ![Static Badge](https://img.shields.io/badge/SpringBoot-%23FFFF00?logo=springboot)

DB : ![Static Badge](https://img.shields.io/badge/MySql-%23FFFFFF?style=flat&logo=mysql)

ORM : ![Static Badge](https://img.shields.io/badge/JPA-FFA500?style=flat)



## 🔠 목차  

1. [📄 API 명세서](#-api-명세서)
2. [💿 ERD](#-erd)
3. [❓ 패키지 설명](#-패키지-설명)
4. [▶️ 실행방법](#️-실행방법)
5. [🛠 기능 요약](#-기능-요약)
6. [📂 디렉토리 구조](#-디렉토리-구조)



# 📄 API 명세서
<img width="992" alt="스크린샷 2025-05-09 오전 9 51 55" src="https://github.com/user-attachments/assets/db50a17c-5331-458f-9377-a43157f98416" />
<img width="992" alt="스크린샷 2025-05-09 오전 9 52 07" src="https://github.com/user-attachments/assets/5f7c8b5d-79d4-4086-a18c-69bb611825d2" />
<img width="996" alt="스크린샷 2025-05-09 오전 9 52 14" src="https://github.com/user-attachments/assets/764e0eb9-97aa-4c00-981c-6fa166a292bd" />


# 💿 ERD
<img width="810" alt="스크린샷 2025-05-09 오전 9 49 18" src="https://github.com/user-attachments/assets/474ea5f7-3b9f-4f22-bb24-fb0b3785cc75" />




# ❓ 패키지 설명
## 1. Entity(BaseEntity, Todo, Member, Comment, Reply)
- BaseEntity는 작성일, 수정일을 위한 클래스입니다.
- Member는 회원, Todo는 일정, Comment는 댓글, Reply는 대댓글을 의미합니다.

 ## 2. Dto
- Entity를 기반으로 실제 데이터가 이동될 때 사용되는 클래스입니다.
- Request와 Response로 구분하였습니다.
  
 ## 3. Controller
- 사용자에게 요청을 받고 결과값을 넘겨주는 역할을 하는 클래스입니다.
- 요청받은 데이터를 Service에 넘겨주고 데이터를 전달받습니다.
  
 ## 4. Service
- DB에 조회하기 전과 후에 비즈니스 로직을 작성하는 클래스입니다.
- 요청을 가공하여 Repository에 넘겨주고 전달받습니다.

 ## 5. Repository
- JPA의 기본기능을 사용하는 인터페이스입니다.


# ▶️ 실행방법

1. src.main.java.org.example.schedule.TodoV2Application.java 파일을 열어 Spring Boot를 실행시킵니다.
2. start된 걸 확인한 후 Postman을 통해 검증합니다.

# 🛠 기능 요약

- 회원 생성
- 일정 CRUD, 댓글 CRUD, 대댓글 CRUD


# 📂 디렉토리 구조  
```java
└── src
    ├── main
    │   ├── java
    │   │   └── org
    │   │       └── example
    │   │           └── todov2
    │   │               ├── common
    │   │               └── domain
    │   │                   ├── comment
    │   │                   │   ├── controller
    │   │                   │   ├── dto
    │   │                   │   │   ├── request
    │   │                   │   │   └── response
    │   │                   │   ├── entity
    │   │                   │   ├── repository
    │   │                   │   └── service
    │   │                   ├── member
    │   │                   │   ├── controller
    │   │                   │   ├── dto
    │   │                   │   │   ├── request
    │   │                   │   │   └── response
    │   │                   │   ├── entity
    │   │                   │   ├── repository
    │   │                   │   └── service
    │   │                   ├── reply
    │   │                   │   ├── controller
    │   │                   │   ├── dto
    │   │                   │   │   ├── request
    │   │                   │   │   └── response
    │   │                   │   ├── entity
    │   │                   │   ├── repository
    │   │                   │   └── service
    │   │                   └── todo
    │   │                       ├── controller
    │   │                       ├── dto
    │   │                       │   ├── request
    │   │                       │   └── response
    │   │                       ├── entity
    │   │                       ├── repository
    │   │                       └── service
    │   └── resources
    │       ├── static
    │       └── templates
    └── test
        └── java
            └── org
                └── example
                    └── todov2

```
