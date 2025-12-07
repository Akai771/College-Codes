// Create an application in reactjs to demonstrate the use of state and props.

import { useState } from 'react';

export default function StateProps({ title }) {
    const [count, setCount] = useState(0);

    function increment() {
        setCount(count + 1);
    }

    return (
        <div>
            <h2>{title}</h2>
            <p>Count: {count}</p>
            <button onClick={increment}>Increment</button>
        </div>
    );

}