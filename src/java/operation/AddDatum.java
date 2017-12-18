/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation;

import dao.DatumDao;
import machine.Machine;
import po.Datum;

/**
 *
 * @author Administrator
 */
public class AddDatum extends Operation {

    @Override
    public String doOperation(Machine machine) {
        DatumDao datumDao = new DatumDao();
        System.out.println(datumDao);
        String str[] = machine.operationString.split(" ");
        System.out.println(str.length);
        if (str.length <= 3) {
            machine.result = "请输入新增警员的信息(警号、姓名、性别、年龄中间请用空格格开):";
            machine.state = 2;

        } else {
            System.out.println(str[1]);
            if (datumDao.findByNum(str[1]) == null) {
                Datum datum=new Datum();
                datum.setNum(str[1]);
                datum.setName(str[2]);
                datum.setSex(str[3]);
                datum.setAge(Integer.valueOf(str[4]));
                datum.setScore(100f);
                datumDao.add(datum);
                machine.result = "添加成功！";
            } else {
                machine.result = "警号已使用！";
            }
            machine.state = 1;
        }
        return "";
    }

}
