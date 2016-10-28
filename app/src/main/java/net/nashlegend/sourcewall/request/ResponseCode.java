package net.nashlegend.sourcewall.request;

/**
 * Created by NashLegend on 2015/9/23 0023.
 * 网络请求统一错误码，由Json解析出的code，而不是http code
 */
public class ResponseCode {
    public static final int CODE_NONE = -1;
    public static final int CODE_OK = 200;
    public static final int CODE_TOKEN_INVALID = 200004;
    public static final int CODE_ALREADY_LIKED = 240004;
    public static final int CODE_ALREADY_THANKED = 242033;
    public static final int CODE_ALREADY_BURIED = 242013;
    public static final int CODE_UNKNOWN = 1008610010;
}