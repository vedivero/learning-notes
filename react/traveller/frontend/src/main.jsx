import { createRoot } from 'react-dom/client';
import App from './App.jsx';
import './index.css';
import { BrowserRouter } from 'react-router-dom';
import { Provider } from 'react-redux';
import { persistor, store } from './store/index.js';
import { PersistGate } from 'redux-persist/es/integration/react';

createRoot(document.getElementById('root')).render(
   <BrowserRouter>
      <Provider store={store}>
         <PersistGate loading={null} persistor={persistor}>
            <App />
         </PersistGate>
      </Provider>
   </BrowserRouter>,
);