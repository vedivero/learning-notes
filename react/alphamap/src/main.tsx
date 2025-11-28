import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.tsx'

// 소스 코드 진입점
createRoot(document.getElementById('root')!).render(
  // dubugging을 위해 두 번씩 실행하는 Strict Mode 삭제
  // <StrictMode>
    <App />
  // </StrictMode>,
)
