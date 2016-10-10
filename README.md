# smart
 **프로젝트 수행 지원 시스템**
  
  **project 구조**
	 
	 1. smartpms-parent
		 - maven project 전첵를 담당하고 있는 것으로 라이브러리의 dependency 관리, 빌드 관련 옵션 설정, 자식 maven project 모듈 정의
	 
	 2. smartpms-common
		 -  각  project에서 사용할 공통 클래스가 존재함. 유틸성 클래스 및 Main 기능을 Support 하는 클래스가 존재, 각종 시스템 관련 상수정의
		 	 
	 3. smartpms-core
		 - 데이터 수집, 변환, 판단/결정, 정책정의, Factor 관련된 기능의 클래스가 존재, 분석된 결과를 시스템내/외로 제공하는 기능의 클래스 정의(작업중)
		 
	 4. smartpms-common-web
		 - project 의 공통 웹 모듈로 배포될 대상의 정적인 정보(공통 js, css 등) 및 공통 프레임 영역의 웹 기능을 정의(작업중)
		 
	 5. smartpms-web
		 - project management system의 화면기능을 담고 있는 js 및 html을 정의(작업중)
		 
	 6. smartpms-batch
		 - project management system의 batch 기능을 정의(작업중)

![enter image description here](https://lh3.googleusercontent.com/-bPB9XfOXaA0/V_rpisGRzwI/AAAAAAAAAGA/npXtkYGmGpkMhBYDMTAc-Wt70glRS-DkQCLcB/s0/%25E1%2584%2589%25E1%2585%25B3%25E1%2584%258F%25E1%2585%25B3%25E1%2584%2585%25E1%2585%25B5%25E1%2586%25AB%25E1%2584%2589%25E1%2585%25A3%25E1%2586%25BA+2016-10-10+%25E1%2584%258B%25E1%2585%25A9%25E1%2584%258C%25E1%2585%25A5%25E1%2586%25AB+10.03.36.png "prject-lifecycle.png")
