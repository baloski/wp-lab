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

@WebServlet(name = "ConfirmationInfoServlet", urlPatterns = "/ConfirmationInfo")
public class ConfirmationInfoServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;

    private final BalloonService balloonService;


    public ConfirmationInfoServlet(SpringTemplateEngine springTemplateEngine, BalloonService balloonService) {
        this.springTemplateEngine = springTemplateEngine;
        this.balloonService = balloonService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext webContext = new WebContext(req, resp, req.getServletContext());
        webContext.setVariable("ClientName", req.getSession().getAttribute("clientName"));
        webContext.setVariable("DeliveryAddress", req.getSession().getAttribute("clientAddress"));
        webContext.setVariable("BalloonColor", req.getSession().getAttribute("color"));
        webContext.setVariable("BalloonSize", req.getSession().getAttribute("size"));
        webContext.setVariable("ClientIP", req.getRemoteAddr());
        webContext.setVariable("ClientWebBrowser", req.getHeader("User-Agent"));
        springTemplateEngine.process("confirmationInfo.html", webContext, resp.getWriter());

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {}

}
