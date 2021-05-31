package com.dkn.subtiga.helper

import android.database.Cursor
import com.dkn.subtiga.db.db
import com.dkn.subtiga.model.Favourite
import java.util.ArrayList

object MappingHelper {

    fun mapCursorToArrayList(notesCursor: Cursor?): ArrayList<Favourite> {
        val favList = ArrayList<Favourite>()

        notesCursor?.apply {
            while (moveToNext()) {
                val username = getString(getColumnIndexOrThrow(db.FavColumns.USERNAME))
                val name = getString(getColumnIndexOrThrow(db.FavColumns.NAME))
                val avatar = getString(getColumnIndexOrThrow(db.FavColumns.AVATAR))
                val company = getString(getColumnIndexOrThrow(db.FavColumns.COMPANY))
                val location = getString(getColumnIndexOrThrow(db.FavColumns.LOCATION))
                val repository = getInt(getColumnIndexOrThrow(db.FavColumns.REPOSITORY))
                val followers = getInt(getColumnIndexOrThrow(db.FavColumns.FOLLOWERS))
                val following = getInt(getColumnIndexOrThrow(db.FavColumns.FOLLOWING))
                val favourite =
                    getString(getColumnIndexOrThrow(db.FavColumns.FAVOURITE))
                favList.add(
                    Favourite(
                        username,
                        name,
                        avatar,
                        company,
                        location,
                        repository,
                        followers,
                        following,
                        favourite
                    )
                )
            }
        }
        return favList
    }
}