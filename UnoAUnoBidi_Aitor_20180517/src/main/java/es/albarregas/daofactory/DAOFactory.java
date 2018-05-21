package es.albarregas.daofactory;


import es.albarregas.dao.IPaisDAO;
import es.albarregas.dao.IPresidenteDAO;

public abstract class DAOFactory {

    

    public abstract IPaisDAO getPaisDAO();
    public abstract IPresidenteDAO getPresidenteDAO();
    

    public static DAOFactory getDAOFactory() {
        DAOFactory daof = null;

        daof = new MySQLDAOFactory();

        return daof;
    }

}
