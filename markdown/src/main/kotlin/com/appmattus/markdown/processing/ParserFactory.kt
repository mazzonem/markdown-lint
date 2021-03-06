package com.appmattus.markdown.processing

import com.vladsch.flexmark.ext.autolink.AutolinkExtension
import com.vladsch.flexmark.ext.gfm.strikethrough.StrikethroughExtension
import com.vladsch.flexmark.ext.tables.TablesExtension
import com.vladsch.flexmark.parser.Parser
import com.vladsch.flexmark.util.options.MutableDataSet

internal object ParserFactory {
    private val options by lazy {
        MutableDataSet().apply {
            set(Parser.HEADING_NO_ATX_SPACE, true)
        }
    }

    val parser: Parser by lazy {
        Parser.builder(options).extensions(
            listOf(
                TablesExtension.create(),
                StrikethroughExtension.create(),
                AutolinkExtension.create()
            )
        ).build()
    }
}
