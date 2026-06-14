// Create an application in ReactJs implement state management in a class
// component and use props in a functional component. To design react
// application that demonstrate:
//  1. State management using class component
//  2. Data passing through props to a functional child component.

import { useState, Component } from 'react';

export default function Question1({name}) {
    class ClassComponent extends Component {
        constructor(props) {
            super(props);
            this.state = {count: 0};
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
    
    return (
        <div className="align">
            <div style={{display: "flex", flexDirection: "row", gap: "50px" }}>
                <ClassComponent/>
                <div>
                    <h2>Functional Component</h2>
                    <p>Name: {name}</p>
                </div>
            </div>
        </div>
    );
}