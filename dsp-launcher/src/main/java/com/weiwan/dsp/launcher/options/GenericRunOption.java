/*
 *      Copyright [2020] [xiaozhennan1995@gmail.com]
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 *      http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.weiwan.dsp.launcher.options;

import com.beust.jcommander.Parameter;
import com.weiwan.dsp.tools.options.CommonOptions;

/**
 * @Author: xiaozhennan
 * @Date: 2020/9/30 11:22
 * @Package: com.weiwan.support.launcher.options.GenericRunOption
 * @ClassName: GenericRunOption
 * @Description:
 **/
public class GenericRunOption extends CommonOptions {

    @Parameter(names = "-logLevel", description = "client log level, default is: INFO")
    private String logLevel = "INFO";

    @Parameter(names = "-flinkHome", description = "Flink Home, obtained from environment variables by default")
    private String flinkHome;

    @Parameter(names = "-hadoopHome", description = "Hadoop Home, obtained from environment variables by default")
    private String hadoopHome;

    @Parameter(names = "-yarnHome", description = "Yarn Home, obtained from environment variables by default")
    private String yarnHome;

    @Parameter(names = "-hiveHome", description = "Hive Home, obtained from environment variables by default")
    private String hiveHome;

    @Parameter(names = "-baseDir", description = "The location of the support framework installed on the disk")
    private String baseDir;

}
