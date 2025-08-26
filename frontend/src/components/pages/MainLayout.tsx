import Navbar from "../common/Navbar/Navbar";
import Footer from "../common/Footer/Footer";
import type { ReactNode } from "react";

interface MainLayoutProps {
    children: ReactNode;
}

export default function MainLayout({children} : MainLayoutProps) {
    return (
        <>
            <Navbar></Navbar>
            <main>{children}</main>
            <Footer></Footer>
        </>
    )
}