import './App.css';
import {
   useReducer,
   useRef,
   createContext,
   useEffect,
   useState,
} from 'react';
import { Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import Diary from './pages/Diary';
import New from './pages/New';
import Edit from './pages/Edit';
import Notfound from './pages/Notfound';

function reducer(state, action) {
   let nextState;

   switch (action.type) {
      case 'INIT':
         return action.data;
      case 'CREATE': {
         nextState = [action.data, ...state]; //원본 데이터 복사 후, dispatch로 전달한 액션객체를 새로운 state로 설정
         break;
      }
      case 'UPDATE': {
         //id에 해당하는 요소만 수정
         nextState = state.map((item) =>
            String(item.id) === String(action.data.id)
               ? action.data
               : item,
         );
         break;
      }
      case 'DELETE': {
         nextState = state.filter(
            (item) => String(item.id) !== String(action.id),
         );
         break;
      }
      default:
         return state;
   }
   //일기가 생성, 삭제, 수정될 때 마다, 일기 데이터를 로컬 스토리지에 저장
   localStorage.setItem('diary', JSON.stringify(nextState));
   return nextState;
}

export const DiaryStateContext = createContext(); //추가, 수정, 삭제 함수를 `Context`를 통해 App컴포넌트 하위 컴포넌트에 전달
export const DiaryDispatchContext = createContext(); //Data State의 값을 변경하는 함수들을 `Context`를 통해 공급

function App() {
   const [isLoading, setIsLoading] = useState(true); //App컴포넌트의 로딩 상태를 보관하는 state
   const [data, dispatch] = useReducer(reducer, []); //일기 데이터를 관리하는 state
   const idRef = useRef(0); //생성될 일기 아이템의 ID값 저장

   useEffect(() => {
      //App 컴포넌트가 마운트될 때, 로컬 스토리지에서 데이터 불러오기
      const storedData = localStorage.getItem('diary');
      if (!storedData) {
         setIsLoading(false);
         return;
      }

      const parsedData = JSON.parse(storedData);
      if (!Array.isArray(parsedData)) {
         //parsedData값이 배열이 아닐 경우 예외 처리
         setIsLoading(false);
         return;
      }

      let maxId = 0; //useRef에 인수로 넣을 새 글 번호 최대값으로 설정
      parsedData.forEach((item) => {
         if (Number(item.id) > maxId) {
            maxId = item.id;
         }
      });

      idRef.current = maxId + 1;

      dispatch({
         type: 'INIT',
         data: parsedData,
      });
      setIsLoading(false); //컴포넌트가 마운트 됐을 때 한번 만 실행하도록
   }, []);

   // 새로운 일기 추가
   const onCreate = (createdDate, emotionId, content) => {
      dispatch({
         type: 'CREATE',
         data: {
            id: idRef.current++,
            createdDate,
            emotionId,
            content,
         },
      });
   };

   // 기존 일기 수정
   const onUpdate = (
      id,
      createdDate,
      emotionId,
      content,
   ) => {
      dispatch({
         type: 'UPDATE',
         data: {
            id,
            createdDate,
            emotionId,
            content,
         },
      });
   };

   // 기존 일기 삭제
   const onDelete = (id) => {
      dispatch({
         type: 'DELETE',
         id,
      });
   };

   if (isLoading) {
      return <div>데이터 로딩중입니다 ...</div>;
   }

   return (
      <>
         <DiaryStateContext.Provider value={data}>
            <DiaryDispatchContext.Provider
               value={{
                  onCreate,
                  onUpdate,
                  onDelete,
               }}
            >
               <Routes>
                  <Route path='/' element={<Home />} />
                  <Route path='/new' element={<New />} />
                  <Route
                     path='/diary/:id'
                     element={<Diary />}
                  />
                  <Route
                     path='/edit/:id'
                     element={<Edit />}
                  />
                  <Route path='*' element={<Notfound />} />
               </Routes>
            </DiaryDispatchContext.Provider>
         </DiaryStateContext.Provider>
      </>
   );
}

export default App;
