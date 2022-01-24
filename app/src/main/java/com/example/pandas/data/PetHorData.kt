package com.example.pandas.data

import com.example.pandas.sql.entity.PetVideo

object PetHorData {

    private var list = mutableListOf<PetVideo>()

    fun getAll(): MutableList<PetVideo> {


        return list
    }
}