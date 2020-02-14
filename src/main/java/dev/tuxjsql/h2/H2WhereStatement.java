package dev.tuxjsql.h2;

import dev.tuxjsql.basic.sql.where.BasicWhereResponse;
import dev.tuxjsql.basic.sql.where.BasicWhereStatement;
import dev.tuxjsql.basic.sql.where.WhereUtils;
import dev.tuxjsql.core.TuxJSQL;

public class H2WhereStatement<T> extends BasicWhereStatement<T> {
    private BasicWhereResponse response;

    public H2WhereStatement(T and, TuxJSQL core) {
        super(and, core);
    }

    public H2WhereStatement(TuxJSQL core) {
        super(core);
    }

    @Override
    public String getQuery() {
        if (response == null) {
            response = WhereUtils.doubleBuild(whereObjects.toArray(), table);
        }
        return response.getQuery();
    }

    @Override
    public Object[] getValues() {
        if (response == null) {
            response = WhereUtils.doubleBuild(whereObjects.toArray(), table);
        }
        return response.getValues();
    }
}
