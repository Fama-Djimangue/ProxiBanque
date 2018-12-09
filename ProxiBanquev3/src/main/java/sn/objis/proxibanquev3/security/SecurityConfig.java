package sn.objis.proxibanquev3.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true) //Pour activer la gestions des roles
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	//public void globalConfig(AuthenticationManagerBuilder auth) throws Exception {
	
	public void globalConfig(AuthenticationManagerBuilder auth, DataSource datasource) throws Exception {
	   
		/*
		 *  ICI C'EST KAN ON GARDE LES USERS EN MEMOIR et non EN BDD
		
		 auth.inMemoryAuthentication().withUser("admin").password("123").roles("ADMIN", "PROF");
		auth.inMemoryAuthentication().withUser("prof").password("123").roles("PROF");
		auth.inMemoryAuthentication().withUser("etu").password("123").roles("ETUDIANT");
		auth.inMemoryAuthentication().withUser("scol").password("123").roles("SCOLARITE"); */
		

		// ON BOSS AVEC LES USER DANs LA BDD
		auth.jdbcAuthentication()
		.dataSource(datasource)
		.usersByUsernameQuery("select username as principal, password as credentials, actived from users where username=?")
		.authoritiesByUsernameQuery("select user_username  as principal, roles_role  as role from users_roles where user_username=?")
		.rolePrefix("");
		//.passwordEncoder(new Md5PasswordEncoder());
	
		
	
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/css/**").permitAll()
		.antMatchers("/images/**").permitAll()
		.antMatchers("/js/**").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.defaultSuccessUrl("/clients.html")
		.and()
		.logout()
		.invalidateHttpSession(true)
		.logoutUrl("/logout")
		.permitAll()
		;
		
	}

}
