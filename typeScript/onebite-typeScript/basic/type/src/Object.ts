//Object
//let user: Object = {
let user: {
   // Specify the type all Property
   id?: number;
   name: string;
} = {
   id: 1,
   name: '홍길동',
};

// user.id; //Object 형식에 id속성이 없습니다.

//객체를 이루고 있는 속성의 구조를 기준으로 타입을 정의
//구조적 타입 시스템
//Propperty Based Type System
let dog: {
   name: string;
   color: string;
} = {
   name: '댕댕이',
   color: 'white',
};

console.log(user, dog);
// <> 이름을 기준으로하는 명목적 타입 시스템

// ID는 모르는 경우, 옵셔널 프로퍼티 타입으로 변경
// id: number -> id?: number
user = {
   name: '임꺽정',
};

let config: {
   readonly apiKey: string;
} = {
   apiKey: 'MyKey',
};

// 읽기 전용 속성이므로 'apiKey'에 할당할 수 없습니다.
// config.apiKey = 'anotherKey';
