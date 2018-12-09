package sn.objis.proxibanquev3.services;

import sn.objis.proxibanquev3.entities.Employe;
import sn.objis.proxibanquev3.entities.User;

public interface IUserService {
         public void createUser(User user);
         public Employe empConnecter(String username);
}
