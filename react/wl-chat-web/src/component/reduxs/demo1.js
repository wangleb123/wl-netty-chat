import React, { Component } from 'react';
import store from '../../redux/store';
import actionCreator from '../../redux/actionCreator';

class demo1 extends Component {

  constructor(props){
      super(props);
      store.subscribe(() =>{
          alert(store.getState())
      })
  }  

  render() {
    return (
      <>
      <p>demo1</p>
      </>
    );
  }

  componentDidMount(){
      store.dispatch(actionCreator.addTodo("asdsd"))
  }
}

export default demo1;
