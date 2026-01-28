package com.bjyy.ch15springaialibaba;

import com.alibaba.fastjson.util.BiFunction;
import org.springframework.ai.chat.model.ToolContext;
import org.springframework.ai.tool.annotation.ToolParam;

// 天气查询工具
public class WeatherForLocationTool implements BiFunction<String, ToolContext, String> {
    @Override
    public String apply(
        @ToolParam(description = "The city name") String city,
        ToolContext toolContext) {
        return "It's always sunny in " + city + "!";
    }
}