package dev.tuxjsql.h2;

import dev.tuxjsql.basic.builders.BasicTableBuilder;
import dev.tuxjsql.core.TuxJSQL;
import dev.tuxjsql.core.builders.ColumnBuilder;
import dev.tuxjsql.core.sql.SQLTable;

import java.util.stream.Collectors;

public class H2TableBuilder extends BasicTableBuilder {
    public H2TableBuilder(TuxJSQL jsql) {
        super(jsql);
    }

    @Override
    public SQLTable createTable() {
        H2Table table = new H2Table(getJsql(), getName(), getColumnBuilders().stream().map(ColumnBuilder::build).collect(Collectors.toList()));
        getJsql().getExecutor().execute(table::prepareTable);
        table.prepareTable();
        getJsql().addTable(table);
        return table;
    }
}
