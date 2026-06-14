import React from "react";

class LifeCycleDemo extends React.Component {
    constructor(props){
        super(props);
        this.state = {
            count : 0,
        }
        console.log("Contstructor Called");
    }

    componentDidMount(){
        console.log("Component did Mount")
    }

    componentDidUpdate(){
        console.log("Component did update")
    }

    componentWillUnmount(){
        console.log("Component will unmount")
    }

    incrementCount = () => {
        this.setState({count: this.state.count + 1});
    }

    render(){
        console.log("Render Method Called");
        return(<>
            <div>
                <h1>Life Cycle Methods</h1>
                <p>Count: {this.state.count}</p>
                <button onClick={this.incrementCount}>Click</button>
            </div>
        </>)
    }
}

export default LifeCycleDemo;