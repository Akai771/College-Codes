// Create a Todo application using react hooks.

import { useState } from 'react';

export default function TodoApp() {
    const [todos, setTodos] = useState([
        { id: 1, text: 'Learn React Hooks', completed: false },
    ]);
    const [inputValue, setInputValue] = useState('');
    const [filter, setFilter] = useState('all');

    // Add new todo
    function handleAddTodo(e) {
        e.preventDefault();
        if (inputValue.trim() === '') return;
        
        const newTodo = {
            id: Date.now(),
            text: inputValue,
            completed: false
        };
        setTodos([...todos, newTodo]);
        setInputValue('');
    }

    // Toggle todo completion
    function toggleTodo(id) {
        setTodos(todos.map(todo => todo.id === id ? { ...todo, completed: !todo.completed } : todo));
    }

    // Delete todo
    function deleteTodo(id) {
        setTodos(todos.filter(todo => todo.id !== id));
    }

    // Filter todos
    const filteredTodos = todos.filter(todo => {
        if (filter === 'active') return !todo.completed;
        if (filter === 'completed') return todo.completed;
        return true;
    });

    const activeCount = todos.filter(todo => !todo.completed).length;

    return (
        <div style={{ display: 'flex', flexDirection: 'column', maxWidth: '600px', margin: '0 auto', padding: '20px', gap: '20px' }}>
            <h1>Todo Application</h1>
            
            {/* Add Todo Form */}
            <form onSubmit={handleAddTodo}>
                <input type="text" placeholder="What needs to be done?" value={inputValue} onChange={(e) => setInputValue(e.target.value)} style={{ padding: '10px', width: '70%', fontSize: '16px' }}/>
                <button type="submit" style={{ padding: '10px 20px', marginLeft: '10px', fontSize: '16px' }}>+</button>
            </form>

            {/* Filter Buttons */}
            <div>
                <button onClick={() => setFilter('all')} style={{ padding: '8px 16px', marginRight: '10px',backgroundColor: filter === 'all' ? '#4CAF50' : '#ddd', color: filter === 'all' ? 'white' : 'black', border: 'none', borderRadius: '4px'}}>All ({todos.length})</button>
                <button onClick={() => setFilter('active')}style={{ padding: '8px 16px', marginRight: '10px',backgroundColor: filter === 'active' ? '#4CAF50' : '#ddd', color: filter === 'active' ? 'white' : 'black', border: 'none',borderRadius: '4px',}}>Active ({activeCount})</button>
                <button onClick={() => setFilter('completed')} style={{ padding: '8px 16px', backgroundColor: filter === 'completed' ? '#4CAF50' : '#ddd', color: filter === 'completed' ? 'white' : 'black', border: 'none', borderRadius: '4px',}}>Completed ({todos.length - activeCount})</button>
            </div>

            {/* Todo List */}
            <div>
                {filteredTodos.length === 0 ? (
                    <p style={{ textAlign: 'center', color: '#666' }}>No todos to display</p>
                ) : (
                    filteredTodos.map(todo => (
                        <div key={todo.id} style={{ display: 'flex', alignItems: 'center', padding: '15px', marginBottom: '10px', border: '1px solid #ddd', borderRadius: '5px', backgroundColor: todo.completed ? '#f0f0f0' : 'white'}}>
                            <input type="checkbox" checked={todo.completed} onChange={() => toggleTodo(todo.id)} style={{ marginRight: '15px', cursor: 'pointer', width: '18px', height: '18px' }}/>
                            <span style={{ flex: 1, textDecoration: todo.completed ? 'line-through' : 'none',color: todo.completed ? '#888' : 'black',fontSize: '16px'}}>{todo.text}</span>
                            <button onClick={() => deleteTodo(todo.id)} style={{padding: '5px 15px', backgroundColor: '#ff4444', color: 'white', border: 'none',borderRadius: '4px'}}>X</button>
                        </div>
                    ))
                )}
            </div>
        </div>
    );
}