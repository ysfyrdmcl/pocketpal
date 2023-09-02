import React, { useState } from "react";
import { useDispatch } from "react-redux";
import { fetchDoRegister } from "../../store/features/userSlice";

function SignUpForm() {
  const dispatch = useDispatch();
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [name, setName] = useState("");
  const [lastName, setLastName] = useState("");
  const [errorMessage, setErrorMessage] = useState(""); // Hata mesajını ekleyin

  const doRegister = (event) => {
    event.preventDefault();

    // Doğrulama işlemleri
    if (!isValidName(name)) {
      setErrorMessage("Name field cannot be empty and cannot contain numbers");
      return;
    }

    if (!isValidLastName(lastName)) {
      setErrorMessage("Surname field cannot be empty");
      return;
    }

    if (!isValidEmail(email)) {
      setErrorMessage("Enter a valid email address");
      return;
    }

    if (!isValidPassword(password)) {
      setErrorMessage("Password must be at least 5 characters");
      return;
    }

    // Hata mesajlarını temizleyin
    setErrorMessage("");

    // Doğru ise kayıt işlemini başlatın
    dispatch(
      fetchDoRegister({
        email: email,
        password: password,
        name: name,
        lastName: lastName,
      })
    );
  };

  const isValidName = (name) => {
    if (name.trim() === "") {
      return false; // Adın boş olmamasını kontrol edin 
    }
    if (/\d/.test(name)) {
      return false; // Adın içinde sayı bulunamaz
    }
    return true; // Geçerli bir ad
  };

  const isValidLastName = (lastName) => {
    if (lastName.trim() === "") {
      return false; // Soyadın boş olmamasını kontrol edin
    }
    if (/\d/.test(lastName)) {
      return false; // Soyadın içinde sayı bulunamaz
    }
    return true; // Geçerli bir soyad
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
    <div className="form-container sign-up-container">
      <form onSubmit={doRegister}>
        <h1>Create Account</h1>
        <br></br>
        <input
          type="text"
          name="name"
          value={name}
          onChange={(e) => setName(e.target.value)}
          placeholder="Name"
        />
        <input
          type="text"
          name="lastName"
          value={lastName}
          onChange={(e) => setLastName(e.target.value)}
          placeholder="Last name"
        />
        <input
          type="email"
          name="email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          placeholder="Email"
        />
        <input
          type="password"
          name="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          placeholder="Password"
        />
        <button type="submit">Sign Up</button>
        <br></br>
        {errorMessage && <div className="error-message">{errorMessage}</div>}{" "}
        {/* Hata mesajını görüntülemek için */}
      </form>
    </div>
  );
}

export default SignUpForm;