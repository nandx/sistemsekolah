package com.sistem.sekolah.security;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//@Configuration
//@EnableWebSecurity
//public class Security extends WebSecurityConfigurerAdapter {
public class Security {

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/login").permitAll().antMatchers("/admin/**")
//				.authenticated().antMatchers("/siswa/**").authenticated().antMatchers("/guru/**").authenticated().and()
//				.csrf().disable().formLogin().loginPage("/login").defaultSuccessUrl("/secure")
//				.failureUrl("/login?error=true").usernameParameter("username").passwordParameter("password").and()
//				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/").and()
//				.exceptionHandling().accessDeniedPage("/access-denied");
//	}

//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//		UserDetails user = User.withDefaultPasswordEncoder().username("1").password("1").roles("ROLE_USER").build();
//		return new InMemoryUserDetailsManager(user);
//	}

//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/css/**", "/img/**", "/js/**", "/scss/**", "/vendor/**");
//	}
}
