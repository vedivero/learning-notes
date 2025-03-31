let nextId = 0;
let todos = [{ id: nextId++, text: 'Todo #1' }]; // 외부의 컴포넌트에서 읽을 수 있는 상태에 대한 데이터

let listeners = []; // 상태가 변경되면 변경을 알릴 수 있는 콜백함수들을 저장할 배열

export const ToDoListStore = {
   subscribe(listener) {
      listeners = [...listeners, listener];

      return () => {
         listeners = listeners.filter((l) => l !== listener);
      };
   },

   getSnapshot() {
      return todos;
   },

   addTodo(text) {
      todos = [...todos, { id: nextId++, text }];
      emitChange();
   },
};
function emitChange() {
   for (let listener of listeners) {
      listener();
   }
}
