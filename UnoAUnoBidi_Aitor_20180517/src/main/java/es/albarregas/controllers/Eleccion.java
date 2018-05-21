/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;


import es.albarregas.beans.Pais;
import es.albarregas.beans.Presidente;
import es.albarregas.daofactory.DAOFactory;
import es.albarregas.dao.IPaisDAO;
import es.albarregas.dao.IPresidenteDAO;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jesus
 */
@WebServlet(name = "Eleccion", urlPatterns = {"/eleccion"})
public class Eleccion extends HttpServlet {

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
        String url = null;
        int contador= 0;
        DAOFactory daof = DAOFactory.getDAOFactory();
//        IGenericoDAO gdao = daof.getGenericoDAO();
        IPaisDAO pdao = daof.getPaisDAO();
        IPresidenteDAO prdao = daof.getPresidenteDAO();
        switch(request.getParameter("op")){
            case "addPais":
                url = "JSP/Pais/formularioAlta.jsp";
                break;
            case "addPresi":
                url = "JSP/Presidente/formularioAlta.jsp";
                break;
            case "delete":
            case "update":
            case "list":
                
                contador = contador + contador;
//                String entidad = "Profesor";
////                List<Profesor> listaProf = pdao.get(); //new ArrayList<>();
////                System.out.println(listaProf.size());
//                List<Object> lista = pdao.get(entidad);
//                for(Object profesor : lista){
//                    listaProf.add((Profesor)profesor);
//                }
//                listaProf = pdao.get();
////                request.setAttribute("listado", listaProf);
            break;
            case "listPais":
                url = "JSP/Pais/listado.jsp";
                contador = contador + contador;
                List<Pais> listaPais = pdao.get();
                request.setAttribute("listadoPaises", listaPais);
            break;
            case "listPresi":
                url = "JSP/Presidente/listado.jsp";
                contador = contador + contador;
                List<Presidente> listaPresi = prdao.get();
                request.setAttribute("listadoPresi", listaPresi);
            break;
            
        }
        switch(request.getParameter("op")){
            case "deletePais":
                url = "JSP/Pais/borrado.jsp";
                List<Pais> listaPais = pdao.get();
                request.setAttribute("listadoPaises", listaPais);
                break;
            case "deletePresi":
                url = "JSP/Presidente/borrado.jsp";
                List<Presidente> listaPresi = prdao.get();
                request.setAttribute("listadoPresi", listaPresi);
                break;
            case "updatePais":
                listaPais = pdao.get();
                request.setAttribute("listadoPaises", listaPais);
                url = "JSP/Pais/actual.jsp";
                break;
            case "updatePresi":
                listaPresi = prdao.get();
                request.setAttribute("listadoPresi", listaPresi);
                url = "JSP/Presidente/actual.jsp";
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
