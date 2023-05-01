package com.zelyder.recyclemap.domain.util

import org.junit.Assert
import org.junit.Test

class UtilsTest {

    @Test
    fun defineShortDateWithoutTimeFormat(){
        val format = Utils.defineDateFormat("12.10.2023")
        val expectedFormat = DateFormat.ShortDateWithoutTime
        Assert.assertEquals(expectedFormat, format)
    }

    @Test
    fun defineShortDateWithoutTimeFormatFirstZero(){
        val format = Utils.defineDateFormat("01.10.2023")
        val expectedFormat = DateFormat.ShortDateWithoutTime
        Assert.assertEquals(expectedFormat, format)
    }

    @Test
    fun defineShortDateWithoutTimeFormatSecondZero(){
        val format = Utils.defineDateFormat("12.01.2023")
        val expectedFormat = DateFormat.ShortDateWithoutTime
        Assert.assertEquals(expectedFormat, format)
    }

    @Test
    fun defineShortDateWithoutTimeFormatFirstOne(){
        val format = Utils.defineDateFormat("1.10.2023")
        val expectedFormat = DateFormat.Undefined
        Assert.assertEquals(expectedFormat, format)
    }

    @Test
    fun defineShortDateWithoutTimeFormatSecondOne(){
        val format = Utils.defineDateFormat("12.1.2023")
        val expectedFormat = DateFormat.Undefined
        Assert.assertEquals(expectedFormat, format)
    }

    @Test
    fun defineShortDateWithoutTimeFormatYearTwo(){
        val format = Utils.defineDateFormat("12.1.23")
        val expectedFormat = DateFormat.Undefined
        Assert.assertEquals(expectedFormat, format)
    }

    @Test
    fun defineFullDateWithoutYearFormat(){
        val format = Utils.defineDateFormat("20 апреля, 11:55")
        val expectedFormat = DateFormat.FullDateWithoutYear
        Assert.assertEquals(expectedFormat, format)
    }

    @Test
    fun defineFullDateWithoutYearFormatMonthShort(){
        val format = Utils.defineDateFormat("20 апр, 11:55")
        val expectedFormat = DateFormat.FullDateWithoutYear
        Assert.assertEquals(expectedFormat, format)
    }

    @Test
    fun undefinedFormat(){
        val format = Utils.defineDateFormat("fdsafdsafas")
        val expectedFormat = DateFormat.Undefined
        Assert.assertEquals(expectedFormat, format)
    }

    @Test
    fun undefinedFormatIfEmpty(){
        val format = Utils.defineDateFormat("")
        val expectedFormat = DateFormat.Undefined
        Assert.assertEquals(expectedFormat, format)
    }

    @Test
    fun undefinedFormatToMillisIsZero() {
        val millis = Utils.timeFormatFromStringToMillis("fdsafdsafas")
        val expectedMillis = 0L
        Assert.assertEquals(expectedMillis, millis)
    }

    @Test
    fun undefinedFormatToMillisIsZeroIfEmpty() {
        val millis = Utils.timeFormatFromStringToMillis("")
        val expectedMillis = 0L
        Assert.assertEquals(expectedMillis, millis)
    }

    @Test
    fun fullDateWithoutYearToMillisIsCorrect() {
        val millis = Utils.timeFormatFromStringToMillis("12.10.2023")
        val expectedMillis = 1697058000000L
        Assert.assertEquals(expectedMillis, millis)
    }

    @Test
    fun fullDateWithoutYearToMillisFirstZero() {
        val millis = Utils.timeFormatFromStringToMillis("01.10.2023")
        val expectedMillis = 1696107600000L
        Assert.assertEquals(expectedMillis, millis)
    }

    @Test
    fun fullDateWithoutYearToMillisSecondZero() {
        val millis = Utils.timeFormatFromStringToMillis("12.01.2023")
        val expectedMillis = 1673470800000L
        Assert.assertEquals(expectedMillis, millis)
    }

    @Test
    fun fullDateWithoutYearToMillisFirstOne() {
        val millis = Utils.timeFormatFromStringToMillis("1.01.2023")
        val expectedMillis = 0L
        Assert.assertEquals(expectedMillis, millis)
    }

    @Test
    fun fullDateWithoutYearToMillisSecondOne() {
        val millis = Utils.timeFormatFromStringToMillis("12.1.2023")
        val expectedMillis = 0L
        Assert.assertEquals(expectedMillis, millis)
    }

    @Test
    fun fullDateWithoutYearToMillisYearTwo() {
        val millis = Utils.timeFormatFromStringToMillis("12.1.23")
        val expectedMillis = 0L
        Assert.assertEquals(expectedMillis, millis)
    }



    @Test
    fun shortDateWithoutTimeFormatToMillisIsCorrect() {
        val millis = Utils.timeFormatFromStringToMillis("20 апреля, 11:55")
        val expectedMillis = 1681980900000L
        Assert.assertEquals(expectedMillis, millis)
    }

    @Test
    fun shortDateWithoutTimeFormatToMillisIsMonthShort() {
        val millis = Utils.timeFormatFromStringToMillis("20 апр, 11:55")
        val expectedMillis = 0L
        Assert.assertEquals(expectedMillis, millis)
    }
}