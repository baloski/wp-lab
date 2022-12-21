package mk.finki.ukim.mk.lab.web.servlet;

import mk.finki.ukim.mk.lab.service.BalloonService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BalloonOrderServlet", urlPatterns = "/BalloonOrder.do")
public class BalloonOrderServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;

    private final BalloonService balloonService;


    public BalloonOrderServlet(SpringTemplateEngine springTemplateEngine, BalloonService balloonService) {
        this.springTemplateEngine = springTemplateEngine;
        this.balloonService = balloonService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext webContext = new WebContext(req, resp, req.getServletContext());
        webContext.setVariable("BalloonColor",  req.getSession().getAttribute("color"));
        webContext.setVariable("BalloonSize", req.getSession().getAttribute("size"));
        springTemplateEngine.process("deliveryInfo.html", webContext, resp.getWriter());
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("clientName");
        String address = req.getParameter("clientAddress");
        String color = req.getSession().getAttribute("color").toString();
        String size = req.getSession().getAttribute("size").toString();
        req.getSession().setAttribute("clientName", name);
        req.getSession().setAttribute("clientAddress", address);
        req.getSession().setAttribute("color", color);
        req.getSession().setAttribute("size", size);
        resp.sendRedirect("/ConfirmationInfo");
    }
}
