import { useSyncExternalStore } from 'react';
import { ToDoListStore } from './ToDoListStore';

function ToDoListCount() {
   console.log('RENDING ToDoListCount');

   const toDoList = useSyncExternalStore(ToDoListStore.subscribe, ToDoListStore.getSnapshot);

   return (
      <>
         <p>ToDo Count: {toDoList.length}</p>
      </>
   );
}

export default ToDoListCount;
