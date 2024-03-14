package com.example.shopping.Repository;

import com.example.shopping.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Locale;

public interface CategoryRepository extends JpaRepository <Category,Integer >{
}
