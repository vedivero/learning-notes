import { Node, LinkedList } from './linked-list.mjs';

let node1 = new Node(1);
let node2 = new Node(2);
let node3 = new Node(3);

node1.next = node2;
node2.next = node3;

console.log(node1.data);
console.log(node1.next.data);
console.log(node1.next.next.data);

//연결리스트 인스턴스화(객체 생성)

let list = new LinkedList();
console.log(`==========`);
console.log(`insertAt() 함수 호출`);

//5개의 샘플 데이터 삽입
list.insertAt(0, 0);
list.insertAt(1, 1);
list.insertAt(2, 2);
list.insertAt(3, 3);
list.insertAt(4, 4);
list.printAll();

console.log(`==========`);
console.log(`clear() 함수 호출`);

list.clear();
list.printAll();

console.log(`==========`);
console.log(`insertLast() 함수 호출`);

list.insertLast(0);
list.insertLast(1);
list.insertLast(2);
list.insertLast(3);
list.printAll();

console.log(`==========`);
console.log(`delete() 함수 호출`);

list.deleteAt(0);
list.printAll();
list.deleteAt(1);
list.printAll();

console.log(`==========`);
console.log(`deleteLast() 함수 호출`);

list.deleteLast();
list.deleteLast();
list.printAll();

console.log(`==========`);
console.log(`getNodeAt() 함수 호출`);

list.insertAt(0, 0);
list.insertAt(1, 1);
list.insertAt(2, 2);
list.insertAt(3, 3);
list.insertAt(4, 4);
list.insertAt(5, 5);

let findNode = list.getNodeAt(2);
console.log(findNode);
