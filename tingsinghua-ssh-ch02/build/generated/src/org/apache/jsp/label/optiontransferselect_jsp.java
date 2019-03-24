package org.apache.jsp.label;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class optiontransferselect_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_s_optiontransferselect_rightTitle_name_list_leftTitle_label_headerValue_doubleName_doubleList_doubleHeaderKey_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_s_form;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_s_optiontransferselect_rightTitle_name_list_leftTitle_label_headerValue_doubleName_doubleList_doubleHeaderKey_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_s_form = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_s_optiontransferselect_rightTitle_name_list_leftTitle_label_headerValue_doubleName_doubleList_doubleHeaderKey_nobody.release();
    _jspx_tagPool_s_form.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>optiontransferselect标签的使用</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      if (_jspx_meth_s_form_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_s_form_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:form
    org.apache.struts2.views.jsp.ui.FormTag _jspx_th_s_form_0 = (org.apache.struts2.views.jsp.ui.FormTag) _jspx_tagPool_s_form.get(org.apache.struts2.views.jsp.ui.FormTag.class);
    _jspx_th_s_form_0.setPageContext(_jspx_page_context);
    _jspx_th_s_form_0.setParent(null);
    int _jspx_eval_s_form_0 = _jspx_th_s_form_0.doStartTag();
    if (_jspx_eval_s_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_form_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_form_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_form_0.doInitBody();
      }
      do {
        out.write("\n");
        out.write("            ");
        if (_jspx_meth_s_optiontransferselect_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_s_form_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_s_form_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_form_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_s_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_form.reuse(_jspx_th_s_form_0);
      return true;
    }
    _jspx_tagPool_s_form.reuse(_jspx_th_s_form_0);
    return false;
  }

  private boolean _jspx_meth_s_optiontransferselect_0(javax.servlet.jsp.tagext.JspTag _jspx_th_s_form_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:optiontransferselect
    org.apache.struts2.views.jsp.ui.OptionTransferSelectTag _jspx_th_s_optiontransferselect_0 = (org.apache.struts2.views.jsp.ui.OptionTransferSelectTag) _jspx_tagPool_s_optiontransferselect_rightTitle_name_list_leftTitle_label_headerValue_doubleName_doubleList_doubleHeaderKey_nobody.get(org.apache.struts2.views.jsp.ui.OptionTransferSelectTag.class);
    _jspx_th_s_optiontransferselect_0.setPageContext(_jspx_page_context);
    _jspx_th_s_optiontransferselect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_form_0);
    _jspx_th_s_optiontransferselect_0.setLabel("你喜欢的城市");
    _jspx_th_s_optiontransferselect_0.setName("left");
    _jspx_th_s_optiontransferselect_0.setLeftTitle("国内");
    _jspx_th_s_optiontransferselect_0.setRightTitle("国外");
    _jspx_th_s_optiontransferselect_0.setList("{'北京','上海','南京','深圳','海南','青岛'}");
    _jspx_th_s_optiontransferselect_0.setHeaderValue("---请选择---");
    _jspx_th_s_optiontransferselect_0.setDoubleHeaderKey("1");
    _jspx_th_s_optiontransferselect_0.setDoubleName("right");
    _jspx_th_s_optiontransferselect_0.setDoubleList("{'东京','华盛顿','伦敦','芝加哥','温哥华','多伦多'}");
    int _jspx_eval_s_optiontransferselect_0 = _jspx_th_s_optiontransferselect_0.doStartTag();
    if (_jspx_th_s_optiontransferselect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_s_optiontransferselect_rightTitle_name_list_leftTitle_label_headerValue_doubleName_doubleList_doubleHeaderKey_nobody.reuse(_jspx_th_s_optiontransferselect_0);
      return true;
    }
    _jspx_tagPool_s_optiontransferselect_rightTitle_name_list_leftTitle_label_headerValue_doubleName_doubleList_doubleHeaderKey_nobody.reuse(_jspx_th_s_optiontransferselect_0);
    return false;
  }
}
