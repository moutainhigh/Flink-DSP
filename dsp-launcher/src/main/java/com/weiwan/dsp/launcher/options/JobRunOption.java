package com.weiwan.dsp.launcher.options;

import com.beust.jcommander.DynamicParameter;
import com.beust.jcommander.Parameter;

import java.util.Map;

/**
 * @author: xiaozhennan
 * @email: xiaozhennan1995@gmail.com
 * @date: 2021/2/10 14:49
 * @description:
 */
public class JobRunOption {
    @Parameter(names = {"-n","-name"},description = "Job Name")
    private String jobName;

    @DynamicParameter(names = "-P", description = "Dynamic Plugin parameters go here")
    private Map<String,String> pluginDynamicConfig;

    private String jobFile;

}
