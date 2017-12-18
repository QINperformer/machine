/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation;

import machine.Machine;

/**
 *
 * @author Administrator
 */
public class Sub extends Operation{

    @Override
    public String doOperation(Machine machine) {
         String str[] = machine.operationString.split(" ");
        if (str.length <= 2) {
            machine.result="请输入两个参数：";
            machine.state=2;
            
        }else{
            machine.result="减加结果是："+(Integer.valueOf(str[1])-Integer.valueOf(str[2]));
            machine.state=1;
        }
        return "";
    }
    
}
