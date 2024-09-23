// Import the functions you need from the SDKs you need
import { initializeApp } from 'firebase/app';
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
const firebaseConfig = {
   apiKey: 'AIzaSyAkM8BiOvkfOHbJzQuVPzge7L6XxYXp0sM',
   authDomain: 'chat-app-38a36.firebaseapp.com',
   projectId: 'chat-app-38a36',
   storageBucket: 'chat-app-38a36.appspot.com',
   messagingSenderId: '425980259533',
   appId: '1:425980259533:web:c3982516bdd159b3a40d84',
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);

export default app;
