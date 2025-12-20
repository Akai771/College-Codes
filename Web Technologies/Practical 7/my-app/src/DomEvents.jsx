// Create an application in ReactJS to use DOM events

import { useState } from 'react';
export default function DomEvents() {
    const [message, setMessage] = useState('Message');

    function handleClick() {
        setMessage('Button Clicked!');
    }

    function handleMouseEnter() {
        setMessage('Mouse entered the box!');
    }

    function handleMouseLeave() {
        setMessage('Mouse left the box!');
    }

    return (
        <div>
            <h2>DOM Events Demo</h2>
            <p>{message}</p>
            <button onClick={handleClick}>Click Me</button>
            <button onMouseEnter={handleMouseEnter} onMouseLeave={handleMouseLeave}>Hover</button>
        </div>
    );
}