<?php include 'inc_header.php'; ?>

<main class="p-5 border rounded-5">
   <h1 class="text-center mt-5">회원 약관 및 개인정보 취급방침 동의</h1>
   <h4 class="mt-3">이용약관</h4>
   <textarea name="" id="" cols="30" rows="10" class="form-control">
   Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas autem molestias, molestiae rerum corrupti voluptatibus velit eligendi consequatur! Voluptatibus velit quaerat quo tenetur id animi nemo praesentium ipsa earum obcaecati. Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas autem molestias, molestiae rerum corrupti voluptatibus velit eligendi consequatur! Voluptatibus velit quaerat quo tenetur id animi nemo praesentium ipsa earum obcaecati. Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas autem molestias, molestiae rerum corrupti voluptatibus velit eligendi consequatur! Voluptatibus velit quaerat quo tenetur id animi nemo praesentium ipsa earum obcaecati. Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas autem molestias, molestiae rerum corrupti voluptatibus velit eligendi consequatur! Voluptatibus velit quaerat quo tenetur id animi nemo praesentium ipsa earum obcaecati. Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas autem molestias, molestiae rerum corrupti voluptatibus velit eligendi consequatur! Voluptatibus velit quaerat quo tenetur id animi nemo praesentium ipsa earum obcaecati. Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas autem molestias, molestiae rerum corrupti voluptatibus velit eligendi consequatur! Voluptatibus velit quaerat quo tenetur id animi nemo praesentium ipsa earum obcaecati. Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas autem molestias, molestiae rerum corrupti voluptatibus velit eligendi consequatur! Voluptatibus velit quaerat quo tenetur id animi nemo praesentium ipsa earum obcaecati. Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas autem molestias, molestiae rerum corrupti voluptatibus velit eligendi consequatur! Voluptatibus velit quaerat quo tenetur id animi nemo praesentium ipsa earum obcaecati.</textarea
   >

   <div class="form-check mt-2">
      <input class="form-check-input" type="checkbox" value="" id="chk_register1" />
      <label class="form-check-label" for="chk_register1"> 이용약관 내용에 동의 합니다. </label>
   </div>

   <h4 class="mt-3">개인정보 취급방침</h4>
   <textarea name="" id="" cols="30" rows="10" class="form-control">
   Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas autem molestias, molestiae rerum corrupti voluptatibus velit eligendi consequatur! Voluptatibus velit quaerat quo tenetur id animi nemo praesentium ipsa earum obcaecati. Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas autem molestias, molestiae rerum corrupti voluptatibus velit eligendi consequatur! Voluptatibus velit quaerat quo tenetur id animi nemo praesentium ipsa earum obcaecati. Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas autem molestias, molestiae rerum corrupti voluptatibus velit eligendi consequatur! Voluptatibus velit quaerat quo tenetur id animi nemo praesentium ipsa earum obcaecati. Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas autem molestias, molestiae rerum corrupti voluptatibus velit eligendi consequatur! Voluptatibus velit quaerat quo tenetur id animi nemo praesentium ipsa earum obcaecati. Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas autem molestias, molestiae rerum corrupti voluptatibus velit eligendi consequatur! Voluptatibus velit quaerat quo tenetur id animi nemo praesentium ipsa earum obcaecati. Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas autem molestias, molestiae rerum corrupti voluptatibus velit eligendi consequatur! Voluptatibus velit quaerat quo tenetur id animi nemo praesentium ipsa earum obcaecati. Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas autem molestias, molestiae rerum corrupti voluptatibus velit eligendi consequatur! Voluptatibus velit quaerat quo tenetur id animi nemo praesentium ipsa earum obcaecati. Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas autem molestias, molestiae rerum corrupti voluptatibus velit eligendi consequatur! Voluptatibus velit quaerat quo tenetur id animi nemo praesentium ipsa earum obcaecati.</textarea
   >

   <div class="form-check mt-2">
      <input class="form-check-input" type="checkbox" value="" id="chk_register2" />
      <label class="form-check-label" for="chk_register2"> 개인정보 취급방침에 동의 합니다.</label>
   </div>

   <div class="mt-4 d-flex justify-content-center gap-3">
      <button class="btn btn-primary w-50" id="btn_register">회원가입</button>
      <button class="btn btn-secondary w-50">취소</button>
   </div>

   <form method="post" name="stipluation_form" action="register_input.php" style="display: none">
      <input type="hidden" name="chk" value="0" />
   </form>
</main>


<?php include 'inc_footer.php';?>