package sentence;

import dao.WeatherDao;

import po.Weather;


public class WeatherSentence extends Sentence {

  
    WeatherDao weatherDao = new WeatherDao();

    @Override
    public void toOperationString(machine.Machine machine) {
        System.out.println(machine.natrualWords);
        //获取自然语言：北京的天气
        String sentence = this.getSentence();
        //数据库匹配城市
        Weather weather = weatherDao.match(sentence);
        String rString = "weather %s";
        if (weather==null) {
            rString = "weather";
            machine.operationString = rString;
        } else {
            machine.operationString = String.format(rString,weather.getCity());
        }
    }

}
