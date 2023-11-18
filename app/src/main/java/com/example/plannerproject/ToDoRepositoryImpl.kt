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


    override suspend fun getToDoById(id: Int): ToDoModel? {
        return dao.getToDoById(id)?.asExternalModel()
    }

    override suspend fun insertToDo(todomodel: ToDoModel) {
        dao.insertToDo(todomodel.toEntity())
    }

    override suspend fun deleteToDo(todomodel: ToDoModel) {
        dao.deleteToDo(todomodel.toEntity())
    }

    override suspend fun updateToDo(todomodel: ToDoModel) {
        dao.updateToDo(todomodel.toEntity())
    }

}