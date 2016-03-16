package net.nashlegend.sourcewall.util;

import net.nashlegend.sourcewall.swrequest.api.APIBase;
import net.nashlegend.sourcewall.swrequest.ResponseObject;

/**
 * Created by NashLegend on 2014/12/5 0005
 */
public class MDUtil {

    /**
     * 通过github接口转换markdown，一小时只能60次
     */
    public static ResponseObject<String> parseMarkdownByGitHub(String text) {
        return APIBase.parseMarkdownByGitHub(text);
    }

    /**
     * Markdown转换为Html，只转换简单链接和图片
     */
    public static String Markdown2HtmlDumb(String text) {
        StringBuilder sb = new StringBuilder();
        String[] paragraphs = text.split("\n");
        for (String paragraph : paragraphs) {
            sb.append("<p>").append(markdown2HtmlLink(markdown2HtmlImage(paragraph))).append("</p>");
        }
        return sb.toString();
    }

    /**
     * UBB转换为Html，只转换简单链接和图片
     */
    public static String UBB2HtmlDumb(String text) {
        StringBuilder sb = new StringBuilder();
        String[] paragraphs = text.split("\n");
        for (String paragraph : paragraphs) {
            sb.append("<p>").append(UBB2HtmlLink(UBB2HtmlImage(paragraph))).append("</p>");
        }
        return sb.toString();
    }

    /**
     * Markdown图片转换为Html格式
     */
    private static String markdown2HtmlImage(String image) {
        return image.replaceAll("\\!\\[[^\\]]*?\\]\\((.*?)\\)", "<img src=\"" + "$1" + "\" style=\"max-width:100%;\">");
    }

    /**
     * Markdown地址转换为Html格式
     */
    private static String markdown2HtmlLink(String link) {
        return link.replaceAll("\\[([^\\]]*?)\\]\\((.*?)\\)", "<a href=\"" + "$2" + "\">" + "$1" + "</a>");
    }

    /**
     * UBB文本描述格式转换为Html格式图片 [image]http://xxx[/image]
     */
    public static String UBB2HtmlImage(String ubb) {
        return ubb.replaceAll("\\[image\\]([^\\]]*?)\\[/image\\]", "<img src=\"" + "$1" + "\" style=\"max-width:100%;\">");
    }

    /**
     * UBB文本描述格式转换为Html格式链接 [url=""]title[/url]
     */
    public static String UBB2HtmlLink(String ubb) {
        return ubb.replaceAll("\\[url=\"(.*?)\"\\](.*?)\\[/url\\]", "<a href=\"" + "$1" + "\">" + "$2" + "</a>");
    }

    /**
     * Markdown图片转换为UBB文本描述格式 [image]http://xxx[/image]
     */
    private static String markdown2UBBImage(String image) {
        return image.replaceAll("\\!\\[[^\\]]*?\\]\\((.*?)\\)", "[image]" + "$1" + "[/image]");
    }

    /**
     * UBB文本描述格式转换为Markdown图片格式 [image]http://xxx[/image]
     */
    public static String UBB2MarkdownImage(String image) {
        return image.replaceAll("\\[image\\](.*?)\\[/image\\]", "![](" + "$1" + ")");
    }
}
