import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';
import AuthService from '../../config/AuthService';


const initialStateAuth = {
    token: '',
    isAuthenticated: false,
    isLoading: false,
    isRegisterLoading: false,
    auth: []
}
export const fetchDoLogin = createAsyncThunk(
    'auth/fetchDoLogin',
    async (payload) => {
        try {
            const result = await fetch(AuthService.login, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Accept-Encoding': 'br;q=1.0, gzip;q=0.8, *;q=0.1',
                },
                body: JSON.stringify({
                    email: payload.email,
                    password: payload.password
                })
            })
                .then(p => p.json())
                .then(p => {
                    return p;
                })
                .catch(err => alert("Giriş Başarısız..."+err));
            return result;
        } catch (error) {

        }
    }
);

export const fetchDoForgotPassword = createAsyncThunk(
    'auth/fetchDoForgotPassword',
    async (payload) => {
        try {

            return axios.post(AuthService.forgotPassword, {
                email: payload.email,
            }).then(response => response.data)
                .catch(err => console.log(err));
        } catch (error) {
            console.log('şifremi unuttum işleminde hata oluştu...: ', error);
        }
    }
);
const authSlice = createSlice({
    name: 'auth',
    initialState: initialStateAuth,
    reducers: {
        setLogin: (state) => {
            state.isAuthenticated = true;
        },
        setLogout: (state) => {
            state.isAuthenticated = false;
        },

    },
    extraReducers: (build) => {
        build.addCase(fetchDoLogin.fulfilled, (state, action) => {
            /**
             * Eğer responsecode tanımsız gelmiş ise, bir hata oluşmuştur
             */
                if (action.payload.responseCode === 200) {
                    state.isAuthenticated = true;
                    state.isLoading = false;
                    state.token = action.payload.token;
                } else {
                    state.isAuthenticated = false;
                    state.isLoading = false;
                    alert("Kullanici adi ya da şifre hatalidir.");
                }
            })

       ;
        build.addCase(fetchDoLogin.rejected, (state, action) => {
            state.token = '';
            state.isAuthenticated = false;
            console.log('fetchDoLogin rejected: ', action.payload);
        });
        build.addCase(fetchDoForgotPassword.pending, (state, action) => {
            state.isLoading = true;
        });
        build.addCase(fetchDoForgotPassword.fulfilled, (state, action) => {
            state.isLoading = false;
        });
        build.addCase(fetchDoForgotPassword.rejected, (state, action) => {
            state.isLoading = false;
        });
       
    }
});

export const
    {
        setLogin,
        setLogout
    } = authSlice.actions;

export default authSlice.reducer;