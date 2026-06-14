// Create an application to implement React Hooks
import { useState, useEffect } from 'react';

export default function ReactHooks() {
    const [count, setCount] = useState(0);

    useEffect(() => {
        document.title = `Count: ${count}`;
    }, [count]);

    function handleIncrement() {
        setCount(count + 1);
    }

    return (
        <div>
            <h2>React Hooks Demo</h2>
            <br />
            <div>
                <h3>useState & useEffect Hook</h3>
                <p>Page title updates with count</p>
                <button onClick={handleIncrement}>Increment</button>
                <p>Count: {count}</p>
            </div>
        </div>
    );
}