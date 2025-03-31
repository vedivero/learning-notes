import { useRef } from 'react';
import { ToDoListStore } from './ToDoListStore';
import ToDoListView from './ToDoListView';
import ToDoListCount from './ToDoListCount';
import ToDoListCountConsole from './ToDoListCountConsole';

export default function App() {
   console.log('RENDING APP');
   const input = useRef();

   return (
      <>
         <input ref={input} />
         <button
            onClick={() => {
               ToDoListStore.addTodo(input.current.value);
            }}
         >
            +
         </button>
         <ToDoListView />
         <ToDoListCount />
         <ToDoListCountConsole />
      </>
   );
}
