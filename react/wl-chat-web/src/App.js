import React,{Component,Fragment} from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {
  render() {
    return (
      <Fragment>
         {this.props.children}
      </Fragment>
    );
  }
}

export default App;
