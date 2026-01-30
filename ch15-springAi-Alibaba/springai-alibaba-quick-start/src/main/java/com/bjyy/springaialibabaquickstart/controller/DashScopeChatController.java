package com.bjyy.springaialibabaquickstart.controller;


import com.alibaba.cloud.ai.dashscope.chat.DashScopeChatOptions;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/qiwen")
public class DashScopeChatController {

    private final ChatModel chatModel;

    public DashScopeChatController(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }


    @GetMapping("/simple")
    public String simple(@RequestParam(name = "query") String query) {
        // 调用模型
        return chatModel.call(query);
    }


    @GetMapping("/message")
    public String message(@RequestParam(name = "query") String query) {
        SystemMessage systemMessage = new SystemMessage("你是一个有用的AI助手。");
        UserMessage userMessage = new UserMessage(query);
        // 调用模型
        return chatModel.call(systemMessage,userMessage);
    }
    @GetMapping("/chatOptions")
    public ChatResponse chatOptions(@RequestParam(name = "query") String query) {
        SystemMessage systemMessage = new SystemMessage("你是一个有用的AI助手。你的版本是多少");
        UserMessage userMessage = new UserMessage(query);
        DashScopeChatOptions dashScopeChatOptions = new DashScopeChatOptions();
        dashScopeChatOptions.setModel("qwen-long-2025-01-25");
        dashScopeChatOptions.setTemperature(0.0);
        dashScopeChatOptions.setMaxTokens(2048);

        // 调用模型
        return chatModel.call(new Prompt(List.of(systemMessage,userMessage),dashScopeChatOptions));
    }
    @GetMapping("/chatResponse")
    public String chatResponse(@RequestParam(name = "query") String query) {
        SystemMessage systemMessage = new SystemMessage("你的版本是多少");
        UserMessage userMessage = new UserMessage(query);
        DashScopeChatOptions dashScopeChatOptions = new DashScopeChatOptions();
        dashScopeChatOptions.setModel("qwen-long-2025-01-25");
        dashScopeChatOptions.setTemperature(0.0);
        dashScopeChatOptions.setMaxTokens(2048);
        ChatResponse chatResponse = chatModel.call(new Prompt(List.of(systemMessage, userMessage), dashScopeChatOptions));

        // 调用模型
        return chatResponse.getResult().getOutput().getText();
    }


    @GetMapping("/stream/chat")
    public Flux<String> stream(@RequestParam(name = "query") String query) {
        return chatModel.stream(query);
    }
}
