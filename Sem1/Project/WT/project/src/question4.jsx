// Create a Todo application using react hooks.

import { useState } from 'react';

export default function TodoApp() {
    const [todos, setTodos] = useState([{ id: 1, text: 'Learn React Hooks', completed: false }]);
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
            <form onSubmit={handleAddTodo}>
                <input type="text" placeholder="What needs to be done?" value={inputValue} onChange={(e) => setInputValue(e.target.value)} style={{ padding: '10px' }}/>
                <button type="submit" style={{ padding: '10px 20px'}}>+</button>
            </form>
            <div style={{ display: 'flex', gap: '10px' }}>
                <button onClick={() => setFilter('all')} style={{backgroundColor: filter === 'all' ? '#4CAF50' : '#ddd'}}>All ({todos.length})</button>
                <button onClick={() => setFilter('active')} style={{backgroundColor: filter === 'active' ? '#4CAF50' : '#ddd'}}>Active ({activeCount})</button>
                <button onClick={() => setFilter('completed')} style={{backgroundColor: filter === 'completed' ? '#4CAF50' : '#ddd'}}>Completed ({todos.length - activeCount})</button>
            </div>
            <div>
                {filteredTodos.length === 0 ? (
                    <p>No todos to display</p>
                ) : (
                    filteredTodos.map(todo => (
                        <div key={todo.id} style={{ display: 'flex', alignItems: 'center', padding: '15px', border: '1px solid #ddd', backgroundColor: todo.completed ? '#f0f0f0' : 'white'}}>
                            <input type="checkbox" checked={todo.completed} onChange={() => toggleTodo(todo.id)}/>
                            <span style={{ flex: 1, textDecoration: todo.completed ? 'line-through' : 'none'}}>{todo.text}</span>
                            <button onClick={() => deleteTodo(todo.id)} style={{ backgroundColor: '#ff4444', color: 'white'}}>X</button>
                        </div>
                    ))
                )}
            </div>
        </div>
    );
}