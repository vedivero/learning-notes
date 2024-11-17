import { LinkedList } from '../linked-list/linked-list.mjs';

class Stack {
   constructor() {
      this.list = new LinkedList();
   }

   //연결리스트의 head Node에만 data가 십입되도록 설정
   push(data) {
      this.list.insertAt(0, data);
   }

   //head Node제거
   //head Node = 가장 최근에 삽입된 Node
   pop() {
      try {
         return this.list.deleteAt(0);
      } catch (error) {
         return null;
      }
   }

   //데이터 참조
   peek() {
      return this.list.getNodeAt(0);
   }

   //stack이 비어있는지 체크
   isEmpty() {
      return this.list.count === 0;
   }
}

//외부 파일에서 Stack을 참조할 수 있도록 export
export { Stack };
