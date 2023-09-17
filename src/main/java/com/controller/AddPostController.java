package com.controller;

import com.config.HibernateUtil;
import com.dto.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddPostController {


    @GetMapping("/add")
    private ModelAndView getAddPost(@ModelAttribute("post") Post post) {
        return new ModelAndView("addPost");

    }

    @PostMapping("/add")
    private String doAddPost(@ModelAttribute("post") Post post) {
        String title = post.getTitle();
        String imgUrl = post.getImgUrl();
        String description = post.getDescription();
        Post myPost = new Post();
        myPost.setTitle(title);
        myPost.setImgUrl(imgUrl);
        myPost.setDescription(description);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction;
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.persist(myPost);
        transaction.commit();
        session.close();

        return "redirect:/welcome";

    }
}
