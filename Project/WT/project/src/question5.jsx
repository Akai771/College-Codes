// Create single page application using ReactJs router.
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router';

export default function SpaRouter() {
    return (
        <Router>
            <>
                <h1>React Router Application</h1>
                <nav>
                    <Link to="/" >Home</Link>
                    <Link to="/about">About</Link>
                    <Link to="/contact">Contact</Link>
                </nav>

                <Routes>
                    <Route path="/" element={<h2>Home Page</h2>} />
                    <Route path="/about" element={<h2>About Page</h2>} />
                    <Route path="/contact" element={<h2>Contact Page</h2>} />
                </Routes>
            </>
        </Router>
    );
}