package com.example.plannerproject.model

//THIS FILE IS SO THAT THE UI DOES NOT ACCESS
//OUR DATA FILES DIRECTLY
//ACCORDING TO DOCUMENTATION WE NEED THE MODEL
//LAYER TO BE SEPARATE
data class ToDoModel(
    val id: Int? = null,
    val title: String = "",
    val description: String = "",
    val points: Int? = null
)
