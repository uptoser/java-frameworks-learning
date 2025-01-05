package com.uptoser.ssm.spring.c2.bean.main;

import com.uptoser.ssm.spring.c1.ioc.bean.lifecycle.BeanLifecycleJuiceMaker;
import com.uptoser.ssm.spring.c2.bean.annotation.config.ApplicationConfig;
import com.uptoser.ssm.spring.c2.bean.annotation.controller.RoleController;
import com.uptoser.ssm.spring.c2.bean.annotation.controller.RoleController2;
import com.uptoser.ssm.spring.c2.bean.annotation.pojo.Role;
import com.uptoser.ssm.spring.c2.bean.annotation.service.RoleDataSourceService;
import com.uptoser.ssm.spring.c2.bean.annotation.service.RoleService;
import com.uptoser.ssm.spring.c2.bean.annotation.service.RoleService2;
import com.uptoser.ssm.spring.c2.bean.el.pojo.ElBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.AbstractEnvironment;

/**
 * 在Spring中，它提供了两种方式来让Spring IoC容器发现Bean。
 * ●组件扫描：通过定义资源的方式，让 Spring IoC 容器扫描对应的包，从而把 Bean装配进来。
 * ●自动装配：通过注解定义，使得一些依赖关系可以通过注解完成。
 * <p>
 * spring提供了4种作用域，它会根据情况来决定是否生成新的对象。
 * ●单例（singleton）：它是默认的选项，在整个应用中，Spring 只为其生成一个 Bean的实例。
 * ●原型（prototype）：当每次注入，或者通过Spring IoC容器获取Bean时，Spring都会为它创建一个新的实例。
 * ●会话（session）：在Web应用中使用，就是在会话过程中Spring只创建一个实例。
 * ●请求（request）：在Web应用中使用的，就是在一次请求中Spring会创建一个实例，但是不同的请求会创建不同的实例。
 */
public class AnnotationMain {
    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
//        String[] beanDefinitionNames = context.getBeanDefinitionNames();
//        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
        System.out.println();
        Role role = context.getBean(Role.class);
        RoleService roleService = context.getBean("roleServiceImpl", RoleService.class);
        roleService.printRoleInfo(role);
        System.out.println("------自动装配@Autowired------");
        RoleService2 roleService2 = context.getBean("roleService2", RoleService2.class);
        roleService2.printRoleInfo();
        System.out.println("------@Primary和@Qualifier------");
        RoleController roleController = context.getBean(RoleController.class);
        roleController.printRole(role);
        System.out.println("------Bean的作用域------");
        /*
         * Spring提供了4种作用域，它会根据情况来决定是否生成新的对象。
         * ●单例（singleton）：它是默认的选项，在整个应用中，Spring 只为其生成一个 Bean的实例。
         * ●原型（prototype）：当每次注入，或者通过Spring IoC容器获取Bean时，Spring都会为它创建一个新的实例。
         * ●会话（session）：在Web应用中使用，就是在会话过程中Spring只创建一个实例。
         * ●请求（request）：在Web应用中使用的，就是在一次请求中Spring会创建一个实例，但是不同的请求会创建不同的实例。
         */
        RoleController roleController2 = context.getBean(RoleController.class);
        System.out.println("controller1和controller2是否是同一个对象："+(roleController2==roleController));
        RoleController2 roleController3 = context.getBean(RoleController2.class);
        RoleController2 roleController4 = context.getBean(RoleController2.class);
        System.out.println("controller3和controller4是否是同一个对象："+(roleController3==roleController4));
        context.close();
    }

    /**
     * 通过Bean注解装配
     * 自定义初始化方法。
     * 自定义销毁方法。
     */
    @Test
    public void juiceMaker2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        BeanLifecycleJuiceMaker juiceMaker2 = context.getBean("lifecycle", BeanLifecycleJuiceMaker.class);
        System.out.println(juiceMaker2.makeJuice());
        context.close();
    }
    /**
     * 通过环境来获取对应的配置属性，但是如果仅仅这样，在Spring中是没有解析属性占位符的能力，
     * Spring 推荐使用一个属性文件解析类进行处理，它就是 PropertySources PlaceholderConfigurer，
     * 使用它就意味着允许Spring解析对应的属性文件，并通过占位符去引用对应的配置
     */
    @Test
    public void getProperty() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);
        String url = context.getEnvironment().getProperty("jdbc.database.url");
        System.out.println(url);
    }
    /***
     * 测试注解引入XML
     */
    @Test
    public void importResource() {
        // 设置活动的配置文件
        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "dev");
        System.out.println("-------DataSource-Dev------\n");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        RoleDataSourceService roleDataSourceService = context.getBean(RoleDataSourceService.class);
        Role role = roleDataSourceService.getRole(1L);
        System.out.println(role);
        context.close();
    }

    /**
     * 使用Spring表达式（Spring EL）
     */
    @Test
    public void el(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ElBean bean = context.getBean("elBean",ElBean.class);
        System.out.println(bean);
    }


}
