package com.guzzardi.dictionaryapp.presentation.views.definitions

import com.guzzardi.dictionaryapp.presentation.RobolectricTest
import org.junit.Assert.*
import org.junit.Test

class DefinitionsRecyclerViewTest: RobolectricTest() {

    @Test
    fun `setData assign DefinitionsAdapter to recyclerView`() {
        val recyclerView = DefinitionsRecyclerView(context)
        assertNull(recyclerView.adapter)

        recyclerView.setData(emptyList())

        assertNotNull(recyclerView.adapter)
        assertTrue(recyclerView.adapter is DefinitionsAdapter)
    }
}