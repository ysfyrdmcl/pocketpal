import { configureStore } from "@reduxjs/toolkit";
import {authSlice} from './features';
import {userSlice} from './features';

const store = configureStore({
    reducer:{
        auth:authSlice,
        user:userSlice,
    }
});
export default store;