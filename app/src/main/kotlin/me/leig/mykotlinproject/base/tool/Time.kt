package me.leig.mykotlinproject.base.tool

import java.util.*


/**
 *
 *
 * @author leig
 * @version 20170301
 *
 */
 
class Time {

    /**
     * 增加时间
     *
     */
    fun addTime(num: Int, date: Date = Date()): Date {
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.add(Calendar.SECOND, num)
        return calendar.time
    }

    fun subTime(startTime: Date = Date(), endTime: Date = Date()): Long {
        return (endTime.time - startTime.time) / 1000
    }
}