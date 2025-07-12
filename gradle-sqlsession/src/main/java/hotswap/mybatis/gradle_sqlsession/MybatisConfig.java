package hotswap.mybatis.gradle_sqlsession;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * MyBatis Config
 *
 * @see <a href="https://mybatis.org/spring/getting-started.html">MyBatis-Spring - Getting Started</a>
 * @see <a href="https://mybatis.org/spring/sqlsession.html">MyBatis-Spring - Using an SqlSession</a>
 */
@Configuration
public class MybatisConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setDefaultFetchSize(200);

        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setConfiguration(configuration);
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:**/*Mapper.xml"));
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
