import React, { useState, Component } from 'react';

export default function ClassFunctionalComponent() {
  class ClassComponent extends Component {
    constructor(props) {
      super(props);
      this.state = {count: 0};
    }
  
    componentDidMount() {
      console.log('ClassComponent: Mounted');
    }
  
    increment = () => {
      this.setState({ count: this.state.count + 1 });
    };
  
    render() {
      return (
        <div>
          <h2>Class Component</h2>
          <p>Count: {this.state.count}</p>
          <button onClick={this.increment}>Increment</button>
        </div>
      );
    }
  }
  
  function FunctionalComponent() {
    const [count, setCount] = useState(0);

    const increment = () => {
      setCount(count + 1);
    };

    return (
      <div>
        <h2>Functional Component</h2>
        <p>Count: {count}</p>
        <button onClick={increment}>Increment</button>
      </div>
    );
  }

  return (
    <div className="align">
      <h1>Class and Functional Components in ReactJS</h1>
      <p>Demonstration of both component types with state management and lifecycle methods.</p>
      
      <div style={{display: "flex", flexDirection: "row", gap: "50px" }}>
        <ClassComponent title="Class Component Demo" />
        <FunctionalComponent />
      </div>
    </div>
  );
}