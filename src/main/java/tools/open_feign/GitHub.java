package tools.open_feign;

import feign.Param;
import feign.RequestLine;
import java.util.List;

/**
 * @Author lx
 * @Date 2018/10/14 16:33
 */
public interface GitHub {
    @RequestLine("GET /repos/{owner}/{repo}/contributors")
    List<Contributor> contributors(@Param("owner") String owner, @Param("repo") String repo);
}
