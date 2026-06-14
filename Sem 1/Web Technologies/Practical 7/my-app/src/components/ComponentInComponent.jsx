import React from 'react'

function GrandChild({ value }) {
  return (
    <div style={{ paddingLeft: 20 }}>
      <strong>Grandchild:</strong> value × 2 = {value}
    </div>
  )
}

function Child({ value, onIncrement }) {
  return (
    <div style={{ paddingLeft: 10, borderLeft: '2px solid #ddd', margin: '8px 0' }}>
      <div>
        <strong>Child:</strong> received value = {value}
      </div>
      <div style={{ marginTop: 6 }}>
        <button onClick={onIncrement}>Increment from Child</button>
      </div>
      <GrandChild value={value * 2} />
    </div>
  )
}

export default function ComponentInComponent() {
  const [count, setCount] = React.useState(1)
  const increment = () => setCount((c) => c + 1)

  return (
    <section style={{ padding: 12, border: '1px solid #ccc', borderRadius: 6 }}>
      <h2>Component-in-Component (Function Components)</h2>
      <div>
        <strong>Parent:</strong> count = {count}
      </div>
      <div style={{ marginTop: 8 }}>
        <button onClick={increment}>Increment from Parent</button>
      </div>

      <Child value={count} onIncrement={increment} />
    </section>
  )
}
