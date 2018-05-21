package es.albarregas.controllers;


import es.albarregas.beans.Pais;
import es.albarregas.beans.Presidente;
import es.albarregas.daofactory.DAOFactory;
import es.albarregas.dao.IPaisDAO;
import es.albarregas.dao.IPresidenteDAO;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author Jesus
 */
@WebServlet(name = "Controlador", urlPatterns = {"/control"})
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAOFactory daof = DAOFactory.getDAOFactory();
        IPaisDAO pdao = daof.getPaisDAO();
        IPresidenteDAO prdao = daof.getPresidenteDAO();
//        IGenericoDAO gdao = daof.getGenericoDAO();
        Pais pais = new Pais();
        Presidente presidente = new Presidente();
        String url = null;
        switch (request.getParameter("op")) {
            case "addPais":

                try {
                    BeanUtils.populate(pais, request.getParameterMap());
                    BeanUtils.populate(presidente, request.getParameterMap());
                    pais.setPresidente(presidente);
                    presidente.setPais(pais);

                } catch (IllegalAccessException | InvocationTargetException ex) {
                    ex.printStackTrace();
                }
                pdao.add(pais);
                url = "index.html";
                break;
            case "addPresi":

                try {
                    BeanUtils.populate(pais, request.getParameterMap());
                    BeanUtils.populate(presidente, request.getParameterMap());
                    presidente.setPais(pais);

                } catch (IllegalAccessException | InvocationTargetException ex) {
                    ex.printStackTrace();
                }
                prdao.add(presidente);
                url = "index.html";
                break;
            case "deletePais":
//                profesor = adao.getOne(Integer.parseInt(request.getParameter("registro")));
//                adao.delete(profesor);
                pais = pdao.getOne(Integer.parseInt(request.getParameter("registro")));
                pdao.delete(pais);
                url = "index.html";
                break;
            case "deletePresi":
//                profesor = adao.getOne(Integer.parseInt(request.getParameter("registro")));
//                adao.delete(profesor);
                presidente = prdao.getOne(Integer.parseInt(request.getParameter("registro")));
                prdao.delete(presidente);
                url = "index.html";
                break;
            case "updatePais":
                pais = pdao.getOne(Integer.parseInt(request.getParameter("registro")));
                request.setAttribute("pais", pais);
                url = "JSP/Pais/formularioActualizar.jsp";
                break;
            case "updatePresi":
                presidente = prdao.getOne(Integer.parseInt(request.getParameter("registro")));
                request.setAttribute("presidente", presidente);
                url = "JSP/Presidente/formularioActualizar.jsp";
                break;
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
