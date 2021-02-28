package com.example.myapplication.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "task_table")
@Parcelize
data class Task(
    val job_name: String,
    val job_salary: String,
    val job_loc: String,
    val job_type: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
) :Parcelable {

}
