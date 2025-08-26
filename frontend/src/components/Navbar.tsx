import { Link } from "react-router";
import * as React from "react";
import billionPixesLogo from "../assets/billion-pixes-logo.png";
import "./Navbar.css";

export default function Navbar() {
  return (
    <div>
      <nav>
        <Link to="/">
          <img
            id="navbar-logo"
            src={billionPixesLogo}
            alt="Billion Pixes Logo"
          ></img>
        </Link>{" "}
        <Link className="link-styles" to="/about">
          About
        </Link>
        <Link to="/contact">Contact</Link>
      </nav>
    </div>
  );
}
