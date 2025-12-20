// Create single page application using ReactJs router.
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router';

function Home() {
    return (
        <div>
            <h2>Home Page</h2>
        </div>
    );
}

function About() {
    return (
        <div>
            <h2>About Page</h2>
        </div>
    );
}

function Contact() {
    return (
        <div>
            <h2>Contact Page</h2>
        </div>
    );
}

export default function SpaRouter() {
    return (
        <Router>
            <>
                <h1>React Router Application</h1>
                <nav style={{display:"flex", gap:"1rem"}}>
                    <Link to="/" >Home</Link>
                    <Link to="/about">About</Link>
                    <Link to="/contact">Contact</Link>
                </nav>

                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/about" element={<About />} />
                    <Route path="/contact" element={<Contact />} />
                </Routes>
            </>
        </Router>
    );
}