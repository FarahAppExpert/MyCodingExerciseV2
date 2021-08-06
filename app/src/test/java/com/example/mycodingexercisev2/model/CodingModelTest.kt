package com.example.mycodingexercisev2.model

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.junit.Assert.*


@RunWith(JUnit4 :: class)

 class CodingModelTest
{
    lateinit var codingModel: CodingModel
    @Before
    fun setup_test ()
    {
        codingModel = CodingModel(10837, 7, "Hello World")
    }

    @Test
    fun CodingModel_Testing ()
    {
        var userId : Int = 10837
        var id : Int = 7
        var title : String = "Hello World"

        assertEquals(codingModel.userId, (userId))
        assertEquals(codingModel.id, (id))
        assertEquals(codingModel.title, (title))

    }
}

