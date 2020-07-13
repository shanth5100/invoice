package com.invoice.api.util.dao.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.invoice.api.util.dao.beans.field.Password;

@Entity
@Table(name = "user")
public class User extends Password{

}
