package com.invoice.api.util.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.invoice.api.util.dao.beans.User;
import com.invoice.api.util.req.UserReq;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

}
