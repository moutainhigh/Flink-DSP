package com.weiwan.dsp.core.flow;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.streaming.api.datastream.ConnectedStreams;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.streaming.api.functions.co.CoMapFunction;
import org.apache.flink.util.Collector;
import org.apache.flink.util.OutputTag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: xiaozhennan
 * @email: xiaozhennan1995@gmail.com
 * @date: 2021/2/9 18:16
 * @description: 数据流引擎
 */
public class DataFlowEngine {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<String> s1 = env.fromElements("a", "b", "c");
        DataStreamSource<String> s2 = env.fromElements("d", "e", "f");
        DataStream<String> union = s1.union(s2);
//例如定义一个tag,来收集某个值小于200的数据
         final OutputTag<String> outputTag1 = new OutputTag("side-output<200", TypeInformation.of(String.class));
         final OutputTag<String> outputTag2 = new OutputTag("side-output-200~500", TypeInformation.of(String.class));
         final OutputTag<String> outputTag3 = new OutputTag("side-output>500", TypeInformation.of(String.class));
        List<OutputTag<String>> outputTags = Arrays.asList(outputTag1, outputTag2, outputTag3);

        SingleOutputStreamOperator<String> process = union.process(new ProcessFunction<String, String>() {
           List<OutputTag<String>> outputs = outputTags;
            @Override
            public void processElement(String s, Context context, Collector<String> collector) throws Exception {
                for (OutputTag<String> output : outputs) {
                    //js引擎,过滤不同数据到不同流中
                    context.output(output,s);
                }
            }
        });

        DataStream<String> sideOutput = process.getSideOutput(outputTag1);

        DataStream<String> sideOutput1 = process.getSideOutput(outputTag2);

        DataStream<String> sideOutput2 = process.getSideOutput(outputTag3);

        DataStream<String> union1 = union.union(sideOutput).union(sideOutput1).union(sideOutput2);

        union1.print().setParallelism(1);

//        s1.print();
//        s2.print();
//
//        SingleOutputStreamOperator<String> map = union.map(new MapFunction<String, String>() {
//            @Override
//            public String map(String s) throws Exception {
//                System.out.println(s);
//                return s;
//            }
//        });
//
//        map.printToErr();


        env.execute();
    }
}
