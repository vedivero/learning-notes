//Date객체를 문자열로 변환하는 함수
export const getStringedDate = (targetDate) => {
   //"YYYY-MM-DD"
   let year = targetDate.getFullYear();
   let month = targetDate.getMonth() + 1;
   let date = targetDate.getDate();

   //10이하의 숫자 처리 (1 -> 01)
   if (month < 10) {
      month = `0${month}`;
   }
   if (date < 10) {
      date = `0${date}`;
   }

   return `${year}-${month}-${date}`;
};
