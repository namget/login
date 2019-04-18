package com.namget.logintest.data.db.dao

import androidx.room.Dao

@Dao
interface WriteDao : BaseDao<Object> {

//    @Query("SELECT * FROM writeData WHERE id = :id")
//    fun selectById(id: Int): WriteDataEntity
//
//    @Query("SELECT COUNT() FROM writeData where date = :date")
//    fun selectCountByDate(date: String): Int
//
//    @Query("SELECT * FROM writeData where date = :date ORDER BY id DESC")
//    fun selectByDate_IdDESC(date: String): MutableList<WriteDataEntity>
//
//    @Query("SELECT * FROM writeData ORDER BY date DESC , id DESC")
//    fun selectAll_DateIdDESC(): LiveData<MutableList<WriteDataEntity>>
//
//
//    @Query("SELECT * FROM writeData")
//    fun selectAll(): MutableList<WriteDataEntity>
//
//    @Query("SELECT * FROM writeData")
//    fun selectAllByLiveData(): LiveData<MutableList<WriteDataEntity>>
//
//    //    @Query("SELECT * FROM writeData WHERE date >= :startDate AND date < :endDate")
//    @Query("SELECT * FROM writeData WHERE Date(date) >= Date(:startDate) AND Date(date) <= Date(:endDate)")
//    fun selectByDatePeriod(startDate: String, endDate: String): LiveData<MutableList<WriteDataEntity>>

}