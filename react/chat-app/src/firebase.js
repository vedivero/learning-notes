// Import the functions you need from the SDKs you need
import { initializeApp } from 'firebase/app';
import { getDatabase } from 'firebase/database';
import { getStorage } from 'firebase/storage';
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
const firebaseConfig = {
   apiKey: 'AIzaSyAkM8BiOvkfOHbJzQuVPzge7L6XxYXp0sM',
   authDomain: 'chat-app-38a36.firebaseapp.com',
   databaseURL:
      'https://chat-app-38a36-default-rtdb.asia-southeast1.firebasedatabase.app',
   projectId: 'chat-app-38a36',
   storageBucket: 'chat-app-38a36.appspot.com',
   messagingSenderId: '425980259533',
   appId: '1:425980259533:web:c3982516bdd159b3a40d84',
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
export const db = getDatabase(app);
export const storage = getStorage(app);
export default app;
