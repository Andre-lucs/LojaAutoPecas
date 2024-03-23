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
        try {
            out.println("<header>\n" +
                    "        <nav>\n" +
                    "            <a href=\"main\">Vendas</a>\n" +
                    "            <a href=\"\">Clientes</a>\n" +
                    "            <a href=\"\"><img src=\"./resources/images/user.png\" alt=\"user\"></a>\n" +
                    "            <button>Sair</button>\n" +
                    "        </nav>\n" +
                    "    </header>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return SKIP_BODY;
    }
}
