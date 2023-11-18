package com.example.plannerproject

import com.example.plannerproject.data.ToDo
import com.example.plannerproject.data.ToDoDao
import com.example.plannerproject.model.ToDoModel
import com.example.plannerproject.repository.ToDoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ToDoRepositoryImpl(
    private val dao: ToDoDao
) : ToDoRepository {
    override fun getAllToDos(): Flow<List<ToDoModel>> {
        return dao.getAllToDos()
            .map { todos ->
                todos.map {
                    it.asExternalModel()
                }
            }
    }


    override suspend fun getToDoById(id: Int): ToDo? {
        TODO("Not yet implemented")
    }

    override suspend fun insertToDo(todo: ToDo) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteToDo(todo: ToDo) {
        TODO("Not yet implemented")
    }

    override suspend fun updateToDo(todo: ToDo) {
        TODO("Not yet implemented")
    }

}