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
public class DeleteDatum extends Operation {

    @Override
    public String doOperation(Machine machine) {
        DatumDao datumDao = new DatumDao();
        System.out.println(datumDao);
        String str[] = machine.operationString.split(" ");
        if (str.length <= 1) {
            machine.result = "请输入删除警员的警号:";
            machine.state = 2;
        } else {
            if (datumDao.findByNum(str[1])!=null) {
                datumDao.DeleteByNum(str[1]);
                machine.result = "删除成功";
            } else {
                machine.result = "删除失败！警号错误";
            }
            machine.state = 1;
        }
        return "";
    }

}
