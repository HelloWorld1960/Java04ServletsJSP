package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/pages/noticia1.html");
    _jspx_dependants.add("/pages/noticia2.html");
    _jspx_dependants.add("/pages/video1.html");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <h1>Inclusi&oacute;n de Archivos Estáticos</h1>\n");
      out.write("\n");
      out.write("    <!--Esto es por cada menu-->\n");
      out.write("    <br>\n");
      out.write("    <!--menu principal-->\n");
      out.write("    <span class=\"noticias\" align=\"left\">\n");
      out.write("      <a href=\"javascript:desplegar ('noticias');\">\n");
      out.write("        <img border=\"0\" src=\"http://icursos.net/cursos/ServletsJSPs/Leccion14/noticias.gif\">\n");
      out.write("      </a>\n");
      out.write("    </span>\n");
      out.write("    <span id=\"noticias\" class=\"ocultar_menu\">\n");
      out.write("      <!--Submenu-->\n");
      out.write("      <ul>\n");
      out.write("        <li>");
      out.write("<!DOCTYPE html>\n");
      out.write("<!--\n");
      out.write("To change this license header, choose License Headers in Project Properties.\n");
      out.write("To change this template file, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write("<!-- No necesitamos agregar todos los tags html\n");
      out.write("de inicio -->\n");
      out.write("\n");
      out.write("<B>Universida Java</B>\n");
      out.write("<A HREF=\"http://universidadjava.com\" target=\"_blank\">\n");
      out.write("para m&aacute;s detalles...</A>\n");
      out.write("</li>\n");
      out.write("        <li>");
      out.write("<!DOCTYPE html>\n");
      out.write("<!--\n");
      out.write("To change this license header, choose License Headers in Project Properties.\n");
      out.write("To change this template file, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write("<!-- No necesitamos agregar todos los tags html\n");
      out.write("de inicio -->\n");
      out.write("\n");
      out.write("<B>Cursos de Java</B> para desarrolladores profesionales en Global Mentoring\n");
      out.write("<A HREF=\"http://globalmentoring.com.mx\" target=\"_blank\">\n");
      out.write("para m&aacute;s detalles...</A>\n");
      out.write("</li>\n");
      out.write("      </ul>\n");
      out.write("    </span>\n");
      out.write("\n");
      out.write("     <!--Esto es por cada menu-->\n");
      out.write("    <br>\n");
      out.write("    <!--menu principal-->\n");
      out.write("    <span class=\"videos\" align=\"left\">\n");
      out.write("      <a href=\"javascript:desplegar ('videos');\">\n");
      out.write("        <img border=\"0\" src=\"http://icursos.net/cursos/ServletsJSPs/Leccion14/videos.gif\">\n");
      out.write("      </a>\n");
      out.write("    </span>\n");
      out.write("    <span id=\"videos\" class=\"ocultar_menu\">\n");
      out.write("      <!--Submenu-->\n");
      out.write("      <ul>\n");
      out.write("        <li>");
      out.write("<!DOCTYPE html>\n");
      out.write("<!--\n");
      out.write("To change this license header, choose License Headers in Project Properties.\n");
      out.write("To change this template file, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write("<B>Video</B> Global Mentoring: <br/><br>\n");
      out.write("\n");
      out.write("<iframe src=\"https://player.vimeo.com/video/200744227\" width=\"640\" height=\"360\" frameborder=\"0\" webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe>\n");
      out.write("</li>\n");
      out.write("      </ul>\n");
      out.write("    </span>\n");
      out.write("\n");
      out.write("  </body>\n");
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
}
