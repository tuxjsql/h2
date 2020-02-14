package dev.tuxjsql.h2;

import dev.tuxjsql.basic.sql.where.BasicSubWhereStatement;
import dev.tuxjsql.basic.sql.where.BasicWhereResponse;
import dev.tuxjsql.basic.sql.where.WhereUtils;
import dev.tuxjsql.core.TuxJSQL;


public class H2SubWhereStatement<T> extends BasicSubWhereStatement<T> {
    private BasicWhereResponse response;
    public H2SubWhereStatement(T and, TuxJSQL core) {
        super(and, core);
    }

    public H2SubWhereStatement(TuxJSQL core) {
        super(core);
    }

    @Override
    public String getQuery() {
        if(whereObjects.isEmpty()) return "";
        if(response==null){
            response = WhereUtils.doubleBuild(whereObjects.toArray(),table);
        }
        return response.getQuery();
    }

    @Override
    public Object[] getValues() {
        if(whereObjects.isEmpty()) return whereObjects.toArray();
        if(response==null){
            response = WhereUtils.doubleBuild(whereObjects.toArray(),table);
        }
        return response.getValues();
    }

}
