package com.example.plannerproject.data

import kotlinx.coroutines.flow.Flow

class OfflineTodosRepository(private val todoDao: TodoDao) : TodosRepository{
    override fun getAllTodosStream(): Flow<List<Todo>> {
        return todoDao.getAllTodos()
    }

    override fun getTodoStream(id: Int): Flow<Todo?> {
        return todoDao.getTodo(id)
    }

    override suspend fun insertTodo(todo: Todo) {
        todoDao.insert(todo)
    }

    override suspend fun deleteTodo(todo: Todo) {
        todoDao.delete(todo)
    }

    override suspend fun update(todo: Todo) {
        todoDao.update(todo)
    }

}