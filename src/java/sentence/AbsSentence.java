/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentence;

import java.util.List;


public class AbsSentence extends Sentence{

    @Override
    public void toOperationString(machine.Machine machine) {
        String sentence = this.getSentence();
        //提取句子里面的所有数字
        List<String> string = util.StringUtil.getNumInString(sentence);
        String rString = "abs %s";
        if (string.size() != 1) {
            //参数不够
            rString = "abs";
            machine.operationString = rString;
        } else {
            machine.operationString = String.format(rString, string.get(0));
        }
    }
    
}
