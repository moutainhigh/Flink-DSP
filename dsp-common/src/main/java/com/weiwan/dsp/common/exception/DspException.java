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
package com.weiwan.dsp.common.exception;

import com.weiwan.dsp.common.enums.DspExceptionEnum;

/**
 * @Author: xiaozhennan
 * @Date: 2020/4/27 17:24
 * @Package: com.hopson.dc.realtime.common.exception
 * @ClassName: DspException
 * @Description:
 **/
public class DspException extends RuntimeException {
    public String code;
    public String msg;

    public DspException(DspExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.name();
        this.msg = exceptionEnum.getMsg();
    }

    public DspException(Throwable e) {
        super(e);
    }

    public DspException() {
    }

    public DspException(DspExceptionEnum exceptionEnum, String msg) {
        super(msg);
        this.code = exceptionEnum.name();
        this.msg = msg;
    }

    public DspException(String msg) {
        super(msg);
        this.code = DspExceptionEnum.FAILED.name();
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public static DspException generateParameterEmptyException(String msg) {
        return new DspException(DspExceptionEnum.PARAMETER_EMPTY, msg);
    }

    public static DspException generateUnknownException(String msg) {
        return new DspException(DspExceptionEnum.UNKNOWN, msg);
    }

    public static DspException generateParameterIllegalException(String msg) {
        return new DspException(DspExceptionEnum.PARAMETER_EMPTY, msg);
    }

    public static DspException generateDataException(String msg) {
        return new DspException(DspExceptionEnum.PARAMETER_EMPTY, msg);
    }
}
