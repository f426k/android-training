package jp.co.mixi.androidtraining.todo

import jp.co.mixi.androidtraining.todo.data.entity.Task
import jp.co.mixi.androidtraining.todo.ui.ToDoViewModel
import junit.framework.TestCase.assertEquals
import org.junit.Test

class ToDoViewModelTest {
    private val viewModel = ToDoViewModel()

    @Test
    fun testInputText() {
        assertEquals(false, viewModel.uiState.addEnabled)
        viewModel.setInputText("text")
        assertEquals("text", viewModel.uiState.inputText)
        assertEquals(true, viewModel.uiState.addEnabled)
    }

    @Test
    fun testAddAndDeleteTask() {
        viewModel.setInputText("text")
        viewModel.addTask()
        assertEquals(listOf(Task("text")), viewModel.uiState.tasks)
        viewModel.deleteTask(Task("text"))
        assertEquals(emptyList<Task>(), viewModel.uiState.tasks)
    }
}