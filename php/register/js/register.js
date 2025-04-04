document.addEventListener('DOMContentLoaded', () => {
   const btn_register = document.querySelector('#btn_register');

   btn_register.addEventListener('click', () => {
      const chk_register1 = document.querySelector('#chk_register1');
      if (chk_register1.checked !== true) {
         alert('이용 약관에 동의 후, 회원 가입이 가능합니다.');
         return false;
      }
      const chk_register2 = document.querySelector('#chk_register2');
      if (chk_register2.checked !== true) {
         alert('개인정보 취급 방침 동의 후, 회원 가입이 가능합니다.');
         return false;
      }

      const f = document.stipluation_form;
      f.chk.value = 1;
      f.submit();

      self.location.href = './register_input.php';
   });
});
