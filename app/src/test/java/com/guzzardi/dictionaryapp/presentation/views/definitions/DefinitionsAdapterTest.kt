package com.guzzardi.dictionaryapp.presentation.views.definitions

import android.widget.FrameLayout
import com.guzzardi.dictionaryapp.data.model.DefinitionItemDto
import com.guzzardi.dictionaryapp.presentation.RobolectricTest
import org.junit.Assert
import org.junit.Assert.assertTrue
import org.junit.Test

class DefinitionsAdapterTest : RobolectricTest() {

    @Test
    fun `OnCreateViewHolder creates a DefinitionViewHolder`() {
        val adapter = DefinitionsAdapter(emptyList())

        val viewHolder = adapter.onCreateViewHolder(FrameLayout(context), 0)

        assertTrue(viewHolder is DefinitionViewHolder)
    }

    @Test
    fun `OnBindViewHolder binds definition data to DefinitionViewHolder`() {
        val adapter = DefinitionsAdapter(emptyList())
        val viewHolder = adapter.onCreateViewHolder(FrameLayout(context), 0)
        val data = DefinitionItemDto("definition", "author", 5, 2)

        (viewHolder as DefinitionViewHolder).bind(data)

        Assert.assertEquals("definition", viewHolder.definitionText.text)
        Assert.assertEquals("By author", viewHolder.authorText.text)
        Assert.assertEquals("5", viewHolder.upVotes.text)
        Assert.assertEquals("2", viewHolder.downVotes.text)
    }

    @Test
    fun `getItemCount return definitions list size`() {
        val data = DefinitionItemDto("definition", "author", 5, 2)
        val definitions = listOf(data)
        val adapter = DefinitionsAdapter(definitions)

        Assert.assertEquals(definitions.size, adapter.itemCount)
    }
}