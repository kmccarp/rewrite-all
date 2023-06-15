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

import lombok.Value;
import org.openrewrite.Column;
import org.openrewrite.DataTable;
import org.openrewrite.Recipe;

public class LanguageCompositionPerFile extends DataTable<LanguageCompositionPerFile.Row> {

    public LanguageCompositionPerFile(Recipe recipe) {
        super(recipe, "Per-file language composition report",
                "A list of individual files and their language composition.");
    }

    @Value
    public static class Row {
        @Column(displayName = "Source path",
                description = "The path to the source file.")
        String sourcePath;

        @Column(displayName = "Language",
                description = "The language of the source file.")
        String language;

        @Column(displayName = "Class",
                description = "The OpenRewrite class that was parsed for this source file.")
        String parserClass;

        @Column(displayName = "Lines of text",
                description = "The number of lines of text in the source file. " +
                        "No language-specific knowledge to skip comments, blank lines, or any other non-code line.")
        Integer linesOfText;

        @Column(displayName = "Has parse failures",
                description = "True if the file failed to parse, otherwise false.")
        Boolean hasParseFailures;
    }
}
