/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation;

import dao.LawDao;
import machine.Machine;
import po.PublicLaw;

/**
 *
 * @author 50879
 */
public class Law extends Operation{
    
    LawDao law=new LawDao();
    
    @Override
    public String doOperation(Machine machine) {
        String[] details=machine.operationString.split(" ");
        if(details.length<=1){
            machine.result="请输入你想要查询的人民警察法";
            machine.state=2;
        }else if(details.length==2&&machine.state==1){
            machine.result=details[1];
            machine.state=1;
            machine.operationString="";
            machine.currentKeyword=null;
        }else{
            PublicLaw plaw=law.findContent(machine.operationString);
            machine.result=plaw.getContent();
            machine.state=1;
            machine.operationString="";
            machine.currentKeyword=null;
        }
        return "";
    }
    
}
