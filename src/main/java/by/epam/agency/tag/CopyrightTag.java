package by.epam.agency.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

@SuppressWarnings("serial")
public class CopyrightTag extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        String copyrightInfo = "<p> Copyright © 2020 All Rights Reserved.</p>";
        try {
            JspWriter out = pageContext.getOut();
            out.write(copyrightInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
