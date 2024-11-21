package com.x1oto.harrypotterwiki.data.local.room

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.x1oto.harrypotterwiki.data.models.character.Characters

class CharactersTypeConverters {
    private val gson = Gson()

    @TypeConverter
    fun fromCharacters(characters: Characters): String {
        return gson.toJson(characters)
    }

    @TypeConverter
    fun toCharacters(json: String): Characters {
        val type = object : TypeToken<Characters>() {}.type
        return gson.fromJson(json, type)
    }
}