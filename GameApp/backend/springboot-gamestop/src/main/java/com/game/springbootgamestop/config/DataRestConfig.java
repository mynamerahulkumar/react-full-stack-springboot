package com.game.springbootgamestop.config;

import com.game.springbootgamestop.entity.Game;
import com.game.springbootgamestop.entity.Review;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {

    public String allowedOrigin="http://localhost:8080";

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config,
                                                     CorsRegistry cors){
        HttpMethod[] unSupportedActions={HttpMethod.POST,HttpMethod.PUT,HttpMethod.DELETE,HttpMethod.PATCH};

        config.exposeIdsFor(Game.class);
        config.exposeIdsFor(Review.class);
        disableHttpMethods(Game.class,config,unSupportedActions);
        disableHttpMethods(Review.class,config,unSupportedActions);
        /**
         * add cors mapping
         */
        cors.addMapping(config.getBasePath()+"/**")
                .allowedOrigins(allowedOrigin);

    }

    public void disableHttpMethods(Class theClass,RepositoryRestConfiguration config,
                                   HttpMethod[] unSupportedActions){
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(unSupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unSupportedActions));

    }
}
