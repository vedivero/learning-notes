import './App.css';

function App() {
   const msg = 'Hello React';
   return (
      <div>
         <h1>{msg}</h1>
         <Welcome name='Henry' />
         <Comment
            date={new Date()}
            text={'I hope React Developer'}
            author={{
               name: 'Hello Duck',
               avatarUrl:
                  'https://www.daysoftheyear.com/cdn-cgi/image/dpr=1%2Cf=auto%2Cfit=cover%2Ch=1333%2Cq=85%2Cw=2000/wp-content/uploads/rubber-duckie-day-1.jpg',
            }}
         />
      </div>
   );
}
function Welcome(props) {
   return <h1>{props.name}</h1>;
}

function Comment(props) {
   return (
      <div className='Commnet'>
         <UserInfo user={props.author} />
         <div className='Commnet-text'>{props.text}</div>
         <div className='Commnet-date'>{formatDate(props.date)}</div>
      </div>
   );
}

function UserInfo(props) {
   return (
      <div className='UserInfo'>
         <Avatar user={props.user} />
         <div className='UserInfo-name'>{props.user.name}</div>
      </div>
   );
}

function Avatar(props) {
   return <img className='Avatar' src={props.user.avatarUrl} alt={props.user.name} />;
}

function formatDate(date) {
   return date.toLocaleDateString();
}

export default App;
