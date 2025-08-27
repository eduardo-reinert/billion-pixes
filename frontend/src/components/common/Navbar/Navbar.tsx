import { Link } from "react-router";
// import billionPixesLogo from "../../../assets/billion-pixes-logo.png";
import "./Navbar.css";

export default function Navbar() {
  const isLoggedIn = false;

  const navItems = [
    { id: 1, text: "Contribute", endpoint: "/contribute" },
    { id: 2, text: "Search", endpoint: "/search" },
    { id: 3, text: "Help", endpoint: "/help" },
    { id: 4, text: "About", endpoint: "/about" },
  ];

  return (
    <header className="border-b-2">
      <div className="mx-auto max-w-5xl px-6 py-4 flex flex-col md:flex-row gap-2 md:gap-8 items-center">
        <a href="/" className="font-bold text-xl">
          <span className="text-orange-500">
            <i className="bi bi-bookmark-fill"></i> Billion
          </span>
          Pixes
        </a>
        <nav>
          <ul className="flex gap-4 text-sm md:text-base">
            {navItems.map((item) => (
              <Link to={item.endpoint}>
                <li>
                  <a href="" className="hover:text-orange-500">
                    {item.text}
                  </a>
                </li>
              </Link>
            ))}
          </ul>
        </nav>
        <div className="flex ml-0 md:ml-auto gap-2 md:gap-8 items-center">
          {isLoggedIn || (
            <a
              href="/login"
              className="text-sm md:text-base bg-orange-500 rounded text-white font-bold py-2 px-6 hover:bg-orange-600"
            >
              Login / Sign up
            </a>
          )}
        </div>
      </div>
    </header>
  );
}
