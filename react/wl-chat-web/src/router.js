import React,{Component} from 'react';
import {BrowserRouter,Route} from 'react-router-dom';
import App from './App'
import Login from "./component/login/login";
import Persion from "./component/perison/persion";
import Room from "./component/room/room";
import Admin from './component/admin';

const PrivateRoute = ({ component: Component, ...rest }) => (
    <Route {...rest} render={props => (
      null!=null ? (
        <Component {...props}/>
      ) : (
        <Component {...props}/>
      )
    )}/>
)


class NettyChat extends Component {
    render() {
        return (
            <BrowserRouter>
                <App>
                    <Route path='/' component={Login} exact/>
                    <PrivateRoute path='/room' component={Room}/>
                    <PrivateRoute path='/persion' component={Persion}/>
                    <PrivateRoute path='/admin' component={Admin}/>
                </App> 
        
            </BrowserRouter>
        )
    }
}

export default NettyChat

