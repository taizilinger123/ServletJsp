package org.tarena.dao;

import org.tarena.entity.User;

public interface UserDao {
   public User findByName(String name);
}
