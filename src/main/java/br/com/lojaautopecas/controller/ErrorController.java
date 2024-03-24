package br.com.lojaautopecas.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ErrorController", value = "/error")
public class ErrorController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        processError(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        processError(request, response);
    }

    private void processError(HttpServletRequest request,
                              HttpServletResponse response) throws IOException {
        // Analyze the servlet exception
        Throwable throwable = (Throwable) request
                .getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer) request
                .getAttribute("javax.servlet.error.status_code");
        String servletName = (String) request
                .getAttribute("javax.servlet.error.servlet_name");
        if (servletName == null) {
            servletName = "Unknown";
        }
        String requestUri = (String) request
                .getAttribute("javax.servlet.error.request_uri");
        if (requestUri == null) {
            requestUri = "Unknown";
        }
        String context = getServletContext().getContextPath();
        // Set response content type
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.write("<html><head><title>Exception/Error Details</title>");
        out.write("<style>");
        out.write("/* Estilo para o corpo da página */");
        out.write("body#errorpage {");
        out.write("    font-family: Arial, sans-serif;");
        out.write("    background-color: #f9f9f9;");
        out.write("    margin: 0;");
        out.write("    padding: 2rem;");
        out.write("    display: flex;");
        out.write("    flex-direction: column;");
        out.write("    align-items: center;");
        out.write("}");
        out.write("/* Estilo para o cabeçalho h3 dentro de #errorpage */");
        out.write("body#errorpage h3 {");
        out.write("    color: #333;");
        out.write("    font-size: 24px;");
        out.write("    margin-bottom: 10px;");
        out.write("}");
        out.write("/* Estilo para os elementos strong dentro de #errorpage */");
        out.write("body#errorpage strong {");
        out.write("    font-weight: bold;");
        out.write("    color: #007bff;");
        out.write("}");
        out.write("/* Estilo para o link \"Home Page\" dentro de #errorpage */");
        out.write("body#errorpage a {");
        out.write("    color: #007bff;");
        out.write("    text-decoration: none;");
        out.write("}");
        out.write("/* Estilo para o link quando hover dentro de #errorpage */");
        out.write("body#errorpage a:hover {");
        out.write("    text-decoration: underline;");
        out.write("}");
        out.write("body#errorpage ul {");
        out.write("    list-style-type: disc;");
        out.write("    margin-left: 20px;");
        out.write("}");
        out.write("body#errorpage li {");
        out.write("    margin-bottom: 5px;");
        out.write("    margin-left: 20px;");
        out.write("}");
        out.write("</style>");
        out.write("</head><body id=\"errorpage\">");
        if(statusCode != 500){
            out.write("<div>");
            out.write("<h3>Error Details</h3>");
            out.write("<strong>Status Code</strong>:");
            out.write("<span>"+statusCode+"</span>");
            out.write("</div>");
            out.write("<div>");
            out.write("<strong>Requested URI</strong>:");
            out.write("<span>"+requestUri+"</span>");
            out.write("</div>");
        }else{
            out.write("<h3>Exception Details</h3>");
            out.write("<ul><li>Servlet Name:"+servletName+"</li>");
            out.write("<li>Exception Name:"+throwable.getClass().getName()+"</li>");
            out.write("<li>Requested URI:"+requestUri+"</li>");
            out.write("<li>Exception Message:"+throwable.getMessage()+"</li>");
            out.write("</ul>");
        }

        out.write("<br><br>");

        out.write("<a href="+context+"/index.html >Home Page</a>");
        out.write("</body></html>");
    }

}