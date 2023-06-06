package im.zhaojun.zfile.core.config;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * MyBatis 数据库别名配置, 用于在 Mapper 中根据不同数据库执行不同的 SQL 语句.
 */
@Component
public class MyDatabaseIdProvider implements DatabaseIdProvider {

    private static final String DATABASE_MYSQL = "MySQL";
    private static final String DATABASE_SQLITE = "SQLite";

    @Override
    public String getDatabaseId(DataSource dataSource) throws SQLException {
        Connection conn = dataSource.getConnection();
        String dbName = conn.getMetaData().getDatabaseProductName();
        String dbAlias = "";
        switch (dbName) {
            case DATABASE_MYSQL:
                dbAlias = "mysql";
                break;
            case DATABASE_SQLITE:
                dbAlias = "sqlite";
                break;
            default:
                break;
        }
        return dbAlias;
    }

}
