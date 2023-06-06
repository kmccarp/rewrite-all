/*
 * Copyright 2023 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openrewrite.table;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParseFailureAnalysisTest {

    @Test
    void generatesMessage() {
        String msg = ParseFailureAnalysis.getAnalysisMessage("someNodeType");
        assertThat(msg).isEqualTo("Unable to parse node of type {{someNodeType}}");

        String msgWithSnipper = ParseFailureAnalysis.getAnalysisMessage("someNodeType", "someSnippet");
        assertThat(msgWithSnipper).isEqualTo("Unable to parse node of type {{someNodeType}} at: someSnippet");
    }

    @Test
    void returnsNodeType() {
        String msg = ParseFailureAnalysis.getAnalysisMessage("someNodeType");
        assertThat(ParseFailureAnalysis.getErrorName(msg)).isEqualTo("someNodeType");
    }

    @Test
    void returnsSnippet() {
        String msg = ParseFailureAnalysis.getAnalysisMessage("someNodeType", "someSnippet");
        assertThat(ParseFailureAnalysis.getSourceSnippet(msg)).isEqualTo("someSnippet");
    }
}
