package com.learn.pro1.repository;

import com.learn.pro1.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;


@Repository
public interface CategoryRepository extends JpaRepository<Category , Long> {


}
