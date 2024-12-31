package com.uptoser.ssm.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;


@Controller
@RequestMapping("model")
public class ModelAndViewController {

    /**
     * 数据模型
     * ModelAndView内有一个类型为 ModelMap的属性
     * ModelMap继承了LinkedHashMap<String,Object>，因此它可以存放各种键值对
     *
     * 为了进一步定义数据模型功能，Spring还创建了类ExtendedModelMap，
     * 这个类实现了数据模型定义的Model接口，
     * 并且还在此基础上派生了关于数据绑定的类 BindAwareModelMap
     */
    @GetMapping("/model")
    public ModelAndView model(
            /*
            无论使用Model还是ModelMap，它都是BindingAwareModelMap实例，
            而BindingAwareModelMap是一个继承了ModelMap，实现了Model接口的类，
            所以就有了相互转换的功能
             */
//            Model model
            ModelMap model
//            ModelAndView mv
    ) {
        ModelAndView mv = new ModelAndView();
        ModelMap mm = new ModelMap();
        ExtendedModelMap emp = new ExtendedModelMap();
//        BindAwareModelMap amm = new BindAwareModelMap();
        mv.setViewName("index");
        model.addAttribute("key1",111);
        mv.addObject("key2",222);
        return mv;
    }

    /**
     * 在Spring MVC中定义了多种视图，只是常用的并不是太多，无论如何它们都需要满足视图的定义，它就是接口——View
     *
     * 当控制器返回 ModelAndView 的时候，视图解析器就会解析它，然后将数据模型传递给render方法，这样就能够渲染视图了。
     * 在Spring MVC中实现视图的类很多，比如JSTL视图JstlView,JSON视图MappingJackson2JsonView,PDF视图AbstractPdfView等，
     * 通过它们的render方法，Spring MVC就可以将数据模型渲染成为各类视图，以满足各种需求
     */
    @GetMapping("/view")
    public ModelAndView view(ModelAndView mv) {
        /*
          在WebConfig的viewResolver方法中可以看到InternalResourceViewResolver
          JstlView和InternalResourceView是父子类关系
          对于Excel而言，Spring MVC所推荐的是使用AbstractXlsView
         */

        //MappingJackson2JsonView 是一个非逻辑视图，它的目的就是将数据模型转换为一个 JSON 视图，展现给用户
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }
}
