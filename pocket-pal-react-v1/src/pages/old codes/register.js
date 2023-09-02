/*import React from 'react';
import "./register.css";
import { useDispatch } from "react-redux";
import { fetchDoRegister } from '../../store/features/userSlice';


export default function Index(){
    const dispatch = useDispatch();
    const [email, setEmail] = React.useState("");
    const [password, setPassword] = React.useState("");
    const [name, setName] = React.useState("");
    const [lastName, setLastName] = React.useState("");

    const doRegister = () => {
        dispatch(
          fetchDoRegister({
            email: email,
            password: password,
            name: name,
            lastName: lastName
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
            <h2>Register</h2>
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
              type="name"
              onChange={(text) => setName(text.target.value)}
              placeholder="Name"
              className="loginscreen"
            />
              <input
              type="lastName"
              onChange={(text) => setLastName(text.target.value)}
              placeholder="Lastname"
              className="loginscreen"
            />
            <input
              className="loginbutton loginscreen"
              type="submit"
              value="register"
              onClick={doRegister}
            />
            <a className="forgotpassword loginscreen" href="/login">
              back to login
            </a>
          </div>
        </div>
      );
}
*/