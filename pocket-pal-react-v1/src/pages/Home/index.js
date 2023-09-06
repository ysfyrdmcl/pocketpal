import React from "react";
import PocketChart from "./PocketChart";
import { Link } from "react-router-dom"; // Eğer sayfalar arası gezinme işlevselliği kullanıyorsanız.
import './Home.css';

function HomePage() {
  // Kullanıcı oturumunu kontrol etmek için bir işlev ekleyebilirsiniz.
  const isAuthenticated = true; // Kullanıcı oturum açmışsa true, aksi halde false.

  // Oturum açmışsa çıkış yapma işlevi.
  const handleLogout = () => {
    // Oturum açmayı sonlandırma işlemleri burada gerçekleştirilebilir.
  };

  return (
    <div className="homepage">
      {/* Navbar */}
      <nav className="navbar">
        <div className="navbar-left">
          <Link to="/add-item">İşlem Ekle</Link>
          <Link to="/profile">Profil</Link>
        </div>
        <div className="navbar-right">
          {isAuthenticated && (
            <button onClick={handleLogout}>Log out</button>
          )}
        </div>
      </nav>
      {/* İçerik Alanı */}
      <main className="content">
        <section className="charts">
          <PocketChart/>
          <PocketChart/>

          {/* Grafiklerinizi buraya ekleyin. */}
        </section>
        <section className="summary">ÖZET blabla
          {/* Özet bilgilerinizi buraya ekleyin. */}
        </section>
      </main>

      {/* Altbilgi */}
      <footer className="footer">
        <p>&copy; 2023 PocketPal</p>
      </footer>
    </div>
  );
}

export default HomePage;



