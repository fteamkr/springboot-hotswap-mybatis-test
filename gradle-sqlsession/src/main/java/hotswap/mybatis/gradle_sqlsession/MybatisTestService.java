package hotswap.mybatis.gradle_sqlsession;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MybatisTestService {

    private static final String MYBATIS_MAPPER_NAMESPACE = "hotswap.mybatis.gradle_sqlsession.MybatisTestMapper.";

    private final SqlSession sqlSession;

    List<MybatisTestDto.H2InformationSchema> selectH2InformationSchemaTables() {
        return sqlSession.selectList(MYBATIS_MAPPER_NAMESPACE + "selectH2InformationSchemaTables");
    }
}
