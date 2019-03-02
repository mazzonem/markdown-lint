package com.appmattus.markdown.rules

import com.appmattus.markdown.rules.config.HorizontalRuleStyle
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature

object HrStyleRuleTest : Spek({
    Feature("HrStyleRule") {
        FileRuleScenario(listOf("hr_style_dashes.md")) { HrStyleRule(style = HorizontalRuleStyle.Dash) }

        FileRuleScenario(listOf("hr_style_long.md")) { HrStyleRule(style = HorizontalRuleStyle.Exact("_____")) }

        FileRuleScenario(listOf("hr_style_stars.md")) { HrStyleRule(style = HorizontalRuleStyle.Asterisk) }

        FileRuleScenario(exclude = listOf("hr_style_dashes.md", "hr_style_long.md", "hr_style_stars.md")) { HrStyleRule() }
    }
})
