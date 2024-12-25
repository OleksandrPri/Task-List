package com.example.tasklist

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar

class ActivityAddTask : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_task)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn_confirm_task: Button = findViewById(R.id.btn_confirm_task)
        val btn_cancel_task: Button = findViewById(R.id.btn_cancel_task)
        val pickDateBtn: Button = findViewById(R.id.idBtnPickDate)
        val pickTimeBtn: Button = findViewById(R.id.idBtnPickTime)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        pickDateBtn.text = day.toString() + "-" + month.toString() + "-" + year.toString()

        btn_cancel_task.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btn_confirm_task.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        pickDateBtn.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                this,
                { view, year, monthOfYear, dayOfMonth ->
                    pickDateBtn.text =
                        (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }

        pickTimeBtn.setOnClickListener {
            val c = Calendar.getInstance()

            val hour = c.get(Calendar.HOUR_OF_DAY)
            val minute = c.get(Calendar.MINUTE)

            val timePickerDialog = TimePickerDialog(
                this,
                { view, hourOfDay, minute ->
                    pickTimeBtn.setText("$hourOfDay:$minute")
                },
                hour,
                minute,
                false
            )
            timePickerDialog.show()
        }
    }
}