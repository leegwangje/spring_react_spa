
import React from "react";
import { BrowserRouter as Router, Routes, Route} from "react-router-dom"
import Header from "./pages/layout/Header";
import Nav from "./pages/layout/Nav";
import Footer from "./pages/layout/Footer";
import Main from "./pages/Main";
import Join from "./pages/Join";
import NotFound from "./pages/NotFound";
import './styles/App.css'

function App() {


  return (
    <Router>
    <Header/>
    <Nav/>
    <Routes>
        <Route path="/" element={<Main/>}/>
        <Route path="/member/join" element={<Join/>}/>
        {/*<Route path="/member/login" element={<Login/>}/>*/}
        {/*<Route path="/board/list" element={<BoardList/>}/>*/}
        {/*<Route path="/gallery/list" element={<GalleryList/>}/>*/}
        {/*<Route path="/member/myinfo" element={<Myinfo/>}/>*/}
        <Route path="*" element={<NotFound/>}/>

        </Routes>
      <Footer/>
    </Router>
  )
}

export default App
