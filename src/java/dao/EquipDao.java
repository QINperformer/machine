package dao;

import java.util.List;
import operation.Equip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import po.PublicEquip;

public class EquipDao {

    private SessionFactory sessionFactory = SessionFactoryUtil.sessionFactory;

    public List<PublicEquip> findAll() {
        String sql = "select * from public_equip";
        List<PublicEquip> listPublicEquip;
        try (Session session = this.sessionFactory.openSession()) {
            listPublicEquip = session.createNativeQuery(sql, po.PublicEquip.class).list();
        }
        return listPublicEquip;
    }

    public PublicEquip findByEquip(String equip_name) {
        String sql = "select * from public_equip where equip_name='%s'";
        sql = String.format(sql, equip_name);
        List<PublicEquip> listPublicEquip;
        try (Session session = this.sessionFactory.openSession()) {
            listPublicEquip = session.createNativeQuery(sql, po.PublicEquip.class).list();
        }
        return listPublicEquip.get(0);
    }

    //匹配关键字
    public po.PublicEquip match(String str) {
        List<po.PublicEquip> listPublicEquip = this.findAll();
        for (PublicEquip publicEquip : listPublicEquip) {
            System.out.println(publicEquip.getEquipName());
            if (str.contains(publicEquip.getEquipName())) {
                return publicEquip;
            }
        }
        return null;
    }
}
