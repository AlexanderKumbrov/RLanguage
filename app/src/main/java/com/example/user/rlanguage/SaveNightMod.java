package com.example.user.rlanguage;

import android.content.Context;
import android.content.SharedPreferences;

public class SaveNightMod {
    SharedPreferences mSharedPreferences;
    public  SaveNightMod (Context context){
mSharedPreferences = context.getSharedPreferences("name",Context.MODE_PRIVATE);
    }
    public void saveNightModeState(Boolean state){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean("NightMod",state);
        editor.commit();
    }
    public Boolean loadNightModState(){
        Boolean state = mSharedPreferences.getBoolean("NightMod",false);
        return state;
    }
}
