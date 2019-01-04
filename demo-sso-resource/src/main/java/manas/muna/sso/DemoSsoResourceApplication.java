package manas.muna.sso;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoSsoResourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSsoResourceApplication.class, args);
	}
	
	@Value("${services.auth}")
    private String authService;

    @Bean
    public FilterRegistrationBean jwtFilters() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.setInitParameters(Collections.singletonMap("services.auth", authService));
        registrationBean.addUrlPatterns("/protected-resource");

        return registrationBean;
    }

}

