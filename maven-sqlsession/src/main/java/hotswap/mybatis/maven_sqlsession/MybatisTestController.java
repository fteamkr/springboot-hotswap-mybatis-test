package hotswap.mybatis.maven_sqlsession;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
@Slf4j
@RequiredArgsConstructor
public class MybatisTestController {

    private final MybatisTestService service;

    @GetMapping("/selectH2InformationSchemaTables")
    List<MybatisTestDto.H2InformationSchema> selectH2InformationSchemaTables() {
        return service.selectH2InformationSchemaTables();
    }

}
