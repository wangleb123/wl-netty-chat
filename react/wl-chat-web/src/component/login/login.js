import React, { Component, useEffect, useState } from 'react'
import { Form, Input, Checkbox, Button } from 'antd'
import 'antd/dist/antd.css';
import { auth_login } from '../../plugins/axios'
import axios from 'axios';
import qs from 'qs'
import Socket from "../../plugins/websocket/index"
import './index.less'





const FormLogin = () => {
    const [form] = Form.useForm();
    const [socket,setSocket] = useState(null);
    const handlSubmit = FormLogin => {
        axios
            .post("http://localhost:7510/user/login", JSON.stringify({phoneNumber: form.getFieldValue("phoneNumber"), passWord:form.getFieldValue("password") }),{
                headers: {
                    'Content-Type': 'application/json;charset=UTF-8'
                }
            })
            .then(res => { })
            .catch(err => {alert('err');console.log(err)})

    }
    useEffect(() =>{
        let socket = new Socket({
            socketUrl: 'ws://localhost:1235/web',
            timeout: 5000,
            socketMessage: (receive) => {
                console.log(receive);  //后端返回的数据，渲染页面
            },
            socketClose: (msg) => {
                console.log(msg);
            },
            socketError: () => {
                console.log('连接建立失败');
            },
            socketOpen: () => {
                console.log('连接建立成功');
                // 心跳机制 定时向后端发数据
                let taskRemindInterval = setInterval(() => {
                    this.socket.sendMessage({ "msgType": 0 })
                }, 30000)
            }
        });
        socket.connecton()
　　　　　//重试创建socket连接
        try {
            socket.connection();
        } catch (e) {
            // 捕获异常，防止js error
            // donothing
        }
    })

   
    return (
       
        <div className="login">
            <div className="form-login">
                <div className="container">
                    <Form form={form} layout='horizontal' style={{ width: 300 }}>
                        <Form.Item
                            initialValue="admin"
                            name="phoneNumber"
                            rules={
                                [
                                    { required: true, message: '用户名不能为空' }
                                ]
                            }
                        >
                            <Input  size='large' placeholder="请输入管理员账号" />
                        </Form.Item>
                        <Form.Item name="password" initialValue="123456" rules={
                            [
                                {
                                    required: true,
                                    message: '密码不能为空'
                                }
                            ]}>

                            <Input
                                 
                                type="password"
                                size='large'
                                placeholder="请输入对应管理员密码" />
                        </Form.Item>
                        <Form.Item name="password">
                            <Checkbox>记住我</Checkbox>
                            <a className="login-form-forgot" href="">忘记密码</a>
                            <Button type="primary" htmlType="submit" className="login-form-button" onClick={handlSubmit}>
                                登录后台
                       </Button>
                            <a href="">现在注册</a>
                        </Form.Item>
                    </Form>
                </div>
            </div>
        </div>

    )


}

export default FormLogin