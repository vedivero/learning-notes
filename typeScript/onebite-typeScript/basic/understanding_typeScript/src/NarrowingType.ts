/**
 * 타입 좁히기
 *
 * 조건문 등을 이용해
 * 넓은 타입에서 좁은 타입으로
 * 타입을 상황에 따라 좁히는 방법
 */
type Person = {
   name: string;
   age: number;
};

// 함수의 매개 변수의 타입을 union 타입으로 정의
// 매개 변수에 따라 return을 분기
// number => toFixed
// string => toUpperCase
function func(value: number | string | Date | null | Person) {
   //이렇게는 사용 불가
   //value.toUpperCase();
   //value.toFixed();

   // 조건문에서만 사용
   // 중괄호 안에서는 타입의 범위가 좁아짐
   // 조건문에 해당하는 타입으로 한정
   // Type Guard
   // 조건에 맞는 타입외에는 처리되지 않도록
   if (typeof value === 'number') {
      console.log(value.toFixed());
   } else if (typeof value === 'string') {
      console.log(value.toUpperCase());
   }
   //Js는 null도 object로 처리
   //Date와 null, 둘 다 통과
   //getTime()에 null을 사용할 수 없어 오류 발생
   //else if (typeof value === 'object') {

   //왼쪽의 값이 Date의 객체냐?
   //null은 Date객체가 아님
   //Date Type이 보장됨
   else if (value instanceof Date) {
      console.log(value.getTime());
   }
   // 형식만 참조 = Person은 타입이라는 뜻
   // Person !== Class
   // instanceof는 사용불가
   // in 연산자 사용
   //else if (value instanceof Person) {
   else if (value && 'age' in value) {
      console.log(`${value.name}은 ${value.age}살 입니다.`);
   }
}
