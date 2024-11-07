package com.example.practic21_olifirenko

import android.content.ContentValues
import android.content.Context
import android.util.Log
import android.widget.Toast

fun saveUserToDatabase(context: Context, name: String, year: Int) {
    val dbHelper = DatabaseHelper(context)
    val db = dbHelper.writableDatabase

    val values = ContentValues().apply {
        put(DatabaseHelper.COLUMN_NAME, name)
        put(DatabaseHelper.COLUMN_YEAR, year)
    }

    val rowId = db.insert(DatabaseHelper.TABLE, null, values)
    if (rowId != -1L) {
        Log.d("Database", "Data saved successfully, Row ID: $rowId")
        Toast.makeText(context, "Данные успешно сохранены", Toast.LENGTH_SHORT).show()
    } else {
        Log.d("Database", "Error saving data")

    }

    db.close()
}