import logo from './logo.svg';
import './App.css';
import Header from './components/header';
import RegisterForm from './components/regform';

function App() {
  return (
    <div className="App">
      <Header/>
      <RegisterForm/>
    </div>
  );
}

export default App;


//Citation: https://www.section.io/engineering-education/registration-form-react.js-firebase/
//used this tutorial to learn how to use hooks properly (not very much js/html/react experience, needed some guidance)
