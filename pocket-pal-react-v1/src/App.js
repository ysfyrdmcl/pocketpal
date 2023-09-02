import './App.css';
import {BrowserRouter,Routes,Route} from 'react-router-dom';
import Login from './pages/Login';

import {useSelector} from 'react-redux';
function App() {
  const isLogin = useSelector((state)=>state.auth.isAuthenticated);
  return (
    <BrowserRouter>
    <Routes>
      <Route path='/' element={isLogin ? '<Home/>' : <Login/> }/>
      <Route path='/login' element={<Login/>}/>
    </Routes>
  </BrowserRouter>
  );
}

export default App;
