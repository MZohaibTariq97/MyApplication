package com.example.myapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.myapplication.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun taskDao() : TaskDao

    class Callback @Inject constructor(
        private val database: Provider<TaskDatabase>,
        @ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            //operations
            val dao = database.get().taskDao()
            applicationScope.launch {
                dao.insert(Task(".Net Developer gezocht!", "$5K", "Amsterdam", "Freelancer"))
                dao.insert(Task("Android Developer Needed", "$3K", "Peshawar", "Android"))
                dao.insert(Task("Quality Assurance Needed", "$2K", "Islamabad", "SQA"))
                dao.insert(Task("IOS Developer Needed", "$3K", "Lahore", "Swift"))
            }

        }
    }
}