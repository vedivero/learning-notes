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

# React + Vite

This template provides a minimal setup to get React working in Vite with HMR and some ESLint rules.

Currently, two official plugins are available:

-  [@vitejs/plugin-react](https://github.com/vitejs/vite-plugin-react/blob/main/packages/plugin-react/README.md) uses [Babel](https://babeljs.io/) for Fast Refresh
-  [@vitejs/plugin-react-swc](https://github.com/vitejs/vite-plugin-react-swc) uses [SWC](https://swc.rs/) for Fast Refresh

## Expanding the ESLint configuration

If you are developing a production application, we recommend using TypeScript and enable type-aware lint rules. Check out the [TS template](https://github.com/vitejs/vite/tree/main/packages/create-vite/template-react-ts) to integrate TypeScript and [`typescript-eslint`](https://typescript-eslint.io) in your project.
