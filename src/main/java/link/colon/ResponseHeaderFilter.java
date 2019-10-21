/*
 *  © Copyright 2019, Colon.Link
 */

package link.colon;

import lombok.extern.slf4j.Slf4j;
import lombok.val;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** @author Peerapat A */
@Slf4j
@WebFilter("/*")
class ResponseHeaderFilter implements Filter {

  @Override
  public void doFilter(
      final ServletRequest request, final ServletResponse response, final FilterChain chain)
      throws IOException, ServletException {
    val r = (HttpServletResponse) response;

    r.setCharacterEncoding("UTF-8");
    r.setContentType("application/json; charset=UTF-8");
    r.setHeader("Access-Control-Allow-Origin", "*");
    r.setHeader("Access-Control-Allow-Credentials", "true");
    r.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");

    chain.doFilter(request, response);
  }

  @Override
  public void init(final FilterConfig filterConfig) {
    log.info("init");
  }

  @Override
  public void destroy() {
    log.info("destroy");
  }
}
