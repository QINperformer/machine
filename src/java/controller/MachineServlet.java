package controller;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import machine.Machine;

@WebServlet("/query")
public class MachineServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //取出自己回话中的机器人
        machine.Machine machine = null;
        if (req.getSession().getAttribute("machine") == null) {
            machine = new machine.Machine();
            req.getSession().setAttribute("machine", machine);
        } else {
            machine = (Machine) req.getSession().getAttribute("machine");
        }

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        String natrualWords = req.getParameter("natrualWords");
        System.out.println("MachineController自然语言：" + natrualWords);
        machine.natrualWords = natrualWords;
        try {
            machine.run();
            resp.getWriter().write(String.format(StringResource.str, natrualWords, machine.result));
            resp.getWriter().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
