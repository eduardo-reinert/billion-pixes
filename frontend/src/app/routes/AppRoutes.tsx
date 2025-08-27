import { BrowserRouter, Routes, Route } from "react-router";
import HomePage from "../../components/pages/HomePage";
import LoginSignupPage from "../../components/pages/LoginSignupPage";

function AppRoutes() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/login" element={<LoginSignupPage isLogin={true}/>} />
        <Route path="/signup" element={<LoginSignupPage isLogin={false}/>} />
      </Routes>
    </BrowserRouter>
  );
}

export default AppRoutes;
