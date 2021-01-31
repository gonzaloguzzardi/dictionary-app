package com.guzzardi.dictionaryapp.presentation.views.definitions

import android.content.Context
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.FrameLayout
import androidx.test.core.app.ApplicationProvider
import com.guzzardi.dictionaryapp.data.DefinitionItemDto
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = TestApplication::class)
class DefinitionViewHolderTest {

    private val context = ApplicationProvider.getApplicationContext<Context>()

    @Test
    fun `bind correctly displays definition text value`() {
        val viewHolder = createViewHolder()
        val definitionValue = "test definition"

        viewHolder.bind(DefinitionItemDto(definitionValue, "author", 22, 12))

        Assert.assertEquals(VISIBLE, viewHolder.definitionText.visibility)
        Assert.assertEquals(definitionValue, viewHolder.definitionText.text)
    }

    @Test
    fun `bind displays author name following the format "By $author"`() {
        val viewHolder = createViewHolder()
        val authorValue = "author"

        viewHolder.bind(DefinitionItemDto("definition text", authorValue, 22, 12))

        Assert.assertEquals(VISIBLE, viewHolder.authorText.visibility)
        Assert.assertEquals("By $authorValue", viewHolder.authorText.text)
    }

    @Test
    fun `bind correctly displays up votes and down votes`() {
        val viewHolder = createViewHolder()
        val upVotes = 58
        val downVotes = 35

        viewHolder.bind(DefinitionItemDto("definition text", "author", upVotes, downVotes))

        Assert.assertEquals(VISIBLE, viewHolder.upVotes.visibility)
        Assert.assertEquals(upVotes.toString(), viewHolder.upVotes.text)

        Assert.assertEquals(VISIBLE, viewHolder.downVotes.visibility)
        Assert.assertEquals(downVotes.toString(), viewHolder.downVotes.text)
    }

    @Test
    fun `bind with null definition sets definition textview visibility to GONE`() {
        val viewHolder = createViewHolder()

        viewHolder.bind(DefinitionItemDto(null, "author", 22, 12))

        Assert.assertEquals(GONE, viewHolder.definitionText.visibility)
    }

    @Test
    fun `bind with null author sets author textview visibility to GONE`() {
        val viewHolder = createViewHolder()

        viewHolder.bind(DefinitionItemDto("def", null, 22, 12))

        Assert.assertEquals(GONE, viewHolder.authorText.visibility)
    }

    @Test
    fun `bind with null up votes displayes up votes text with value 0`() {
        val viewHolder = createViewHolder()

        viewHolder.bind(DefinitionItemDto("def", "author", null, 12))

        Assert.assertEquals(VISIBLE, viewHolder.upVotes.visibility)
        Assert.assertEquals("0", viewHolder.upVotes.text)
    }

    @Test
    fun `bind with null down votes displayes down votes text with value 0`() {
        val viewHolder = createViewHolder()

        viewHolder.bind(DefinitionItemDto("def", "author", 23, null))

        Assert.assertEquals(VISIBLE, viewHolder.downVotes.visibility)
        Assert.assertEquals("0", viewHolder.downVotes.text)
    }

    private fun createViewHolder() =
        DefinitionViewHolder.create(FrameLayout(context)) as DefinitionViewHolder
}