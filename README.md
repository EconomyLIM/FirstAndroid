# App Name : MoaMoa
다양한 기능들을 모두 모아 많은 기능들을 한번에 이용할 수 있는 어플을 기획했습니다. 
### 언어: Java jdk11

### Tool: Android Studio

### 1. 초안
<img width="465" alt="디자인 초안" src="https://github.com/EconomyLIM/FirstAndroid/assets/119987898/3d8902b9-23e2-433c-80d3-1190c6a6a4f5">


먼저 초안입니다. 
남녀노소 사용할 수 있게 간단하고 직관적인 디자인으로 설계 했습니다.

### 2. 프로그램 동작 방식 및 시연 사진

## 2-1. 로그인 화면 
<img width="465" alt="로그인 화면" src="https://github.com/EconomyLIM/FirstAndroid/assets/119987898/2b605a95-ae5f-4aa4-9db7-ae1fe7ea4d07">
<img width="465" alt="로그인 화면" src="https://github.com/EconomyLIM/FirstAndroid/assets/119987898/ef6214e1-b03f-4c90-82a2-8e7d7a6d0b4c">

먼저 로그인 화면입니다. ‘안녕하세요!’ 라는 말(텍스트뷰)과 ‘구글로 로그인하기’라는 말(텍스트뷰)을 배치했고 ‘구글로그인 버튼’(구글 버튼)을 추가해 구글로 로그인 할 수 있게 만들었습니다. <br>
‘구글 파이어 베이스’에서 로그인 정보API를 얻어와 구글로 로그인 할 수 있게 했습니다. ‘REQ_SIGN_GOOGLE’라는 int 변수를 하나 선언해줍니다. 그리고 Intent를 선언해 Google Login의 정보를 가져옵니다. <br>
onActivityResult는 쉽게 말씀드리면 로그인 성공 시 반환된 데이터 Intent에서 Google SignAccount를 가져오기 위해 만든 메소드입니다. <br>
result라는 변수를 선언해 Google SignAccount를 저장해주고 isSuccess()라는 함수를 사용해 로그인이 성공하면 account에 저장, 메소드 실행 하라는 명령문을 넣었습니다 <br>





