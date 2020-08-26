import action from './actionTypes';

const addTodo = (text) =>{

   return {
       type: action.ADD_TUDO,
       text: text
   }
}

export default {addTodo}
