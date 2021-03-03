package com.example.until;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <b><code>ResponseResult</code></b>
 * <p>
 * Description响应信息主体
 * </p>
 * <b>Creation Time:</b> 2019/11/26 17:55.
 *
 * @author  Chuk
 * @since gempile-boiler-code 0.1.0
 */
@ToString
@Accessors(chain = true)

public class CkResponseResult<T> implements Serializable {
        private static final long serialVersionUID = 1L;

        @Getter
        @Setter
        private int code;

        @Getter
        @Setter
        private String msg;

        @Getter
        @Setter
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private T data;

        public CkResponseResult() {
        super();
    }

        public CkResponseResult(T data) {
            super();
            this.data = data;
        }

        public CkResponseResult(T data, String msg) {
            super();
            this.data = data;
            this.msg = msg;
        }

//        public CkResponseResult(Throwable e) {
//            super();
//            this.msg = e.getMessage();
//            this.code = CommonConstants.FAIL;
//        }
        public static <T> CkResponseResult success(T data) {
            return new CkResponseResult().setData(data);
        }
        public static <T> CkResponseResult<T> ok() {
            return restResult(null, HttpEnum.OK_200.code(), HttpEnum.OK_200.desc());
        }

        public static <T> CkResponseResult<T> ok(T data) {
            return restResult(data, HttpEnum.OK_200.code(), HttpEnum.OK_200.desc());
        }

        public static <T> CkResponseResult<T> ok(T data, String msg) {
            return restResult(data, HttpEnum.OK_200.code(), msg);
        }

        public static <T> CkResponseResult<T> failed() {
            return restResult(null, HttpEnum.ERROR_500.code(),
                    HttpEnum.ERROR_500.desc());
        }

        public static <T> CkResponseResult<T> failed(String msg) {
            return restResult(null, HttpEnum.ERROR_500.code(), msg);
        }

        public static <T> CkResponseResult<T> failed(int code, String msg) {
            return restResult(null, code, msg);
        }

        public static <T> CkResponseResult<T> failed(T data) {
            return restResult(data, HttpEnum.ERROR_500.code(),
                    HttpEnum.ERROR_500.desc());
        }

        public static <T> CkResponseResult<T> failed(T data, String msg) {
            return restResult(data, HttpEnum.ERROR_500.code(), msg);
        }

        private static <T> CkResponseResult<T> restResult(T data, int code,
                                                        String msg) {
            CkResponseResult<T> apiResult = new CkResponseResult<>();
            apiResult.setCode(code);
            apiResult.setData(data);
            apiResult.setMsg(msg);
            return apiResult;
        }

}
