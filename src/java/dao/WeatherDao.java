package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;



public class WeatherDao {


    private SessionFactory sessionFactory=SessionFactoryUtil.sessionFactory;

    private List<po.Weather> findAll() {
        String sql = "select * from weather";
        List<po.Weather> listWeather;
        try (Session session = this.sessionFactory.openSession()) {
            listWeather = session.createNativeQuery(sql, po.Weather.class).list();
        }
        return listWeather;
    }

    public po.Weather findByCity(String city) {
        String sql = "select * from weather where city='%s'";
        sql = String.format(sql, city);
        List<po.Weather> listWeather;
        try (Session session = this.sessionFactory.openSession()) {
            listWeather = session.createNativeQuery(sql, po.Weather.class).list();
        }
        return listWeather.get(0);
    }

    //根据自然语言匹配关键字
    public po.Weather match(String str) {
        List<po.Weather> listWeather = this.findAll();
        for (po.Weather weather : listWeather) {
            System.out.println(weather.getCity());
            if (str.contains(weather.getCity())) {

                return weather;
            }
        }
        return null;
    }
}
