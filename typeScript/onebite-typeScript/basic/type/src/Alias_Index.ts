// Type Alas
type User = {
   id?: number;
   name: string;
   birth: string;
   bio: string;
   location: string;
};

// let user: {
//    id?: number;
//    name: string;
//    birth: string;
//    bio: string;
//    location: string;
// } = {
//    id: 1,
//    name: '홍길동',
//    birth: '1999.01.01',
//    bio: '안녕하세요',
//    location: '서울',
// };

let user: User = {
   id: 1,
   name: '홍길동',
   birth: '1999.01.01',
   bio: '안녕하세요',
   location: '서울',
};

// let user2: {
//    id?: number;
//    name: string;
//    birth: string;
//    bio: string;
//    location: string;
// } = {
//    id: 2,
//    name: '임꺽정',
//    birth: '1999.01.01',
//    bio: '안녕하세요',
//    location: '서울',
// };

// 중복되는 타입을 변수로 관리
let user2: User = {
   id: 2,
   name: '임꺽정',
   birth: '1999.01.01',
   bio: '안녕하세요',
   location: '서울',
};

// 객체 타입의 정의를 더 유연하게 해주는 `인덱스 시그니처`
// `인덱스 시그니처` 필요한 상황 가정

type CountryCodes = {
   Korea: string;
   UnitedState: string;
   UnitedKingdom: string;
};

// 전 세계 200여개의 나라를 일일이 선언하는 것은 비 효율적
// 타입과 밸류의 규칙을 추출
type CountryCodes_IndexSignature = {
   [key: string]: string;
};

let countryCodes = {
   Korea: 'ko',
   UnitedState: 'us',
   UnitedKingdom: 'uk',
};

// 예제 2
type CountryNumberCodes = {
   [key: string]: number;
};

let countryNumberCodes: CountryNumberCodes = {
   Korea: 410,
   UnitedState: 840,
   UnitedKingdom: 826,
};

// 예제 3
// 인덱스 시그니처 타입은 규칙을 위반하지만 않는 모든 객체를 허용
// 아래와 같이 빈 객체에 대한 오류가 발생하지 않음
//let countryNumberCodes: CountryNumberCodes = {};

// 예제 4
// 인덱스 시그니처 타입과 일치 시켜야한다.
type CountryNumberAndStringCodes = {
   [key: string]: number;
   //Korea: string;
   Korea: number;
};

let countryNumberAndStringCodes: CountryNumberAndStringCodes = {
   Korea: 410,
};
