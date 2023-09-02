/*import React from 'react';
import "./login.css";
import loginbg from "./loginbackground.jpg";
import { useDispatch } from "react-redux";
import { fetchDoLogin } from "../../store/features/authSlice";
export default function Index(){
    const dispatch = useDispatch();
    const [email, setEmail] = React.useState("");
    const [password, setPassword] = React.useState("");
    const doLogin = () => {
        dispatch(
          fetchDoLogin({
            email: email,
            password: password,
          })
        );
      };
      return (
        <div
          className="bg_image"
          style={{
            backgroundImage: `url(${loginbg})`,
            backgroundSize: "cover",
            height: "100vh",
            color: "#f5f5f5",
          }}
        >
          <div id="logincontainer" className="login">
            <h1>Log In</h1>
            <input
              type="text"
              onChange={(text) => setEmail(text.target.value)}
              placeholder="mail@pocketpal.com"
              className="loginscreen"
            />
            <input
              type="password"
              onChange={(text) => setPassword(text.target.value)}
              placeholder="Password"
              className="loginscreen"
            />
            <input
              className="loginbutton loginscreen"
              type="submit"
              value="Log in"
              onClick={doLogin}
            />
            
              <div className='buttons'>
            <a className="forgotpassword loginscreen" href="/sifremiUnuttum">
              Forgot my password
            </a>
            <a className="forgotpassword loginscreen" href="/register">
              Register
            </a>
            </div>
            
          </div>
        </div>
      );
    }
    */