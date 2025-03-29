![alt text](image.png)

## ✅ 리액트란?

-  React는 웹 어플리케이션 개발을 위한 라이브러리
-  웹 프론트엔드 개발 라이브러리 중 많이 사용
-  컴포넌트 중심의 개발 방식을 추구
-  컴포넌트들을 조합하여 하나의 웹 어플리케이션을 만듦

## ✅ 리액트 구조

-  node_modules

   -  개발에 필요한 패키지 (또는 라이브러리)들이 설치된 폴더

-  public

   -  웹 서버가 호스팅하는 홈 폴더

-  src

   -  소스 코드 파일이 존재하는 폴더

-  index.html

   -  홈 페이지 파일로 시작할때 처음 뜨는 페이지

## ✅ JSX란?

-  JavaScript를 확장한 문법
-  파일 하나에 JS 코드와 HTML Tag 요소를 함께 작성

## ✅ Root DOM

-  컴포넌트가 렌더링되는 최상위 DOM

## ✅ Virtual DOM (가상 돔)이란?

-  리액트는 웹 브라우저의 DOM 구조와 동일한 **가상 DOM(Virtual DOM)** 을 메모리에 생성
-  컴포넌트가 새롭게 렌더링될 때, 변경된 내용을 **가상 DOM과 실제 DOM을 비교(Diffing)** 하여 **변경된 부분만 실제 DOM에 반영(최소 업데이트)**
-  이를 통해 웹 브라우저는 **불필요한 전체 DOM 업데이트 없이**, **변경된 부분만 효율적으로 렌더링**하여 **성능을 최적화**

## ✅ 컴포넌트(Component)

-  **재사용 가능한 UI의 기본 구성 단위**로, 여러 컴포넌트를 조합하여 하나의 웹 애플리케이션을 만들 수 있음
-  **HTML 관점에서** 보면, 리액트 컴포넌트는 사용자 정의 태그처럼 동작함
-  **컴포넌트 개발**은 **함수형**과 **클래스형** 방식으로 가능하며, 현재는 **함수형 컴포넌트**가 더 많이 사용됨

## ✅ Props

-  Props는 컴포넌트에 데이터를 전달할 때 사용한다.
-  전달받은 props는 **읽기 전용**이며, 직접 수정하면 안 된다.
-  값이 변경되어야 한다면 props가 아닌 **state로 관리**해야 한다.

## ✅ 이벤트(Event)

-  이벤트 이름은 `on` + 카멜케이스(CamelCase) 형식으로 작성한다.  
   예: `onClick`, `onChange`, `onSubmit`

   ### 🧩 사용자 정의 이벤트

   -  사용자 정의 이벤트는 **props로 함수를 전달**하고,  
      자식 컴포넌트에서 **전달받은 함수를 호출**하는 방식으로 구현한다.

## ✅ Hook(훅)이란?

-  함수형 컴포넌트에서 **상태(state)**, **생명주기(lifecycle)** 등을 관리하기 위한 **React의 내장 API**
-  더 나은 컴포넌트 개발을 위한 기능을 제공

### 🔧 주요 Hook API

-  `useState`, `useEffect`, `useRef`, `useMemo`, `useCallback` 등

### ⚠️ 사용 시 주의사항

-  Hook의 **호출 순서는 항상 동일해야** 하며, 이를 기반으로 내부적으로 상태를 구분
-  Hook은 **반복문, 조건문, 중첩 함수 내에서 호출하면 안 된다.**

## ✅ useState Hook

-  `useState`는 컴포넌트에서 **변경 가능한 상태(state)**를 관리할 때 사용하는 Hook

### 🧩 상태(State)란?

-  컴포넌트 내부에서 **변경될 수 있는 값**을 의미
-  상태가 변경되면 해당 컴포넌트는 **자동으로 다시 렌더링**

### 🔄 Props와의 차이

-  Props는 **부모 컴포넌트로부터 전달된 값**으로, 자식 컴포넌트 내부에서 \*\*직접 변경하지 않음.
-  반면, State는 **컴포넌트 내부에서 선언하고 변경**할 수 있음

## ✅ useEffect

![alt text](image-2.png)

## Mounting

컴포넌트가 웹 브라우저에 처음 추가되어 렌더링될 때 발생합니다.

## Updating

컴포넌트가 상태(state)나 속성(props)의 변경으로 인해 다시 렌더링될 때 발생합니다.

## Unmounting

컴포넌트가 웹 브라우저에서 제거될 때 발생합니다.

---

## useEffect Hook

-  컴포넌트가 Mounting, Updating, Unmounting 될 때 특정 작업을 실행하기 위해 사용
-  첫 번째 인자는 실행할 작업을 담은 함수이며, useEffect의 콜백 함수
-  두 번째 인자는 의존성 배열(Dependency Array)

### 동작 방식

-  의존성 배열을 **지정하지 않으면**, 컴포넌트가 업데이트될 때 마다 useEffect의 콜백 함수가 호출
-  의존성 배열을 **빈 배열([])** 로 지정하면, 컴포넌트가 마운트될 때 한 번만 useEffect의 콜백 함수가 호출
-  useEffect의 콜백 함수 내에서 **정리 함수(return 함수)** 를 작성하면, 컴포넌트가 Unmounting 될 때 해당 작업이 실행

<br>
<br>
<br>
<br>
<br>

# React + Vite

This template provides a minimal setup to get React working in Vite with HMR and some ESLint rules.

Currently, two official plugins are available:

-  [@vitejs/plugin-react](https://github.com/vitejs/vite-plugin-react/blob/main/packages/plugin-react/README.md) uses [Babel](https://babeljs.io/) for Fast Refresh
-  [@vitejs/plugin-react-swc](https://github.com/vitejs/vite-plugin-react-swc) uses [SWC](https://swc.rs/) for Fast Refresh

## Expanding the ESLint configuration

If you are developing a production application, we recommend using TypeScript and enable type-aware lint rules. Check out the [TS template](https://github.com/vitejs/vite/tree/main/packages/create-vite/template-react-ts) to integrate TypeScript and [`typescript-eslint`](https://typescript-eslint.io) in your project.
