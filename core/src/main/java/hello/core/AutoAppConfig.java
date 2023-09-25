package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {
/**
    // 자동빈과 수동빈 등록에서 빈 이름이 충돌날 경우 - 수동빈 등록이 우선 된다.
    // 하지만 추천하지 않는다. 이럴 경우가 많을 경우 여러 설정이 꼬이는 문제가 발생한다.
    // 최근 스프링 부트에서는 수동 빈과 자동 빈이 충돌날 경우 오류 발생하도록 바뀌었다.
    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
 */
}
