import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css'

import RegisterForm from './components/user-management/regform';
import Home from './pages/home';
import Header from './components/common/header';
import LoginForm  from './components/user-management/login';
import CreateWorkspace from './pages/createworkspace';
import Footer from './components/common/footer';
import CreateBoard from './pages/createboard';
import Board from './pages/board';
import NotFound from './components/common/notfound';
import Workspace from './pages/workspace';
import ForgotPass from './pages/forgetpass';
import WorkspaceInfo from './components/workspace/workspace-info';
import WorkspaceTabs from './components/workspace/workspace-tabs';
import WorkspaceCards from './components/workspace/workspace-cards';
import BoardList from './components/board/boardlist';

/* Guidelines
https://stackoverflow.com/questions/46984955/how-to-import-all-components-in-react
export the components like this
export default RegisterForm;

Then, in your src/modules/layout/index.js file, import // the components you exported just the way you did it

import NavBar from './NavBar';
import SideBar from './SideBar';

export {
NavBar,
SideBar
}

Hence, wherever you need both components, you can easily do this:
import { NavBar, SideBar } from '../index.js'

// From the above, you are just importing both components from the index.js file. 
*/
export {
  Home,
  Header,
  LoginForm,
  RegisterForm,
  CreateBoard,
  CreateWorkspace,
  Board, 
  Footer,
  NotFound,
  Workspace,
  ForgotPass,
  WorkspaceInfo,
  WorkspaceTabs,
  WorkspaceCards,
  BoardList
}

ReactDOM.render(
  <React.StrictMode>
    <App/>
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
