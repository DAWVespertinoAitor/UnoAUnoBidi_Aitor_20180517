package es.albarregas.daofactory;


import es.albarregas.dao.PaisDAO;
import es.albarregas.dao.IPaisDAO;
import es.albarregas.dao.IPresidenteDAO;
import es.albarregas.dao.PresidenteDAO;


public class MySQLDAOFactory extends DAOFactory{

    @Override
    public IPaisDAO getPaisDAO() {
        return new PaisDAO();
    }
    @Override
    public IPresidenteDAO getPresidenteDAO() {
        return new PresidenteDAO();
    }

}
