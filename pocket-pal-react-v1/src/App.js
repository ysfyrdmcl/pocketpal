import './App.css';
import {BrowserRouter,Routes,Route} from 'react-router-dom';
import Login from './pages/Login';
import Home from './pages/Home';
import Profile from './pages/Profile'
import {useSelector} from 'react-redux';
function App() {
  const isLogin = useSelector((state)=>state.auth.isAuthenticated);
  return (
    <BrowserRouter>
    <Routes>
      <Route path='/' element={isLogin ? <Home/> : <Login/> }/>
      <Route path='/login' element={<Login/>}/>
      <Route path='/home' element={<Home/>}/>
      <Route path='/profile' element={<Profile/>}/>
    </Routes>
  </BrowserRouter>
  );
}

export default App;
