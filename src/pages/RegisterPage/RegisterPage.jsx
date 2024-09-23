import React, { useState } from 'react';
import { useForm } from 'react-hook-form';
import { Link } from 'react-router-dom';
import { createUserWithEmailAndPassword, getAuth } from 'firebase/auth';
import app from '../../firebase';

const RegisterPage = () => {
   const auth = getAuth(app);
   //회원가입 제출 시, 다시 버튼을 누르지 못 하게끔
   const [loading, setLoading] = useState(false);
   const [errorFromSubmit, setErrorFromSubmit] = useState('');
   const {
      register,
      watch,
      formState: { errors },
      handleSubmit,
   } = useForm();

   const onSubmit = async (data) => {
      try {
         setLoading(true);
         const createdUser = await createUserWithEmailAndPassword(
            auth,
            data.email,
            data.password,
         );
         console.log(createdUser);
      } catch (error) {
         console.log(error);
         setErrorFromSubmit(error.message);
         setTimeout(() => {
            setErrorFromSubmit('');
         });
      } finally {
         setLoading(false);
      }
   };

   return (
      <div className='auth-wrapper'>
         <div style={{ textAlign: 'center' }}>
            <h3>Register</h3>
         </div>
         <form onSubmit={handleSubmit(onSubmit)}>
            <label>Email</label>
            <input
               name='email'
               type='email'
               id='email'
               {...register('email', { required: true, pattern: /^\S+@\S+$/i })}
            />
            {errors.email && <p>이메일을 입력해 주세요.</p>}
            <label htmlFor='name'>Name</label>
            <input
               name='name'
               type='name'
               id='name'
               {...register('name', { required: true, maxLength: 10 })}
            />
            {errors.name && errors.name.type === 'required' && (
               <p>이름을 입력해 주세요.</p>
            )}
            {errors.name && errors.name.type === 'maxLength' && (
               <p>최대 입력 길이를 초과했습니다.</p>
            )}
            <label>Password</label>
            <input
               name='password'
               type='password'
               id='password'
               {...register('password', { required: true, minLength: 6 })}
            />
            {errors.password && errors.password.type === 'required' && (
               <p>비밀번호를 입력해 주세요.</p>
            )}
            {errors.password && errors.password.type === 'maxLength' && (
               <p>최소 6자리 이상 입력해 주세요.</p>
            )}

            {errorFromSubmit && <p>{errorFromSubmit}</p>}

            <input type='submit' />
            <Link style={{ color: 'gray', textDecoration: 'none' }} to='/login'>
               이미 아이디가 있다면...{' '}
            </Link>
         </form>
      </div>
   );
};

export default RegisterPage;
