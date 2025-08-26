import { Link } from "react-router";
import billionPixesLogo from "../../../assets/billion-pixes-logo.png";
import "./Navbar.css";

export default function Navbar() {
  const navItems = [
    { id: 1, text: "Contribute", endpoint: "/contribute" },
    { id: 2, text: "Search", endpoint: "/search" },
    { id: 3, text: "Help", endpoint: "/help" },
    { id: 4, text: "About", endpoint: "/about" },
  ];

  return (
    <header className="flex flex-wrap sm:justify-start sm:flex-nowrap w-full ">
      <nav className="max-w-[85rem] w-full mx-auto px-4 sm:flex sm:items-center sm:justify-between">
        <div className="flex flex-row items-center gap-5 mt-5 sm:justify-end sm:mt-0 sm:ps-5">
          <img
            className="flex-none w-20 h-20"
            src={billionPixesLogo}
            alt="Billion Pixes logo"
          ></img>
          {navItems.map((item) => (
            <Link to={item.endpoint}>
              <a key={item.id}>{item.text}</a>
            </Link>
          ))}
        </div>
      </nav>
    </header>
  );
}
