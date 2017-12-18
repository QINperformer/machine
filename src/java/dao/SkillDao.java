package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import po.PublicSkill;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class SkillDao {

    private SessionFactory sessionFactory = SessionFactoryUtil.sessionFactory;

    //根据自然语言匹配关键字
    public po.PublicSkill match(String str) {
        Session session = sessionFactory.openSession();
        List<PublicSkill> list = session.createNativeQuery("select * from public_skill", po.PublicSkill.class).list();
        for (int i = 0; i < list.size(); i++) {
            if (str.contains(list.get(i).getSkillName())) {
                session.close();
                return list.get(i);
            }
        }
        return null;
    }

    public po.PublicSkill findBySkillName(String skillName) {
        Session session = sessionFactory.openSession();
        List<PublicSkill> list = session.createNativeQuery("select * from public_skill where skill_name='" + skillName + "'", po.PublicSkill.class).list();
        session.close();
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }
}
