package com.chen.controllers;


import com.chen.model.Flower;
import net.paoding.rose.web.ControllerErrorHandler;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import net.paoding.rose.web.var.Model;
import net.paoding.rose.web.var.Flash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//显示搜索內容 http://localhost:8080/forumapi/notblank/?id=1
//显示搜索內容 http://localhost:8080/forumapi/flowerbean/?name=cauliflower&color=white&id=1
//做web的需求後, 通过return "r:/xxx"来跳转（实际是301）快速跳转显示flash信息 http://localhost:8080/forumapi/flash1
//显示主帖列表 GET http://localhost:8080/forumapi/topic
//创建一个主帖 POST http://localhost:8080/forumapi/topic
//显示单个主帖和它的跟贴 GET http://localhost:8080/forumapi/topic/123
//显示跟贴列表 GET http://localhost:8080/forumapi/topic/123/comment
//创建一个跟贴 POST http://localhost:8080/forumapi/topic/123/comment
//显示单个跟贴 GET http://localhost:8080/forumapi/topic/123/comment/456




@Path("")
public class ForumController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerErrorHandler.class);

    //显示搜索內容 http://localhost:8080/forumapi/notblank/?id=1
    @Get("notblank")
    public String notBlank(@NotBlank @Param("id") int id) throws Exception {
        return "@nice&nbsp;" + id;
    }

    //显示搜索內容 http://localhost:8080/forumapi/notblankbean/?name=cauliflower&color=white&id=1
    @Get("flowerbean")
    public String param(Model model, @Param("flower") Flower flower) throws Exception {
        model.add("flower", flower);
        return "flower";
    }

    //做web的需求後, 通过return "r:/xxx"来跳转（实际是301）快速跳转显示flash信息
    //flash功能利用了浏览器的cookies功能，如果用户的环境不能使用cookies将不会有任何效果
    @Get("flash1")
    public String flashStep1(Flash flash) {
        flash.add("msg", "修改成功！");
        return "r:flash2";
    }

    @Get("flash2")
    public String flashStep2(Invocation inv, Flash flash) {
        inv.addModel("info", flash.get("msg"));
        return "flash";
    }

    @Get("wp1")
    public String portal1() {
        return "portal1";
    }

    @Get("wp2")
    public String portal2() {
        return "portal2";
    }


    //显示主帖列表 GET http://localhost:8080/forumapi/topic
    @Get("topic")
    public String getTopics() throws Exception {
        LOGGER.info("topic log test");
        return "topiclist";
    }

    //创建一个主帖 POST http://localhost:8080/forumapi/topic
    @Post("topic")
    public String createTopic() throws Exception {
        return "postsuccess";
    }

    //显示单个主帖和它的跟贴 GET http://localhost:8080/forumapi/topic/123
    @Get("topic/{topicId:[0-9]+}")
    public String showTopic(Model model, @Param("topicId") int topicId) throws Exception {
        model.add("topicid", topicId);
        return "topic";
    }

    //显示跟贴列表 GET http://localhost:8080/forumapi/topic/123/comment
    @Get("topic/{topicId:[0-9]+}/comment")
    public String getComments(@Param("topicId") int topicId) throws Exception {
        return "commentlist";
    }

    //创建一个跟贴 POST http://localhost:8080/forumapi/topic/123/comment
    @Post("topic/{topicId:[0-9]+}/comment")
    public String createComment(@Param("topicId") int topicId) throws Exception {
        return "postsuccess";
    }

    //显示单个跟贴 GET http://localhost:8080/forumapi/topic/123/comment/456
    @Get("topic/{topicId:[0-9]+}/comment/{commentId:[0-9]+}")
    public String showComment(Model model, @Param("topicId") int topicId, @Param("commentId") int commentId) throws Exception {
        model.add("name", "mi");
        model.add("commentContent", "你好");
        return "comment";
    }
}