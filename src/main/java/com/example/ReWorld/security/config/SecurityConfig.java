package com.example.ReWorld.security.config;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.ReWorld.security.google.CustomOAuth2UserService;
import com.example.ReWorld.security.services.IUserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private IUserService userService;

	@Bean
	public RestAuthenticationEntryPoint restServicesEntryPoint() {
		return new RestAuthenticationEntryPoint();
	}

	@Bean
	public CustomAccessDeniedHandler customAccessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .httpBasic(httpBasic -> httpBasic.authenticationEntryPoint(restServicesEntryPoint()))
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/**", "/oauth2/**", "/css/**", "/js/**", "/fonts/**", "/images/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                .formLogin((form) -> form
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .loginPage("/login").failureUrl("/login?error=true").permitAll())
                .rememberMe((rememberMe) -> rememberMe
                        .rememberMeParameter("remember")
                        .tokenValiditySeconds(86400 * 30)
                        .userDetailsService(userService))
                .oauth2Login(oauth2Customize -> oauth2Customize
                        .loginPage("/login")
                        .userInfoEndpoint()
                        .userService(oauthUserService)
                        .and()
                        .successHandler(new AuthenticationSuccessHandler() {
                            @Override
                            public void onAuthenticationSuccess(HttpServletRequest request,
                                                                                        HttpServletResponse response, Authentication authentication)
                                    throws IOException, ServletException {
                                response.sendRedirect("/home");
                            }
                        }))
                .formLogin(login -> login // Configure form-based login again for your custom login page
                        .loginPage("/login")
                        .successHandler(new AuthenticationSuccessHandler() {
                            @Override
                            public void onAuthenticationSuccess(HttpServletRequest request,
                                                                                HttpServletResponse response, Authentication authentication)
                                    throws IOException, ServletException {
                                response.sendRedirect("/home");
                            }
                        })
                        .permitAll())
                .logout(logout -> logout
                        .logoutSuccessUrl("/login")
                        .deleteCookies("JSESSIONID")
                        .invalidateHttpSession(true))
                .exceptionHandling(handling -> handling
                        .accessDeniedHandler(customAccessDeniedHandler()))
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));
	    return http.build();
	}


	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	@Autowired
	private CustomOAuth2UserService oauthUserService;
}
