import AuthService from '../../config/AuthService';
import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';

const initialStateUser={
    isLoading: false,
    userProfile: {
        name: '',
        lastName: '',
        email: '',

    }
}
export const fetchDoRegister = createAsyncThunk(
    'auth/fetchDoRegister',
    async (payload) => {
        try {
            const result = await fetch(AuthService.register, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Accept-Encoding': 'br;q=1.0, gzip;q=0.8, *;q=0.1',
                },
                body: JSON.stringify({
                    email: payload.email,
                    password: payload.password,
                    name: payload.name,
                    lastName: payload.lastName
                })
            })
                .then(p => p.json())
                .then(p => {
                    return p;
                })
                .catch(err => console.log(err));
            return result;
        } catch (error) {

        }
    }
);
const userSlice = createSlice({
    name: 'user',
    initialState: initialStateUser,
    /**
     * Daha çok elle müdehale edeceğini kodlamalar için
     * kullanılan methodlardır.
     */
    reducers:{
        /**
         * Burada state, yukarıda yazıdğımız  initialState
         * kavramını ifade eder. içindeki değerleri
         * değiştirmek için kullanılır.
         * Action, bu method a dışarıdan girilen dataları
         * ifade eder. 
         */
      
     
     
        setName:(state,action)=>{
            state.userProfile = 
            {...state.userProfile,name: action.payload};
        },
        setEmail:(state,action)=>{
            state.userProfile = 
            {...state.userProfile,email: action.payload};
        },
        setLastName:(state,action)=>{
            state.userProfile = 
            {...state.userProfile,lastName: action.payload};
        },
    },
    extraReducers:(build) =>{
        build.addCase(fetchDoRegister.pending,(state,action)=>{
            state.isLoading = true;
        });
        build.addCase(fetchDoRegister.fulfilled,(state,action)=>{
            if (action.payload.responseCode === 200) 
                state.isLoading = false;
            
            /** todo
             * buraya register doğrulandığında yapılacak işlemler yazılacak
             */

             else
                alert("Hata...: " + action.payload.message);
             
        });
        build.addCase(fetchDoRegister.rejected,(state,action)=>{
            state.isLoading = false;
            console.log('fetchDoLogin rejected: ', action.payload);
        });
    }
});



export const{
    setName,
    setEmail,
    setLastName
} = userSlice.actions;
export default userSlice.reducer;


