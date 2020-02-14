package dev.tuxjsql.h2;

import dev.tuxjsql.basic.builders.BasicColumnBuilder;
import dev.tuxjsql.core.TuxJSQL;
import dev.tuxjsql.core.sql.SQLColumn;

public class H2ColumnBuilder<T> extends BasicColumnBuilder<T> {
    public H2ColumnBuilder(TuxJSQL tuxJSQL, T andValue) {
        super(tuxJSQL,andValue);
    }

    public H2ColumnBuilder(TuxJSQL tuxJSQL) {
        this(tuxJSQL,null);
    }



    @Override
    public SQLColumn build() {
        return new H2Column(getName(), getDefaultValue(), getDataTypeRules(), isNotNull(), isUnique(), isAutoIncrement(), isPrimaryKey(), getForeignColumn(), getTable(), getType(),tuxJSQL);
    }
}
