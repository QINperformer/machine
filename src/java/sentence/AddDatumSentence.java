/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentence;

import machine.Machine;

/**
 *
 * @author Administrator
 */
public class AddDatumSentence extends Sentence {

    @Override
    public void toOperationString(Machine machine) {
        String str[] = machine.operationString.split(" ");
        String rString = "adddatum %s %s %s %s";
        if (str.length != 5) {
            //参数不够
            rString = "adddatum";
            machine.operationString = rString;
        } else {
            machine.operationString = String.format(rString,str[1],str[2],str[3],str[4]);
        }
    }

}
