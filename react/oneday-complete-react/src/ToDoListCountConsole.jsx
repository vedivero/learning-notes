import { useEffect } from 'react';
import { ToDoListStore } from './ToDoListStore';

function ToDoListCountConsole() {
   console.log('RENDING ToDoListCountConsole');
   useEffect(() => {
      ToDoListStore.subscribe(() => {
         const toDoList = ToDoListStore.getSnapshot();
         console.log(`toDoList count: ${toDoList.length}`);
      });
   }, []);

   return <span>See Console</span>;
}

export default ToDoListCountConsole;
