package dev.tuxjsql.h2;

import dev.tuxjsql.core.sql.select.JoinType;

public enum H2JoinTypes {
    INNER("INNER JOIN", JoinType.INNER),
    LEFT("LEFT JOIN", JoinType.LEFT),
    RIGHT("RIGHT JOIN", JoinType.RIGHT),
    FULL("FULL JOIN", JoinType.FULL);


    private String key;
    private JoinType joinType;

    public String getKey() {
        return key;
    }

    public JoinType getJoinType() {
        return joinType;
    }

    H2JoinTypes(String key, JoinType joinType) {
        this.key = key;
        this.joinType = joinType;
    }

    public static H2JoinTypes getType(JoinType type) {
        for (H2JoinTypes sqliteJoin : values()) {
            if (sqliteJoin.joinType == type) return sqliteJoin;
        }
        return null;
    }
}
