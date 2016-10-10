# smart
프로젝트 수행 지원 시스템
  
  # project 구조
  
  1.smartpms-parent : maven project 전첵를 담당하고 있는 것으로 라이브러리의 dependency 관리, 빌드 관련 옵션 설정, 자식 maven project 모듈 정의
    
  2.smartpms-common : 각  project에서 사용할 공통 클래스가 존재함. 유틸성 클래스 및 Main 기능을 Support 하는 클래스가 존재, 각종 시스템 관련 상수정의
  
  3.smartpms-core : 데이터 수집, 변환, 판단/결정, 정책정의, Factor 관련된 기능의 클래스가 존재, 분석된 결과를 시스템내/외로 제공하는 기능의 클래스 정의
  
  4.smartpms-common-web : project 의 공통 웹 모듈로 배포될 대상의 정적인 정보(공통 js, css 등) 및 공통 프레임 영역의 웹 기능을 정의
  
  5.smartpms-web : project management system의 화면기능을 담고 있는 js 및 html을 정의(미정의)
  
  6.smartpms-batch : project management system의 batch 기능을 정의(미정의)
