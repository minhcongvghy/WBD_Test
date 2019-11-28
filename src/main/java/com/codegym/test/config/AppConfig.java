package com.codegym.test.config;

//import com.codegym.penzuproject.service.IDiaryService;
//import com.codegym.penzuproject.service.IRoleService;
//import com.codegym.penzuproject.service.ITagService;
//import com.codegym.penzuproject.service.IUserService;
//import com.codegym.penzuproject.service.Impl.DiaryServiceImpl;
//import com.codegym.penzuproject.service.Impl.RoleServiceImpl;
//import com.codegym.penzuproject.service.Impl.TagServiceImpl;
//import com.codegym.penzuproject.service.Impl.UserServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

@Configuration
@EnableWebMvc
//@PropertySource("classpath:application.properties")
public class AppConfig implements WebMvcConfigurer {
//
//    //upload file
//    @Autowired
//    Environment env;
//
//    // Cấu hình để sử dụng các file nguồn tĩnh (css, image, ..)
////    @Override
////    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////
////        String fileUpload = env.getProperty("file_upload").toString();
////
////        // Image resource.
////        registry.addResourceHandler("/i/**") //
////                .addResourceLocations("file:" + fileUpload);
////
////    }
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry
//                .addResourceHandler("/assets/**")
//                .addResourceLocations("/assets/");
//
//        registry
//                .addResourceHandler("/uploads/**")
//                .addResourceLocations("file:/home/dotranghoang/Desktop/image/");
//    }
//
//    //Config FileUpload
//    @Bean(name = "multipartResolver")
//    public CommonsMultipartResolver getResolver() throws IOException {
//        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//
//        //Set the maximum allowed size (in bytes) for each individual file.
//        resolver.setMaxUploadSizePerFile(5242880);//5MB
//
//        //You may also set other available properties.
//
//        return resolver;
//    }



//    @Bean
//    public IUserService userService() {
//        return new UserServiceImpl();
//    }
//
//    @Bean
//    public IRoleService roleService() {
//        return new RoleServiceImpl();
//    }
//
//    @Bean
//    public IDiaryService diaryService() {
//        return new DiaryServiceImpl();
//    }
//
//    @Bean
//    public ITagService tagService() {
//        return new TagServiceImpl();
//    }
}
