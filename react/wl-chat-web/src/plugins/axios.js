import axios from 'axios'

// 请求拦截
axios.interceptors.request.use(conf => {

	return {...conf}
})
//全局配置
// axios.defaults.timeout = 10000 //超时取消请求
// axios.defaults.headers.post['Content-Type'] = 'application/json;charset=UTF-8';
axios.defaults.baseURL = 'http://localhost:9999';

export  var auth_login = axios.create({
 
 baseURL:"http://localhost:7510/login" 
})
export  var nomal_requset = axios.create({
 
	baseURL:"http://localhost:8000" 
   })

auth_login.defaults.headers.common['Authorization'] = 'Basic bGV4aWFuZzpsZXhpYW5nc2VjcmV0';
auth_login.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
auth_login.defaults.headers.post['Access-Control-Allow-Origin'] = "http://localhost:3100"
// 返回拦截
axios.interceptors.response.use(response => {

	if (response.request.readyState === 4 && response.request.status === 200) {
		return response.data
	}
}, err => Promise.reject(err))
auth_login.interceptors.response.use(response => {
	
	if (response.request.readyState === 4 && response.request.status === 200) {
		
		nomal_requset.defaults.headers.common['Authorization'] = `bearer ${response.data.value}`
		return response.data
	}
}, err => Promise.reject(err))
export default axios