package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import machine.Machine;

@WebServlet("/wechat")
public class WeChatServlet extends HttpServlet {

    Map<String, Machine> machineMap = new HashMap<>();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        System.out.println("wechat");
        // 接收微信服务器以Get请求发送的4个参数
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        System.out.println("signature=" + signature);
        System.out.println("timestamp=" + timestamp);
        System.out.println("nonce=" + nonce);
        System.out.println("echostr=" + echostr);
        PrintWriter out = response.getWriter();
        /**
         * 读取接收到的xml消息
         */
        StringBuffer sb = new StringBuffer();
        InputStream is = request.getInputStream();
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String s = "";
        while ((s = br.readLine()) != null) {
            sb.append(s);
        }
        String xml = sb.toString(); //次即为接收到微信端发送过来的xml数据  
        System.out.println("xml=" + xml);
        out.print(echostr);

        if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
            try {
                //发送方和接受方
                String toUserName = XmlHelper.getValueFromXml(xml, "ToUserName");
                String fromUserName = XmlHelper.getValueFromXml(xml, "FromUserName");
                Machine machine = null;
                if (this.machineMap.get(toUserName) == null) {
                    machine = new Machine();
                    this.machineMap.put(toUserName, machine);
                } else {
                   machine= this.machineMap.get(toUserName);
                }
                //微信端接收的消息
                String content = XmlHelper.getValueFromXml(xml, "Content");
                String natrualWords = content;
                System.out.println("MachineController自然语言：" + natrualWords);
                machine.natrualWords = natrualWords;
                try {
                    machine.run();
                    out.print(String.format(XmlHelper.toXml, fromUserName, toUserName, System.currentTimeMillis(), machine.result));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                System.out.println("exception");
            }
            out.flush();
            out.close();
        }

    }

}
