package com.x1oto.harrypotterwiki.data.local.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.x1oto.harrypotterwiki.data.models.character.Characters

@Entity(tableName = "cached_characters")
data class CacheCharactersEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val characters: Characters
)