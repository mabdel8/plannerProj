package com.example.plannerproject

import com.example.plannerproject.data.ToDo
import com.example.plannerproject.model.ToDoModel

fun ToDo.asExternalModel(): ToDoModel = ToDoModel(
    id, task, points
)

fun ToDoModel.toEntity(): ToDo = ToDo(
    id, task, points
)