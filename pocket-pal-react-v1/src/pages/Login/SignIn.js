import React, { useState } from "react";
import { useDispatch } from "react-redux";
import { fetchDoLogin } from "../../store/features/authSlice";

function SignInForm() {
  const dispatch = useDispatch();
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [errorMessage, setErrorMessage] = useState(""); // Hata mesajı ekleyin

  const doLogin = async (event) => {
    event.preventDefault();

    // Doğrulama işlemleri
    if (!isValidEmail(email)) {
      setErrorMessage("! Please enter a valid email address");
      return;
    }

    if (!isValidPassword(password)) {
      setErrorMessage("! Password incorrect");
      return;
    }

    // Hata mesajlarını temizleyin
    setErrorMessage("");

    // Doğru ise giriş işlemini başlatın
    dispatch(
      fetchDoLogin({
        email: email,
        password: password,
      })
    );
  };

  const isValidEmail = (email) => {
    // E-posta doğrulama mantığını burada uygulayın
    // Örnek bir doğrulama işlemi
    const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    return emailPattern.test(email);
  };

  const isValidPassword = (password) => {
    // Parola doğrulama mantığını burada uygulayın
    // Örnek bir doğrulama işlemi
    return password.length >= 5;
  };

  return (
    <div className="form-container sign-in-container">
      <form onSubmit={doLogin}>
        <h1>Sign in</h1>
        <br></br>
        <input
          type="email"
          placeholder="Email"
          name="email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
        <input
          type="password"
          name="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        <button type="submit">Sign In</button>
        <br></br>
        {errorMessage && <div className="error-message">{errorMessage}</div>} {/* Hata mesajını görüntülemek için */}
        <br></br>
        <br></br>
        <a href="#">Forgot your password?</a>
      </form>
    </div>
  );
}

export default SignInForm;
