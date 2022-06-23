import './App.css';
import {BrowserRouter, Routes, Route} from 'react-router-dom';
import {useEffect} from 'react';
import {Home, RegisterForm, LoginForm, Header, CreateBoard, CreateWorkspace, NotFound, Board, Footer, Workspace, ForgotPass} from './index.js';

function App() {

  useEffect(() => {
    // example to add class to body element
    // document.body.classList.add('bg-success');
  }, []);

  // React router: https://reactrouter.com/docs/en/v6/upgrading/v5
  return (
    <BrowserRouter>
      <Header></Header>
      <Routes>
          <Route path="/" element={<Home/>}/>
          <Route path="/register" element={<RegisterForm/>}/>
          <Route path="/login" element={<LoginForm/>}/>
          <Route path="/create-workspace" element={<CreateWorkspace/>}/>
          <Route path="/create-board" element={<CreateBoard/>}/>
          <Route path="/board/:boardId" element={<Board/>}/>
          <Route path="/home/:userId" element={<Home/>}/>
          <Route path="/workspace/:workspaceId" element={<Workspace/>}/>
          <Route path="/forget-password" element={<ForgotPass/>}/>
          <Route path="*" element={<NotFound/>}/>
        </Routes>
      <Footer></Footer>
    </BrowserRouter>
  );
}

export default App;


//Citation: https://www.section.io/engineering-education/registration-form-react.js-firebase/
//used this tutorial to learn how to use hooks properly (not very much js/html/react experience, needed some guidance)
