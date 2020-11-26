package com.zzyy.vhr.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzyy.vhr.model.Hr;
import com.zzyy.vhr.model.RespBean;
import com.zzyy.vhr.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.CropImageFilter;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    HrService hrService;
    @Autowired
    MyFilter myFilter;
    @Autowired
    MyAccessDecisionManager myAccessDecisionManager;

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(hrService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception{
         web.ignoring().antMatchers("/login");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //.anyRequest().authenticated()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setAccessDecisionManager(myAccessDecisionManager);
                        o.setSecurityMetadataSource(myFilter);
                        return o;
                    }
                })
                .and()
                .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/doLogin") //处理登陆post页面
                .loginPage("/login") //处理登陆页面
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                      //登陆成功
                        resp.setContentType("application/json;charset=UTF-8");
                        PrintWriter out =  resp.getWriter();
                        //获取登陆对象
                        Hr hr = (Hr) authentication.getPrincipal();
                        RespBean rb = RespBean.ok("登陆成功",hr);
                        //将登陆对象以json格式返回
                        String s = new ObjectMapper().writeValueAsString(rb);
                        out.write(s);
                        out.flush();
                        out.close();
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    //登陆失败的处理
                    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
                        resp.setContentType("application/json;charset=UTF-8");
                        PrintWriter out =  resp.getWriter();

                        RespBean rb = RespBean.error("登陆失败");
                        if(e instanceof LockedException)
                            rb.setMsg("账户被锁定");
                        else if(e instanceof CredentialsExpiredException)
                            rb.setMsg("密码过期");
                        else if(e instanceof AccountExpiredException)
                            rb.setMsg("账户过期");
                        else if(e instanceof DisabledException)
                            rb.setMsg("账户被禁用");
                        else if(e instanceof BadCredentialsException)
                            rb.setMsg("用户名或密码错误");
                        //将错误信息以json格式返回
                        String s = new ObjectMapper().writeValueAsString(rb);
                        out.write(s);
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and()
                .logout()
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                       //注销的处理
                        resp.setContentType("application/json;charset=UTF-8");
                        PrintWriter out =  resp.getWriter();

                        RespBean rb = RespBean.ok("注销成功");
                        //将登陆对象以json格式返回
                        String s = new ObjectMapper().writeValueAsString(rb);
                        out.write(s);
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and()
                .csrf().disable()
                //遇到异常后的处理
                .exceptionHandling().
                //没有认证时，在这里处理结果，不需要进行重定向
                authenticationEntryPoint(new AuthenticationEntryPoint() {
            @Override
            public void commence(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
                resp.setContentType("application/json;charset=UTF-8");
                //未授权
                resp.setStatus(401);
                PrintWriter out =  resp.getWriter();

                RespBean rb = RespBean.error("访问失败");
                if(e instanceof InsufficientAuthenticationException)
                    rb.setMsg("未登陆，请登陆");

                //将错误信息以json格式返回
                String s = new ObjectMapper().writeValueAsString(rb);
                out.write(s);
                out.flush();
                out.close();
            }
        });
    }

}
