package com.appmattus.markdown.rules

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature

object BlanksAroundHeadersRuleTest : Spek({
    Feature("BlanksAroundHeadersRule") {
        FileRuleScenario { BlanksAroundHeadersRule() }
    }
})
