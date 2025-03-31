import { useSyncExternalStore } from 'react';
import { ToDoListStore } from './ToDoListStore';

function ToDoListView() {
   console.log('RENDING ToDoListView');
   const toDoList = useSyncExternalStore(ToDoListStore.subscribe, ToDoListStore.getSnapshot);

   return (
      <ul>
         {toDoList.map((todo) => (
            <li key={todo.id}>{todo.text}</li>
         ))}
      </ul>
   );
}

export default ToDoListView;
