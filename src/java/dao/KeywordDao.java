package dao;

import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import po.Keyword;


public class KeywordDao {


    private SessionFactory sessionFactory=SessionFactoryUtil.sessionFactory;


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private List<Keyword> findAll() {
        String sql = "select * from keyword";
        List<Keyword> listKeywords;
        try (Session session = this.sessionFactory.openSession()) {
            listKeywords = session.createNativeQuery(sql, Keyword.class).list();
            for (Keyword keyword : listKeywords) {
                
                String a = keyword.getOperation().getSentenceClass();
                System.out.println(a);
                
            }
        }
        return listKeywords;
    }

    //根据自然语言匹配返回自然语言中的关键字
    public Keyword getKeyWordByNatrualWords(String natrualWords) {
        List<Keyword> listKeywords = this.findAll();
        System.out.println("KeywordDao.listKeywords.size="+listKeywords.size());
        for (Keyword keyword : listKeywords) {
            if (natrualWords.contains(keyword.getWord())) {
                System.out.println("KeywordDao.keyword.word:"+keyword.getWord());
                return keyword;
            }
        }
        return null;
    }

}
