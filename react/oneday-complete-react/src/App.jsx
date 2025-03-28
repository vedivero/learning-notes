import './App.css';

function App() {
   return (
      <>
         <WelcomeDiaog />
      </>
   );
}

function WelcomeDiaog() {
   return (
      <FancyBorder color='blue'>
         <h1>Welcome</h1>
         <p>my name is henry</p>
      </FancyBorder>
   );
}

function FancyBorder(props) {
   return <div style={{ border: `2px solid ${props.color}` }}>{props.children}</div>;
}

export default App;
