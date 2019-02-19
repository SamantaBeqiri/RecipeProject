package com.project.dao.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.stereotype.Repository;

import com.project.Entity.User;
import com.project.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

	//private static final Logger logger = Logger.getLogger(UserDaoImpl.class);
	@PersistenceContext
	private EntityManager entityManager;

	public boolean save(User user) {
		try {
		//	logger.debug("Creating User");
			entityManager.persist(user);
			//logger.debug("user created succesfuly");
			return true;
		} catch (Exception e) {
			//logger.error("Error saving user " + e.getMessage());
			return false;
		}
	}

	public boolean update(User user) {
		try {
			//logger.debug("updating user " + user.getUsername());
			entityManager.merge(user);
			//logger.debug("user updated succesfuly ");
			return true;
		} catch (Exception e) {
		//	logger.error("Error updating user: " + e.getMessage());
			return false;
		}

	}

	public User findUserByUsPass(String username, String password) {
		try {
			//logger.debug("finding the user");
			String queryString="FROM User user WHERE user.username=?1 ";
			User user=entityManager.createQuery(queryString,User.class).setParameter(1,username)
					.getSingleResult();
			BasicPasswordEncryptor encryptor=new BasicPasswordEncryptor();
			if(encryptor.checkPassword(password, user.getPassword())) {
				//logger.debug("User exists");
				return user;
			}else {
				//logger.debug("user dont exists");
				return null;
			}
		}catch(Exception e) {
			//logger.error("error finding user: "+e.getMessage());
			return null;
		}
		
	}

	public User findUserByUsEmail(String username, String email) {
		try {
			//logger.debug("finding user by username");
			String queryString=("FROM User user where user.username=?1 and user.email=?2");
					User user=entityManager.createQuery(queryString,User.class).setParameter(1, username)
					.setParameter(2, email).getSingleResult();
					return user;
		}catch(Exception e ) {
			//logger.error("error finding user"+e.getMessage());
			return null;
		}
	}

	public boolean updatePassword(String password, int userId) {
		/*try {
			logger.debug("updating menager for user with id" +userId);
			BasicPasswordEncryptor encryptor =new BasicPasswordEncryptor();
			password=encryptor.encryptPassword(password);
			String queryString="Update User user set user.password=:password where user.id=:id")
		}*/
		return false;
	}

}
