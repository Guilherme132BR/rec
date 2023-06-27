package dao;

import java.util.List;

 

/**
 *
 * @author u09464273135
 */
        
        //DAO abstract serve como esqueleto para as outras classes
public abstract class DAO_Abstract {

    
    public abstract void insert(Object object);
    public abstract void update(Object object);
    public abstract void delete(Object object);
    public abstract Object list(int id);
    public abstract List listAll();
    
       
    }