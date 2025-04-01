package project.abc123.semiprojectv2.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import project.abc123.semiprojectv2.jwt.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    //private final UserDetailsService userDetailsService;
    //private final CustomAuthenticationSuccessHandler successHandler;
    //private final CustomAuthenticationFailureHandler failureHandler;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // CSRF 필터 끔
                //.userDetailsService(userDetailsService) // userDetailsService 설정
                .authorizeRequests() // URL 기반 인가 설정
                .antMatchers("/", "/api/auth/**", "/gallery/**", "/api/board/**").permitAll() // 인증/인가 여부와 상관없이 접근 가능
                .and()
//            .formLogin()  // form login 인증 사용
//                .loginPage("/member/login")  // 커스텀 로그인 페이지 경로
//                .usernameParameter("userid") // 아이디 매개변수 지정 !!
//                .passwordParameter("passwd") // 비밀번호 매개변수 지정 !!
//                .defaultSuccessUrl("/member/myinfo") // 로그인 성공시 리다이렉트 URL
//                .failureUrl("/member/loginfail") // 로그인 실패시 리다이렉트 URL
//                .successHandler(successHandler)
//                .failureHandler(failureHandler)
//            .and()
//            .logout()// 로그아웃 설정
//                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout")) // 로그아웃 URL 지정
//                .logoutSuccessUrl("/") // 로그아웃 성공후 리다이렉트될 URL
//                .invalidateHttpSession(true) // 세션 무효화
//                .deleteCookies("JSESSIONID"); // JSESSIONID 쿠키 삭제

                .sessionManagement() // JWT 인증을 위해 STATELESS 설정
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // JWT 필터 설정
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() { // 비밀번호 암호화에 사용할 인코더
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}