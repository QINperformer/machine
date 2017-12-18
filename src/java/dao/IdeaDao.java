/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.SessionFactoryUtil;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import po.Idea;

/**
 *
 * @author 50879
 */
public class IdeaDao {
    private SessionFactory sessionFactory=SessionFactoryUtil.sessionFactory;


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public String submitIdea(String content){
        Idea idea=new Idea();
        idea.setIdeamessage(content);
        idea.setIdeaTime(new Date());
        try(Session session=this.getSessionFactory().openSession()) {
            session.save(idea);
            session.clear();
            session.close();
        }
        return "你的意见已提交，感谢你对我院美好的明天提出了宝贵的意见！";
    }
}
