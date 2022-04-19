package cl.multiverso.spring.web;


import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.*;

/**
 * Clase que implementa la interface WebMvcConfigurerWebMvcConfigurer que permite manejar varios idiomas
 * @author saturno
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{
    
    @Bean
    public LocaleResolver localeResolver(){
        var sesionLocaleResolver =  new SessionLocaleResolver();//variable que permite la internacionalizacion
        sesionLocaleResolver.setDefaultLocale(new Locale("es"));//se setea el lenguaje por defecto
        return sesionLocaleResolver;
    }
    
    //interceptor para cambiar el idioma de manera dinamica
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        var localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");//parametro para cambiar de lenguaje
        return localeChangeInterceptor;
    } 
    
    @Override
    public void addInterceptors(InterceptorRegistry registro){
        registro.addInterceptor(localeChangeInterceptor());
    }
    
    /**
     * Metodo que mapea URL
     * @param registro 
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registro){
        registro.addViewController("/").setViewName("index");
        registro.addViewController("/login");
        registro.addViewController("errors/403").setViewName("/errors/403");
    }
    
}//fin clase
