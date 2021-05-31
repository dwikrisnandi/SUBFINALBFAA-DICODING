package com.dkn.subtiga.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.dkn.subtiga.db.db.FavColumns.Companion.TABLE_NAME

internal class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "dbSosDev"
        private const val DATABASE_VERSION = 1
        private const val SQL_CREATE_TABLE_NOTE = "CREATE TABLE $TABLE_NAME" +
                " (${db.FavColumns.USERNAME} TEXT PRIMARY KEY  NOT NULL," +
                " ${db.FavColumns.NAME} TEXT NOT NULL," +
                " ${db.FavColumns.AVATAR} TEXT NOT NULL," +
                " ${db.FavColumns.COMPANY} TEXT NOT NULL," +
                " ${db.FavColumns.LOCATION} TEXT NOT NULL," +
                " ${db.FavColumns.REPOSITORY} INTEGER NOT NULL," +
                " ${db.FavColumns.FOLLOWERS} INTEGER NOT NULL," +
                " ${db.FavColumns.FOLLOWING} INTEGER NOT NULL," +
                " ${db.FavColumns.FAVOURITE} TEXT NOT NULL)"
    }

    // create the SQLite database table
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_TABLE_NOTE)
    }

    // if the table of database is exist, this function will delete it
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
}