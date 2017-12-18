/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentence;

import java.util.List;


public class AddSentence extends Sentence {

    @Override
    public void toOperationString(machine.Machine machine) {
        String sentence = this.getSentence();
        //提取句子里面的所有数字
        List<String> string = util.StringUtil.getNumInString(sentence);
        String rString = "add %s %s";
        if (string.size() != 2) {
            //参数不够
            machine.state = 2;
            rString = "add";
            System.out.println("AddSentence.sString=" + rString);
            machine.operationString = rString;
        } else {
            System.out.println("AddSentence.sString=" + String.format(rString, string.get(0), string.get(1)));
            machine.operationString = String.format(rString, string.get(0), string.get(1));
        }
    }

}
