import { BrowserRouter, Routes, Route } from "react-router";
import HomePage from "../../components/pages/HomePage";

function AppRoutes() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<HomePage />} />
      </Routes>
    </BrowserRouter>
  );
}

export default AppRoutes;
