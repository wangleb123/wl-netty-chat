import React, { Component } from 'react'
import { Form, Input, Checkbox, Button } from 'antd'
import 'antd/dist/antd.css';
import { Icon } from '@ant-design/compatible';
import cookie from 'react-cookies'
import { auth_login } from '../../plugins/axios'
import axios from 'axios';
import qs from 'qs'
import './index.less'


const FormLogin = () => {
    const [form] = Form.useForm();
    const handlSubmit = () => {

        axios
            .post("http://localhost:7510/user/login", JSON.stringify({phoneNumber: form.getFieldValue("phoneNumber"), passWord:form.getFieldValue("password") }),{
                headers: {
                    'Content-Type': 'application/json;charset=UTF-8'
                }
            })
            .then(res => {
                

            })
            .catch(err => {
                alert('err');
                console.log(err)
            })

    }

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
                            <Input prefix={< Icon type="user" style={{ fontSize: 11 }} />} size='large' placeholder="请输入管理员账号" />
                        </Form.Item>
                        <Form.Item name="password" initialValue="123456" rules={
                            [
                                {
                                    required: true,
                                    message: '密码不能为空'
                                }
                            ]}>

                            <Input
                                prefix={< Icon type="lock" style={{ fontSize: 11 }} />}
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