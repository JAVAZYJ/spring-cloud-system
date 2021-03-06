package com.example.spring.cloud.client.response;

/**
 * 返回前端工具类
 * @author YiJieZhu
 */
public class DCResponse<T> {
    public static final String DEFAULT_SUCCESS_MESSAGE = "请求成功";
    public static final String DEFAULT_ERROR_MESSAGE = "网络异常";
    public static final Integer DEFAULT_SUCCESS_CODE = 200;
    public static final Integer DEFAULT_ERROR_CODE = 500;
    private T data;

    private int code;

    private String message;

    private DCResponse() {
    }

    private DCResponse(DCResponse.ResponseBuilder<T> builder) {
        this.data = builder.result;
        this.code = builder.code;
        this.message = builder.msg;
    }

    public T getData() {
        return this.data == null ? (T) "" : this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public static <T> DCResponse<T> success(T result) {
        return (new DCResponse.ResponseBuilder(result)).code(DEFAULT_SUCCESS_CODE).build();
    }

    public static DCResponse error(int code, String message) {
        return (new DCResponse.ResponseBuilder("")).code(code).msg(message).build();
    }

    public static class ResponseBuilder<T> {
        private T result;
        private int code;
        private String msg;

        public ResponseBuilder() {
            this.result = null;
        }

        public ResponseBuilder(T result) {
            this.result = result;
        }

        public DCResponse.ResponseBuilder code(int code) {
            this.code = code;
            if (DCResponse.DEFAULT_SUCCESS_CODE == code) {
                this.msg = "操作成功";
            } else {
                this.msg = "操作失败";
            }

            return this;
        }

        public DCResponse.ResponseBuilder result(T result) {
            this.result = result;
            return this;
        }

        public DCResponse.ResponseBuilder msg(String msg) {
            this.msg = msg;
            return this;
        }

        public DCResponse<T> build() {
            return new DCResponse(this);
        }
    }
}
