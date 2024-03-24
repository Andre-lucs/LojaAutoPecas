package br.com.lojaautopecas.customTags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class HeaderHandler extends TagSupport {
    private static final long serialVersionUID = 1L;

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        String context = pageContext.getServletContext().getContextPath();
        try {
            out.println("<header>\n" +
                    "        <nav>\n" +
                    "            <a href=\""+context+"/main\">Vendas</a>\n" +
                    "            <a href=\""+context+"/cliente\">Clientes</a>\n" +
                    "            <a href=\""+context+"/funcionario\">Perfil</a>\n" +
                    "            <a class=\"button\" href=\"logout\" >Sair</a>\n" +
                    "        </nav>\n" +
                    "    </header>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return SKIP_BODY;
    }
}
