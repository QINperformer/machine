/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

/**
 *
 * @author Administrator
 */
public class XmlHelper {

    static String fromXml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
            + "<xml>\n"
            + "  <ToUserName><![CDATA[gh_ba9bedf32202]]></ToUserName>\n"
            + "  <FromUserName><![CDATA[otHS2wh4I8ItBAhYGLgRcE4Z4anc]]></FromUserName>\n"
            + "  <CreateTime>1497357116</CreateTime>\n"
            + "  <MsgType><![CDATA[text]]></MsgType>\n"
            + "  <Content><![CDATA[图腾]]></Content>\n"
            + "  <MsgId>6431099844073503031</MsgId>\n"
            + "</xml>";
    static String toXml = "<xml>\n"
            + "<ToUserName><![CDATA[%s]]></ToUserName>\n"
            + "<FromUserName><![CDATA[%s]]></FromUserName>\n"
            + "<CreateTime>%s</CreateTime>\n"
            + "<MsgType><![CDATA[text]]></MsgType>\n"
            + "<Content><![CDATA[%s]]></Content>\n"
            + "</xml>";

    public static String getValueFromXml(String xml, String key) throws DocumentException {

        Document document = DocumentHelper.parseText(xml);
        return document.getRootElement().element(key).getText();

    }

    public static void main(String[] args) throws DocumentException {
        System.out.println(getValueFromXml(toXml, "ToUserName"));
    }
}
