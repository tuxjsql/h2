package dev.tuxjsql.h2;

import dev.tuxjsql.basic.builders.BasicSQLBuilder;
import dev.tuxjsql.basic.sql.BasicDataTypes;
import dev.tuxjsql.basic.sql.select.BasicJoinStatement;
import dev.tuxjsql.core.TuxJSQL;
import dev.tuxjsql.core.builders.ColumnBuilder;
import dev.tuxjsql.core.builders.TableBuilder;
import dev.tuxjsql.core.connection.ConnectionProvider;
import dev.tuxjsql.core.connection.ConnectionSettings;
import dev.tuxjsql.core.sql.*;
import dev.tuxjsql.core.sql.select.JoinStatement;
import dev.tuxjsql.core.sql.select.SelectStatement;
import dev.tuxjsql.core.sql.where.SubWhereStatement;
import dev.tuxjsql.core.sql.where.WhereStatement;

import java.io.File;
import java.util.Properties;

public final class H2SQLBuilder extends BasicSQLBuilder {
    public static final String URL = "jdbc:h2:%1$s";
    public static final String JDBC_CLASS = "org.h2.Driver";

    @Override
    public TableBuilder createTable() {
        return new H2TableBuilder(tuxJSQL);
    }

    @Override
    public ColumnBuilder createColumn() {
        return new H2ColumnBuilder(tuxJSQL);
    }

    @Override
    public WhereStatement createWhere() {
        return new H2WhereStatement(tuxJSQL);
    }

    @Override
    public SubWhereStatement createSubWhereStatement() {
        return new H2SubWhereStatement(tuxJSQL);
    }

    @Override
    public <T> WhereStatement<T> createWhere(T t) {
        return new H2WhereStatement<>(t, tuxJSQL);
    }

    @Override
    public <T> SubWhereStatement<T> createSubWhereStatement(T t) {
        return new H2SubWhereStatement<>(t, tuxJSQL);
    }

    @Override
    public SelectStatement createSelectStatement() {
        return new H2SelectStatement(tuxJSQL);
    }

    @Override
    public JoinStatement createJoinStatement(SelectStatement basicSelectStatement) {
        return new BasicJoinStatement(basicSelectStatement);
    }


    @Override
    public UpdateStatement createUpdateStatement() {
        return new H2UpdateStatement(tuxJSQL);
    }

    @Override
    public DeleteStatement createDeleteStatement() {
        return new H2DeleteStatement(tuxJSQL);
    }

    @Override
    public String name() {
        return "H2";
    }

    @Override
    public String jdbcClass() {
        return JDBC_CLASS;
    }


    @Override
    public SQLDataType convertDataType(BasicDataTypes dataType) {
        return dataType;
    }

    @Override
    public InsertStatement createInsertStatement() {
        return new H2InsertStatement(tuxJSQL);
    }

    @Override
    public void configureConnectionProvider(ConnectionProvider provider, Properties userProperties) throws Exception {
        String url;

        File file = new File(userProperties.getProperty("db.file"));
        url = String.format(URL, file.getAbsolutePath());

        if (TuxJSQL.getLogger().isDebugEnabled())
            TuxJSQL.getLogger().debug(String.format("URL:%s", url));
        provider.setup(new ConnectionSettings(jdbcClass(), url), userProperties);
    }

    @Override
    public <T> ColumnBuilder<T> createColumn(T t) {
        return new H2ColumnBuilder<>(tuxJSQL, t);
    }
}
