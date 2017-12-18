/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import po.PublicLaw;

/**
 *
 * @author 50879
 */
public class LawDao {
    private SessionFactory sessionFactory=SessionFactoryUtil.sessionFactory;


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public List<PublicLaw> findAll(){
        List<PublicLaw> list;
        String sql="SELECT * FROM machine.public_law";
        try(Session session=this.getSessionFactory().openSession()){
            list=session.createNativeQuery(sql, PublicLaw.class).list();
        }
        return list;
    }
    
    public PublicLaw findContent(String content){
        List<PublicLaw> list=this.findAll();
        if(content.contains("关于")){
            for(PublicLaw law:list){
                if(content.contains(law.getGenre())){
                    return law;
                }
            }
        }else if(content.contains("条")){
            for(PublicLaw law:list){
                if(content.contains(law.getStrip())){
                    System.out.print(law.getContent());
                    return law;
                }
            }
        }
            return null;
    }
}
