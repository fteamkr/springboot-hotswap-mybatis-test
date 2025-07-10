package hotswap.mybatis.gradle_sqlsession;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

public class MybatisTestDto {

    @Getter
    @Setter
    @EqualsAndHashCode
    public static class H2InformationSchema {

        String tableCatalog;

        String tableSchema;

        String tableName;

        String tableType;

    }
}
