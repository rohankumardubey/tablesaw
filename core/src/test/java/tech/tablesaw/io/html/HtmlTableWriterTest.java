/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tech.tablesaw.io.html;

import org.junit.Before;
import org.junit.Test;
import tech.tablesaw.aggregate.AggregateFunctions;
import tech.tablesaw.api.CategoricalColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.io.csv.CsvReadOptions;
import tech.tablesaw.table.ViewGroup;

public class HtmlTableWriterTest {

    private Table table;

    @Before
    public void setUp() throws Exception {
        table = Table.read().csv(CsvReadOptions.builder("../data/BushApproval.csv"));
    }

    @Test
    public void testWrite() {
        CategoricalColumn byColumn = table.categoricalColumn("who");
        ViewGroup group = new ViewGroup(table, byColumn);
        Table result = group.agg("approval", AggregateFunctions.mean);
        HtmlTableWriter.write(result);
    }
}
