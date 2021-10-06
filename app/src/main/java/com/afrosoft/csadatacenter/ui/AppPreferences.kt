package com.afrosoft.csadatacenter.ui

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.afrosoft.csadatacenter.models.Interest
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AppPreferences(val context: Context) {
    val preferences = context.getSharedPreferences("AgriAid",MODE_PRIVATE)
    val editor = preferences.edit()

    val firstTime = "firstTime"

    fun updateFirstTimeRecord(boolean: Boolean){
        editor.putBoolean(firstTime,boolean).apply()
    }

    fun isFirstTime(): Boolean{
        return preferences.getBoolean(firstTime,true)
    }

    /*save User selections*/

    fun getFarmerInterests(): MutableList<Interest> {
        val list: MutableList<Interest> =
            Gson().fromJson(preferences.getString("interests","[]"), object : TypeToken<MutableList<Interest?>?>() {}.type)
        return list

    }
    fun saveFarmerInterests(interests: MutableList<Interest>) {
        editor.putString("interests", Gson().toJson(interests)).apply()
    }



    /*save all plants for limit consistent server requests*/
    val allPlants = "plants"

    fun saveAllPlantsData(response: String?) {
        editor.putString(allPlants,response).apply()
    }

    fun getAllPlantData(): MutableList<Interest>{
        return if (preferences.getString(allPlants,"").isNullOrEmpty()) mutableListOf()
        else Gson().fromJson(preferences.getString(allPlants,""), object : TypeToken<MutableList<Interest>>(){}.type)
    }
}