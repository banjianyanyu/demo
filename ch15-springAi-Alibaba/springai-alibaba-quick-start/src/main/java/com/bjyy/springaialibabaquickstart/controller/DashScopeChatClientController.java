package com.bjyy.springaialibabaquickstart.controller;


import com.alibaba.cloud.ai.dashscope.chat.DashScopeChatOptions;

import com.bjyy.springaialibabaquickstart.advisor.SGCallAdvisor1;
import com.bjyy.springaialibabaquickstart.advisor.SGCallAdvisor2;
import com.bjyy.springaialibabaquickstart.advisor.SimpleMessageChatMemoryAdvisor;
import com.bjyy.springaialibabaquickstart.entity.Book;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/chatclient")
public class DashScopeChatClientController {

    private final ChatClient chatClient;
    //构造器注入
    public DashScopeChatClientController(ChatClient.Builder builder) {
        this.chatClient = builder
                .build();
    }


//    @GetMapping("/simple")
//    public String simple(@RequestParam(name = "query") String query) {
//        SystemMessage systemMessage = new SystemMessage("你是一个有用的AI助手。");
//        UserMessage userMessage = new UserMessage(query);
//        ZhiPuAiChatOptions zhiPuAiChatOptions = new ZhiPuAiChatOptions();
//        zhiPuAiChatOptions.setModel("glm-4.5");
//        zhiPuAiChatOptions.setTemperature(0.0);
//        zhiPuAiChatOptions.setMaxTokens(15536);
//        Prompt prompt = new Prompt(List.of(systemMessage, userMessage), zhiPuAiChatOptions);
//        return chatClient.prompt(prompt)
//                .call()
//                .content();
//    }


    @GetMapping("/simple")
    public String simple(@RequestParam(name = "query") String query) {
        DashScopeChatOptions chatOptions = DashScopeChatOptions.builder()
                .maxToken(2048)
                .temperature(0.0)
                .model("qwen-long-2025-01-25")
                .build();

        return chatClient.prompt()
                .system("你是一个有用的AI助手。")
                .user(query)
                .options(chatOptions)
                .call()
                .content();
    }

    @GetMapping("/chatResponse")
    public ChatResponse chatResponse(@RequestParam(name = "query") String query) {
        DashScopeChatOptions chatOptions = DashScopeChatOptions.builder()
                .maxToken(2048)
                .temperature(0.0)
                .model("qwen-long-2025-01-25")
                .build();

        return chatClient.prompt()
                .system("你是一个有用的AI助手。")
                .user(query)
                .options(chatOptions)
                .call()
                .chatResponse();
    }

    @GetMapping("/entity")
    public Book response() {
        Book book = chatClient.prompt()
                .user("给我随机生成一本书，要求书名和作者都是中文")
                .call().entity(Book.class);
        return book;
    }


    @GetMapping("/stream")
    public Flux<String> stream() {
        Flux<String> stringFlux = chatClient.prompt()
                .user("给我随机生成一本书，要求书名和作者都是中文")
                .stream()
                .content();
        return stringFlux;
    }



    @GetMapping("/advisor")
    public Book advisor() {
        Book book = chatClient.prompt()
                .user("给我随机生成一本书，要求书名和作者都是中文")
                .advisors(new SGCallAdvisor1(),new SGCallAdvisor2())
                .call().entity(Book.class);
        return book;
    }


    @GetMapping("/simpleMessageChatMemoryAdvisor")
    public String simpleMessageChatMemoryAdvisor(@RequestParam(name = "query") String query,
                                                 @RequestParam(name = "conversationId") String conversationId) {
        return chatClient.prompt()
                .user(query)
                //把会话id存入上下文
                .advisors(advisorSpec -> advisorSpec.param("conversationId", conversationId))
                .advisors(new SimpleMessageChatMemoryAdvisor())
                .call()
                .content();
    }


}
