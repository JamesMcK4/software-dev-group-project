import './App.css';
import Header from './components/header';
import RegisterForm from './components/regform';
import Component from './components/component'
import {BrowserRouter, Routes, Route} from 'react-router-dom';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<RegisterForm/>}/>
        <Route path="/home" element={<Component/>}/>
        <Route path="/register/:myParam" element={<RegisterForm/>}/>
      </Routes>
    </BrowserRouter>
  /*
    <div className="App">
      <Header/>
      <RegisterForm/>
      <Component property="string"/>
    </div>
  */
  );
}

export default App;


//Citation: https://www.section.io/engineering-education/registration-form-react.js-firebase/
//used this tutorial to learn how to use hooks properly (not very much js/html/react experience, needed some guidance)
