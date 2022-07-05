import './App.css';
import {Container} from 'react-bootstrap';
import {BrowserRouter, Routes, Route} from 'react-router-dom';
import {useEffect} from 'react';
import {Home, RegisterForm, LoginForm, Header, CreateBoard, CreateWorkspace, NotFound, Board, Footer, Workspace, ForgotPass, AddUser, ResetPassword} from './index.js';

function App() {

  useEffect(() => {
    // example to add class to body element
    // document.body.classList.add('bg-success');
  }, []);

  // React router: https://reactrouter.com/docs/en/v6/upgrading/v5
  return (
    <BrowserRouter>
      <Header></Header>
      <Container style={{minHeight: '100vh'}}>
        {localStorage.getItem("userId") === null? 
            <Routes>
              <Route path="*" element={<LoginForm/>}/>
              <Route path="/register" element={<RegisterForm/>}/>
              <Route path="/forget-password" element={<ForgotPass/>}/>
              <Route path="/reset-password/:emailId" element={<ResetPassword/>}/>
            </Routes>
          :
            <Routes>
              <Route path="/create-workspace" element={<CreateWorkspace/>}/>
              <Route path="/create-board/:workspaceId" element={<CreateBoard/>}/>
              <Route path="/board/:boardId" element={<Board/>}/>
              <Route path="/workspace/:workspaceId" element={<Workspace/>}/>
              <Route path="/forget-password" element={<ForgotPass/>}/>
              <Route path="/add-user/:workspaceId" element={<AddUser/>}/>
              <Route path="*" element={<Home userId = {localStorage.getItem("userId")}/>}/>
            </Routes>
          }
      </Container>
      <Footer></Footer>
    </BrowserRouter>
  );
}

export default App;


//Citation: https://www.section.io/engineering-education/registration-form-react.js-firebase/
//used this tutorial to learn how to use hooks properly (not very much js/html/react experience, needed some guidance)
