import './App.css';

function Welcome(props) {
   return (
      <h1
         onClick={() => {
            props.onTitleClick(props.name);
         }}
      >
         {props.name}
      </h1>
   );
}

function App() {
   const msg = 'Hello React';
   const showMessage = (name) => {
      alert(`Welcome ${name}`);
   };
   return (
      <div>
         <h1
            onClick={() => {
               alert('Hi');
            }}
         >
            {msg}
         </h1>
         <Welcome name='Henry' onTitleClick={showMessage} />
      </div>
   );
}

export default App;
