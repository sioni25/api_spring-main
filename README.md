 # [신한DS] (공부용) 리액트+스프링부트 연동한 답변게시판/댓글 프로젝트 소스코드

## API 연동 B/E 실습(스프링부트)
## F/E는 api_react

- 스프링부트를 사용한 답변 게시판 B/E 개발
- DB : MySQL
- 데이터 : react_reply.sql

이 프로젝트는 Spring Boot 기반의 백엔드 API 프로젝트이며, React 관련 기능을 포함하고 있다.

[프로젝트 개요]

- 프로젝트명: api_spring-main
- 빌드 시스템: Gradle (build.gradle, settings.gradle 존재)
- 백엔드 프레임워크: Spring Boot
- 데이터베이스: SQL 기반 (react_reply.sql 파일 존재)
- 보안 기능: JWT 기반 인증 (JWTUtil, ApiLoginFilter 등 보안 관련 클래스 존재)
- 테스트 코드 포함: test/java/react/reply/security 내 JUnit 테스트 파일 존재

[프로젝트 특징]

1. Spring Boot + JPA 사용: CommentRepository, ReplyRepository, ApiUserRepository가 존재하며, Spring Data JPA 기반으로 데이터베이스를 다룸.

2. JWT 인증 시스템: JWTUtil, ApiLoginFilter, SecurityConfig 등을 통해 인증 및 보안 처리를 담당.

3. 테스트 코드 포함: JWT, 답글 기능 등에 대한 테스트 코드가 존재하여 신뢰성 높은 애플리케이션 개발 가능.

4. SQL 초기화 파일 포함: react_reply.sql을 통해 데이터베이스 초기화 가능.

5. Gradle 기반 프로젝트: build.gradle, settings.gradle이 존재하여 Gradle로 프로젝트를 관리.

[폴더 구조 분석]
** src/main/java/react (주요 백엔드 코드) **

    1. comment (댓글 관련 기능)
        ㄴ CommentController: 댓글 API 컨트롤러
        ㄴ CommentEntity: 댓글 엔티티
        ㄴ CommentRepository: 댓글 데이터 접근 레이어 (JPA)

    2. reply (답글 관련 기능)
        ㄴ ReplyController: 답글 API 컨트롤러
        ㄴ ReplyEntity: 답글 엔티티
        ㄴ ReplyRepository: 답글 데이터 접근 레이어 (JPA)

    3. security (보안 및 인증 기능)
        ㄴ AccessTokenException: 인증 예외 처리 클래스
        ㄴ ApiLoginFilter: 로그인 필터 (JWT 인증 로직)
        ㄴ APIloginSuccessHandler: 로그인 성공 핸들러
        ㄴ ApiUser: 사용자 엔티티
        ㄴ ApiUserDetailsService: 사용자 인증 서비스
        ㄴ ApiUserDTO: 사용자 DTO (Data Transfer Object)
        ㄴ ApiUserRepository: 사용자 데이터 접근 레이어
        ㄴ JWTUtil: JWT 토큰 생성 및 검증 유틸리티
        ㄴ SecurityConfig: Spring Security 설정 파일
        ㄴ TokenCheckFilter: JWT 토큰 검증 필터

    4. user (사용자 관리)
        ㄴ UserEntity: 사용자 엔티티

    5. util (유틸리티 기능)
        ㄴ Download: 파일 다운로드 관련 기능
        ㄴ PageMaker, PageVO: 페이징 처리 관련 클래스

    6. ReactReplyApplication (메인 애플리케이션 클래스)
        ㄴ Spring Boot 애플리케이션 실행 진입점

** src/test/java/react/reply/security (테스트 코드) **
ㄴ JwtTest: JWT 관련 기능 테스트
ㄴ ReactReplyApplicationTests: 통합 테스트
ㄴ ReplyTest: 답글 기능 테스트
