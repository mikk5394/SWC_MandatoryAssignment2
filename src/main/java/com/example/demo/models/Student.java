package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "StudentTable")
public class Student extends User {
}
