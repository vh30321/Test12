/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejb.ClientTable;
import ejb.ClientTableFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.Controller;

/**
 *
 * @author admin
 */
public class ClientServlet extends HttpServlet {

    @EJB
    private ClientTableFacade clientTableFacade;

    private HttpServletRequest request;
    private HttpServletResponse response;

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
        response.setContentType("text/html;charset=UTF-8");
        this.request = request;
        this.response = response;

        Controller.invokeMethods(this, request, response);
    }

    public void addClientView() {
        try {
            request.getRequestDispatcher("Client/AddClient.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addClient() {
        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String email = request.getParameter("email");
            String birthday = request.getParameter("birthday");
            int tel = Integer.parseInt(request.getParameter("tel"));
            SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd");
            ClientTable client = new ClientTable();
            try {
                Date date = dt.parse(birthday);
                client.setName(name);
                client.setSurname(surname);
                client.setEmail(email);
                client.setTel(tel);
                client.setBirthday(date);
                client.setStatus((short) 1);
                boolean res = clientTableFacade.addClient(client);
                if (res) {
                    out.print("success");
                } else {
                    out.print("error");
                }

            } catch (ParseException ex) {
                Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (IOException ex) {
            Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void clientListView() {
        try {
            List<ClientTable> clientsList = clientTableFacade.findAll();
            request.setAttribute("clientsList", clientsList);
            request.getRequestDispatcher("Client/ClientsList.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editClient() {
        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String email = request.getParameter("email");
            String birthday = request.getParameter("birthday");
            int tel = Integer.parseInt(request.getParameter("tel"));

            SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd");
            System.out.print(request.getParameter("id"));
                Date date = dt.parse(birthday);
                int id = Integer.parseInt(request.getParameter("id"));
                
                ClientTable client = clientTableFacade.find(id);
                client.setName(name);
                client.setSurname(surname);
                client.setEmail(email);
                client.setBirthday(date);
                client.setTel(tel);
                boolean res = clientTableFacade.editClient(client);
                if (res) {
                    out.print("success");
                } else {
                    out.print("error");
                }
            } catch (ParseException ex) {
                Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

         catch (IOException ex) {
            Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteClient() {
        try (PrintWriter out = response.getWriter()) {
            int clientId = Integer.parseInt(request.getParameter("id"));
            ClientTable client = clientTableFacade.find(clientId);
            boolean res = clientTableFacade.deleteClient(client);

            if (res) {
                out.print("success");
            } else {
                out.print("error");
            }

        } catch (IOException ex) {
            Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editClientView() {
        try {
            int clientId = Integer.parseInt(request.getParameter("id"));
            ClientTable client = clientTableFacade.find(clientId);
            request.setAttribute("client", client);
            request.getRequestDispatcher("Client/EditClient.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
