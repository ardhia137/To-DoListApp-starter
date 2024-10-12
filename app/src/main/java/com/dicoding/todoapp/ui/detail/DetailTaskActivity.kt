package com.dicoding.todoapp.ui.detail

import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.dicoding.todoapp.R
import com.dicoding.todoapp.ui.ViewModelFactory
import com.dicoding.todoapp.utils.DateConverter
import com.google.android.material.textfield.TextInputEditText

class DetailTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_detail)

        //TODO 11 : Show detail task and implement delete action
        val taskId = intent.getIntExtra("TASK_ID",0)
        val factory: ViewModelFactory = ViewModelFactory.getInstance(this)
        val viewModel: DetailTaskViewModel by viewModels { factory }
        viewModel.setTaskId(taskId)
        val titleEditText: TextInputEditText = findViewById(R.id.detail_ed_title)
        val descriptionEditText: TextInputEditText = findViewById(R.id.detail_ed_description)
        val dueDateEditText: TextInputEditText = findViewById(R.id.detail_ed_due_date)
        val deleteButton: Button = findViewById(R.id.btn_delete_task)
        viewModel.task.observe(this, Observer{ task ->
            titleEditText.setText(task.title)
            descriptionEditText.setText(task.description)
            dueDateEditText.setText(DateConverter.convertMillisToString(task.dueDate))
        })
        deleteButton.setOnClickListener{
            viewModel.deleteTask()
        }
    }
}