package pe.com.sedapal.scr.web.configuration;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@Configuration //   DESCOMENTAR EN PRODUCCION  
//@EnableWebMvc  //   DESCOMENTAR EN PRODUCCION  
public class MvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    /*		//   DESCOMENTAR EN PRODUCCION   
    	registry.addResourceHandler("/js/**") 
               .addResourceLocations("classpath:/static/js/") 
               .setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS));
    	registry.addResourceHandler("/images/**") 
	        .addResourceLocations("classpath:/static/images/") 
	        .setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS));
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/")
		        .setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS));
    */
    }
}