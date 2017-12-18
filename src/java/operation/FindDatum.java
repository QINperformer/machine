/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation;

import dao.DatumDao;
import machine.Machine;

/**
 *
 * @author Administrator
 */
public class FindDatum extends Operation {

    @Override
    public String doOperation(Machine machine) {
        DatumDao datumDao = new DatumDao();
        System.out.println(datumDao);
        String str[] = machine.operationString.split(" ");
        if (str.length <= 1) {
            machine.result = "请输入查找警员的警号:";
            machine.state = 2;

        } else {
            if (datumDao.findByNum(str[1]) != null) {
                String num = datumDao.findByNum(str[1]).getNum();
                String name = datumDao.findByNum(str[1]).getName();
                String sex = datumDao.findByNum(str[1]).getSex();
                int age = datumDao.findByNum(str[1]).getAge();
                float score = datumDao.findByNum(str[1]).getScore();
                machine.result = "警号："+num+" "+"姓名："+name+" "+"性别："+sex+" "+"年龄："+age+" "+"学分:"+score+"";

            } else {
                machine.result = "警号错误";
            }
            machine.state = 1;

        }

        return "";
    }

}
