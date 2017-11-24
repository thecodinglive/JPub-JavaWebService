package info.thecodinglive.config;


import info.thecodinglive.controller.ExecuteTimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.resource.*;
import org.springframework.web.util.UrlPathHelper;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private Environment env;

    @Bean
    public LocaleResolver localeResolver() {
        return new SessionLocaleResolver();
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(localeChangeInterceptor());
        registry.addInterceptor(executeTimeInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/");
    }

    @Bean
    public ExecuteTimeInterceptor executeTimeInterceptor() {
        return new ExecuteTimeInterceptor();
    }


    @Bean
    public ResourceUrlEncodingFilter resourceUrlEncodingFilter() {
        return new ResourceUrlEncodingFilter();
    }


    /**
     * semicolon이 제거되지 않도록 하는 설정
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
        configurer.setUseRegisteredSuffixPatternMatch(true);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        boolean devMode = this.env.acceptsProfiles("dev");
        boolean useResourceCache = !devMode;
        Integer cachePeriod = devMode ? 0 : null;

        registry.addResourceHandler("/assets/**")
                .addResourceLocations("classpath:/assets/", "/assets/")
                .setCachePeriod(3600)  //60 * 60 * 24 * 365 1year
                .resourceChain(true)
                //.addResolver(new GzipResourceResolver())
                //.addResolver(new VersionResourceResolver().addContentVersionStrategy("/**"))
                .addResolver(new VersionResourceResolver().addVersionStrategy(new ContentVersionStrategy(), "/**"))
                //.addResolver(new WebJarsResourceResolver())
                .addTransformer(new AppCacheManifestTransformer());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
    }
}
