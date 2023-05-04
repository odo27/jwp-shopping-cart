# jwp-shopping-cart

## 기능목록

- [x] 상품 목록 페이지 연동
    - [x] index.html 변경
- [x] 상품 관리 CRUD API 작성
    - [x] create product
    - [x] read product
    - [x] update product
    - [x] delete product
- [x] 관리자 도구 페이지 연동
    - [x] admin.html 변경
    - [x] admin.js 변경

- [x] DB 설계

- [x] 사용자 기능 구현
    - [x] email
    - [x] password
- [x] 사용자 설정 페이지 연동
    - [x] settings.html, settings.js 파일 내 TODO 주석을 참고하여 설계한 사용자 정보에 맞게 코드를 변경
    - [x] settings.html 파일을 이용해서 사용자를 선택하는 기능
    - [x] /settings url로 접근할 경우 모든 사용자의 정보를 확인하고 사용자를 선택하는 기능
    - [x] 사용자 설정 페이지에서 사용자를 선택하면, 이후 요청에 선택한 사용자의 인증 정보가 포함되는 기능
- [x] 장바구니 기능 구현
    - [x] 어떤 사용자의 장바구니에 상품을 추가하거나 제거할 것인지에 대한 정보는 Basic Auth를 이용하여 인증
    - [x] 장바구니에 상품 추가
    - [x] 장바구니에 담긴 상품 제거
    - [x] 장바구니 목록 조회
    - [x] 사용자 정보는 요청 Header의 Authorization 필드를 사용해 인증 처리하기
    - [x] 인증 방식은 Basic 인증을 사용하기
- [x] 장바구니 페이지 연동
    - [x] cart.html, cart.js 파일 내 TODO 주석을 참고하여 설계한 장바구니 정보에 맞게 코드를 변경
    - [x] 1단계에서 구현한 상품 목록 페이지(/)에서 담기 버튼을 통해 상품을 장바구니에 추가하는 기능
    - [x] cart.html 파일과 장바구니 관련 API를 이용하여 장바구니 페이지를 완성하기
    - [x] /cart url로 접근할 경우 장바구니 페이지를 조회할 수 있어야 합니다.
    - [x] 장바구니 목록을 확인하고 상품을 제거하는 기능을 동작하게 만들기
