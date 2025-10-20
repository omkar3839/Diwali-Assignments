import React, { useEffect, useState } from 'react';
import './Todos.css'; // We'll create this file next

const Todos = () => {
  const [todos, setTodos] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');

  useEffect(() => {
    fetch('https://jsonplaceholder.typicode.com/todos')
      .then(response => {
        if (!response.ok) throw new Error('Failed to fetch data');
        return response.json();
      })
      .then(data => {
        setTodos(data.slice(0, 20)); // Only first 20 todos
        setLoading(false);
      })
      .catch(err => {
        setError(err.message);
        setLoading(false);
      });
  }, []);

  if (loading) return <p>Loading todos...</p>;
  if (error) return <p style={{ color: 'red' }}>{error}</p>;

  return (
    <div className="todo-container">
      <h2>Todo List</h2>
      <ul className="todo-list">
        {todos.map(todo => (
          <li key={todo.id} className={todo.completed ? 'completed' : ''}>
            <span>{todo.title}</span>
            <span className="status">
              {todo.completed ? '✅ Done' : '⏳ Pending'}
            </span>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Todos;
