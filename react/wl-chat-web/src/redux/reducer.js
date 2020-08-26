import actionCS from './actionTypes';
const defaultState = 0
const reducer = (state = defaultState, action) =>{

    switch(action.type){
        case actionCS.ADD_TUDO:
            return state = state+action.text;
        default:
            return state;   
    }


}

export default reducer