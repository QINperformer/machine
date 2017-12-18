/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentence;

import java.util.List;
import machine.Machine;

/**
 *
 * @author Administrator
 */
public class SubSentence extends Sentence{

    @Override
    public void toOperationString(Machine machine) {
        String sentence = this.getSentence();
        List<String> string = util.StringUtil.getNumInString(sentence);
        String rString = "sub %s %s";
        if (string.size()!=2) {
            rString = "sub";
            machine.operationString = rString;
        } else {
            machine.operationString = String.format(rString, string.get(0), string.get(1));
        }
    }
    
}
