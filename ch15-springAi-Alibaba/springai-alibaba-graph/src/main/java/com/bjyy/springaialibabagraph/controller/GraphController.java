package com.bjyy.springaialibabagraph.controller;


import com.alibaba.cloud.ai.graph.CompiledGraph;
import com.alibaba.cloud.ai.graph.OverAllState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/graph")
public class GraphController {

    private static final Logger log = LoggerFactory.getLogger(GraphController.class);
    private final CompiledGraph compiledGraph;
    private final CompiledGraph simpleGraph;
    private final CompiledGraph conditionalGraph;
    private final CompiledGraph loopGraph;


    public GraphController(@Qualifier("quickStartGraph") CompiledGraph compiledGraph,
                           @Qualifier("simpleGraph") CompiledGraph simpleGraph,
                           @Qualifier("conditionalGraph")CompiledGraph conditionalGraph,
                           @Qualifier("loopGraph")CompiledGraph loopGraph) {
        this.compiledGraph = compiledGraph;
        this.simpleGraph = simpleGraph;
        this.conditionalGraph = conditionalGraph;
        this.loopGraph = loopGraph;
    }

    @GetMapping("/loopGraph")
    public Map<String, Object> loopGraph(@RequestParam("topic") String topic){
        Optional<OverAllState> overAllStateOptional = loopGraph.invoke(Map.of("topic", topic));
        Map<String, Object> data = overAllStateOptional.map(OverAllState::data).orElse(Map.of());
        return data;
    }


    @GetMapping("/conditionalGraph")
    public Map<String, Object> conditionalGraph(@RequestParam("topic") String topic){
        Optional<OverAllState> overAllStateOptional = conditionalGraph.invoke(Map.of("topic", topic));
        Map<String, Object> data = overAllStateOptional.map(OverAllState::data).orElse(Map.of());
        return data;
    }
    @GetMapping("/quickStartGraph")
    public String quickStartGraph(){
        try {
            // 尝试使用 invoke 或其他可用方法替代 call
            Optional<OverAllState> overAllStateOptional = compiledGraph.invoke(Map.of());
            log.info("overAllStateOptional: {}", overAllStateOptional);
            return "ok";
        } catch (Exception e) {
            log.error("Graph execution failed", e);
            return "error";
        }
    }

    @GetMapping("/simpleGraph")
    public Map<String, Object> simpleGraph(@RequestParam("word") String word){
        Optional<OverAllState> overAllStateOptional = simpleGraph.invoke(Map.of("word", word));
        Map<String, Object> data = overAllStateOptional.map(OverAllState::data).orElse(Map.of());
        return data;
    }


}
