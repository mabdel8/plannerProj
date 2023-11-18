package com.example.plannerproject

import com.example.plannerproject.data.ToDo
import com.example.plannerproject.model.ToDoModel

fun ToDo.asExternalModel(): ToDoModel = ToDoModel(
    id, title, description
)

fun ToDoModel.toEntity(): ToDo = ToDo(
    id, title, description
)