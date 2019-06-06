package controleur;

import model.*;
import java.sql.*;
import java.util.ArrayList;

public abstract class DAO<T> 
{
  protected Connexion con;
  
  public DAO(Connexion m_con)
  {
	  this.con=m_con;
  }
  
  public abstract void create(T obj);

  /**
  * M�thode pour effacer
  * @param obj
  * @return boolean 
  */
  public abstract void delete(T obj);

  /**
  * M�thode de mise � jour
  * @param obj
  * @return boolean
  */
  public abstract void update(T obj);

  /**
  * M�thode de recherche des informations
  * @param id
  * @return T
  */
  public abstract T find(int id);
  
  
  public abstract ArrayList seeAll();

}
  

