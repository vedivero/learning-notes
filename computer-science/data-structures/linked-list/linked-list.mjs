//1. 모든 데이터 출력

//2. 모든 데이터 제거

//3. 인덱스 삽입

//4. 마지막 삽입

//5. 인덱스 삭제

//6. 마지막 인덱스 삭제

//7. 인덱스 읽기

//연결리스트는 데이터를 담은 노드를 서로 연결하는 구조
//node라는 이름의 클래스 생성
class Node {
   constructor(data, next = null) {
      //variable of class = property
      this.data = data;
      this.next = next;
   }
}

class LinkedList {
   constructor() {
      this.head = null;
      this.count = 0;
   }

   //모든 요소 출력
   printAll() {
      let currentNode = this.head;
      let text = '[ ';

      while (currentNode !== null) {
         text += currentNode.data;
         currentNode = currentNode.next;

         if (currentNode !== null) text += ', ';
      }
      text += ' ]';
      console.log(text);
   }

   //모든 요소 제거
   clear() {
      this.head = null;
      this.count = 0;
   }

   //원하는 인덱스에 data 삽일
   insertAt(index, data) {
      //예외 처리(1.연결리스트 크기보다 큰 곳에 삽입하는 경우, 2. 음수위치 삽입하는 경우)
      if (index > this.count || index < 0) {
         throw new Error('insertAt() - 범위를 벗어났습니다');
      }

      //매개변수 data를 Node의 생성자로 전달해, Node의 data설정
      let newNode = new Node(data);

      //1. 새로 삽입하는 노드가 헤드 노드가 되는 경우
      if (index === 0) {
         //새로 생성한 Node가 현재의 head를 가리키도록
         newNode.next = this.head;
         //새로 생성한 Node를 head로 설정
         this.head = newNode;
      } else {
         //2. 그 외의 나머지 경우 (head부터 원하는 index까지 이동)

         //head부터 이동하기 때문에 head로 초기화
         let currentNode = this.head;

         //목표 index까지 currentNode를 이동
         //목표 : n -> n-1까지 접근(index - 1)
         for (let i = 0; i < index - 1; i++) {
            currentNode = currentNode.next;
         }
         //새로운 Node가 현재 Node(n-1)의 다음 Node를 가리키도록 설정
         newNode.next = currentNode.next;
         //현재 Node(n-1)의 다음 Node를 새로운 Node를 가리키도록 설정
         currentNode.next = newNode;
      }
      this.count++;
   }

   //마지막 노드에 data 삽입
   insertLast(data) {
      this.insertAt(this.count, data);
   }

   //노드 삭제 함수
   deleteAt(index) {
      //list범위인지 체크
      if (index > this.index || index < 0)
         throw new Error('노드를 제거할 수 없습니다.');

      let currentNode = this.head;
      //1. head를 제거하는 경우
      if (index === 0) {
         let deletedNode = this.head;
         this.head = this.head.next;
         this.count--;
         return deletedNode;
      } else {
         //2. 그 외의 노드를 제거하는 경우

         //제거할 Node이전까지 순회
         for (let i = 0; i < index - 1; i++) {
            //삭제할 Node 이전까지 이동
            currentNode = currentNode.next;
         }
         //이동된 Node의 다음 Node를 삭제할 Node로 설정
         let deletedNode = currentNode.next;
         //이동된 Node의 다음 Node를 삭제할 Node의 다,다음 Node로 설정
         currentNode.next = currentNode.next.next;
         //삭제되었으니 Node의 길이를 감소
         this.count--;
         return deletedNode;
      }
   }

   //마지막 Node 제거
   deleteLast() {
      return this.deleteAt(this.count - 1);
   }

   getNodeAt(index) {
      if (index >= this.count || index < 0) {
         throw Error('getNodeAt() - 범위를 벗어났습니다.');
      }
      let currentNode = this.head;
      for (let i = 0; i < index; i++) {
         currentNode = currentNode.next;
      }
      return currentNode;
   }
}

export { Node, LinkedList };
