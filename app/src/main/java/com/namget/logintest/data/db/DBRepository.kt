package com.namget.diaryLee.data.db

class DBRepository {
    private var Instance: DBRepository? = null
    private lateinit var database: AppDatabase

    constructor(database: AppDatabase){
        this.database = database
        // do something from server data
    }


    fun getInstance(database : AppDatabase) : DBRepository {
        if(Instance == null){
            synchronized(DBRepository::class){
                Instance = DBRepository(database)
            }
        }
        return Instance!!
    }


}