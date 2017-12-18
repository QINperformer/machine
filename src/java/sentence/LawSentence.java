/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentence;

import dao.LawDao;
import machine.Machine;
import po.PublicLaw;

/**
 *
 * @author 50879
 */
public class LawSentence extends Sentence{
    
    private LawDao law=new LawDao();
    
    @Override
    public void toOperationString(Machine machine) {
        PublicLaw  plaw=law.findContent(this.getSentence());
        String content="law";
        if(plaw!=null){
            content+=" ";
            content+=plaw.getContent();
        }
        machine.operationString=content;
    }
    
}
