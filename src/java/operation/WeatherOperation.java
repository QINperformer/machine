package operation;

import dao.WeatherDao;

import po.Weather;

public class WeatherOperation extends Operation {

    WeatherDao weatherDao=new WeatherDao();

    @Override
    public String doOperation(machine.Machine machine) {
        String str[] = machine.operationString.split(" ");
        if (str.length <= 1) {
            machine.result = "请输入城市：";
            machine.state = 2;

        } else {
            Weather weather = weatherDao.findByCity(str[1]);
            machine.result = weather.getCity()+"的天气是："+weather.getSituation();
            machine.state = 1;
        }
        return "";
    }

}
