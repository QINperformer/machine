/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentence;

import dao.DatumDao;
import java.util.List;
import machine.Machine;
import po.Datum;

/**
 *
 * @author Administrator
 */
public class FindDatumSentence extends Sentence{

    @Override
    public void toOperationString(Machine machine) {
       String sentence = this.getSentence();
        DatumDao datumDao=new DatumDao();
        //匹配自然语言中是否有警号
        Datum datum = datumDao.match(sentence);
        String rString = "finddatum %s";
        if (datum==null) {
            //参数不够
            rString = "finddatum";
            machine.operationString = rString;
        } else {
            machine.operationString = String.format(rString, datum.getNum());
        }
    }
    
}
