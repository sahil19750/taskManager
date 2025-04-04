package com.example.taskmanager

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskmanager.adapter.TaskAdapter
import com.example.taskmanager.data.TaskDatabase
import com.example.taskmanager.databinding.ActivityMainBinding
import com.example.taskmanager.model.Task
import com.example.taskmanager.viewmodel.TaskViewModel
import com.example.taskmanager.viewmodel.TaskViewModelFactory
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var taskAdapter: TaskAdapter
    private val viewModel: TaskViewModel by viewModels {
        TaskViewModelFactory(application)
    }
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAnalytics = Firebase.analytics

        setupRecyclerView()
        observeTasks()
        setupCrashButtons()
        setupAddButton()
    }

    private fun setupRecyclerView() {
        taskAdapter = TaskAdapter(
            onTaskCheckChanged = { task ->
                viewModel.update(task)
                if (task.isCompleted) {
                    firebaseAnalytics.logEvent("task_completed", null)
                }
            },
            onTaskEdit = { task ->
                showEditTaskDialog(task)
            }
        )


        binding.syncTasksButton.setOnClickListener {
            viewModel.syncTasksFromApi()
            Toast.makeText(this, "Syncing...", Toast.LENGTH_SHORT).show()
        }


        binding.recyclerViewTasks.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = taskAdapter
        }
    }

    private fun observeTasks() {
        viewModel.allTasks.observe(this, Observer { tasks ->
            taskAdapter.submitList(tasks)
        })
    }

    private fun setupAddButton() {
        binding.addTaskButton.setOnClickListener {
            showAddTaskDialog()
        }
    }
    private fun setupCrashButtons() {
        binding.buttonCrash.setOnClickListener {
            throw RuntimeException("This is a test crash!") // this gets logged in Crashlytics
        }

        binding.buttonDbCrash.setOnClickListener {
            simulateDbCrash()
        }
    }

    private fun simulateDbCrash() {
        val db = TaskDatabase.getDatabase(this)
        val taskDao = db.taskDao()

        // Intentionally do NOT launch a coroutine → simulate crash by violating Room rules
        // So, you can trigger a crash with `runBlocking`
        kotlinx.coroutines.runBlocking {
            taskDao.insert(Task(title = "Crash Task")) // This will throw exception if done improperly
        }
    }




    private fun showEditTaskDialog(task: Task) {
        val input = EditText(this)
        input.setText(task.title)

        val dialog = AlertDialog.Builder(this)
            .setTitle("Edit Task")
            .setMessage("Update task title:")
            .setView(input)
            .setPositiveButton("Save") { _, _ ->
                val updatedTitle = input.text.toString()
                if (updatedTitle.isNotBlank()) {
                    task.title = updatedTitle
                    viewModel.update(task)
                    firebaseAnalytics.logEvent("task_edited", null)
                    Toast.makeText(this, "Task updated", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Title cannot be empty", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Cancel", null)
            .create()
        dialog.show()
    }


    private fun showAddTaskDialog() {
        val input = EditText(this)
        val dialog = AlertDialog.Builder(this)
            .setTitle("New Task")
            .setMessage("Enter task title:")
            .setView(input)
            .setPositiveButton("Add") { _, _ ->
                val title = input.text.toString()
                if (title.isNotBlank()) {
                    viewModel.insert(Task(title = title))
                    firebaseAnalytics.logEvent("task_added", null)
                    Toast.makeText(this, "Task added", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Title cannot be empty", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Cancel", null)
            .create()
        dialog.show()
    }
}
