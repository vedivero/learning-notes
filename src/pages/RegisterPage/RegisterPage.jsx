import React from 'react';
import { Link } from 'react-router-dom';

const RegisterPage = () => {
   return (
      <div className='auth-wrapper'>
         <div style={{ textAlign: 'center' }}>
            <h3>Register</h3>
         </div>
         <form>
            <label>Email</label>
            <input name='email' type='email' id='email' />
            <label htmlFor='name'>Name</label>
            <input name='name' type='name' id='name' />
            <label>Password</label>
            <input name='password' type='password' id='password' />
            <input type='submit' disabled />
            <Link
               style={{ color: 'gray', TextDecoration: 'none' }}
               to={'/login'}
            >
               이미 아이디가 있다면...
            </Link>
         </form>
      </div>
   );
};

export default RegisterPage;
