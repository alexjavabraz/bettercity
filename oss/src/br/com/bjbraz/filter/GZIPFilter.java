package br.com.bjbraz.filter;

import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tuckey.web.filters.urlrewrite.gzip.GenericResponseWrapper;
import org.tuckey.web.filters.urlrewrite.gzip.ResponseUtil;

public class GZIPFilter extends MyFilter {

    private static final String VARY_HEADER_PARAM = "varyHeader";
    private static final String RETURN_ON_NOT_OK_PARAM = "returnOnNonOK";

    private boolean setVaryHeader;
    private boolean returnOnNonOk = true;

    /**
     * Performs initialisation.
     * 
     * @param filterConfig
     */
    protected void doInit(FilterConfig filterConfig) throws Exception {
        String varyParam = filterConfig.getInitParameter(VARY_HEADER_PARAM);
        if (varyParam != null) {
            setVaryHeader = Boolean.valueOf(varyParam);
        }

        String returnOnNotOkParam = filterConfig.getInitParameter(RETURN_ON_NOT_OK_PARAM);
        if (returnOnNotOkParam != null) {
            returnOnNonOk = Boolean.valueOf(returnOnNotOkParam);
        }
    }

    /**
     * A template method that performs any Filter specific destruction tasks. Called from {@link #destroy()}
     */
    protected void doDestroy() {
        // noop
    }

    /**
     * Performs the filtering for a request.
     */
    protected void doFilter(final HttpServletRequest request, final HttpServletResponse response, final FilterChain chain) 
            throws Exception {
    	
    	String path = ((HttpServletRequest) request).getRequestURI();
    	
    	if(path.contains("css")){
    		chain.doFilter(request, response);
    	}
    	
        request.setCharacterEncoding(ENCODING);
        response.setContentType("text/html; charset="+ENCODING);
        response.setHeader("Content-Encoding", ENCODING);
        	
        if (!isIncluded(request) && acceptsEncoding(request, "gzip") && !response.isCommitted()) {
            // Client accepts zipped content

            // Create a gzip stream
            final ByteArrayOutputStream compressed = new ByteArrayOutputStream();
            final GZIPOutputStream gzout = new GZIPOutputStream(compressed);

            // Handle the request
            final GenericResponseWrapper wrapper = new GenericResponseWrapper(response, gzout);
            chain.doFilter(request, wrapper);
            wrapper.flush();

            gzout.close();

            // double check one more time before writing out
            // repsonse might have been committed due to error
            if (response.isCommitted()) {
                return;
            }
            
            // return on these special cases when content is empty or unchanged
            switch (wrapper.getStatus()) {
            case HttpServletResponse.SC_NO_CONTENT:
            case HttpServletResponse.SC_RESET_CONTENT:
            case HttpServletResponse.SC_NOT_MODIFIED:
                return;
            default:
            }
            response.setContentType("text/html; charset="+ENCODING);  
            response.setCharacterEncoding(ENCODING);
            request.setCharacterEncoding(ENCODING);

            // Saneness checks
            byte[] compressedBytes = compressed.toByteArray();
            boolean shouldGzippedBodyBeZero = ResponseUtil.shouldGzippedBodyBeZero(compressedBytes, request);
            boolean shouldBodyBeZero = ResponseUtil.shouldBodyBeZero(request, wrapper.getStatus());
            if (shouldGzippedBodyBeZero || shouldBodyBeZero) {
                // No reason to add GZIP headers or write body if no content was written or status code specifies no
                // content
                response.setContentLength(0);
                return;
            }
            
            response.setCharacterEncoding(ENCODING);
            request.setCharacterEncoding(ENCODING);

            // Write the zipped body
            ResponseUtil.addGzipHeader(response);

            // Only write out header Vary as needed
//            if (setVaryHeader) {
               
//            }

            response.setContentLength(compressedBytes.length);
            
            response.getOutputStream().write(compressedBytes);

        } else {
            // Client does not accept zipped content - don't bother zipping
            chain.doFilter(request, response);
        }
    }

    /**
     * Checks if the request uri is an include. These cannot be gzipped.
     */
    private boolean isIncluded(final HttpServletRequest request) {
        final String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
        final boolean includeRequest = !(uri == null);

        return includeRequest;
    }

    /**
     * Determine whether the user agent accepts GZIP encoding. This feature is part of HTTP1.1. If a browser accepts
     * GZIP encoding it will advertise this by including in its HTTP header:
     * <p/>
     * <code>
     * Accept-Encoding: gzip
     * </code>
     * <p/>
     * Requests which do not accept GZIP encoding fall into the following categories:
     * <ul>
     * <li>Old browsers, notably IE 5 on Macintosh.
     * <li>Internet Explorer through a proxy. By default HTTP1.1 is enabled but disabled when going through a proxy. 90%
     * of non gzip requests seen on the Internet are caused by this.
     * </ul>
     * As of September 2004, about 34% of Internet requests do not accept GZIP encoding.
     * 
     * @param request
     * @return true, if the User Agent request accepts GZIP encoding
     */
    protected boolean acceptsGzipEncoding(HttpServletRequest request) {
        return acceptsEncoding(request, "gzip");
    }

	
}