package sentence;

import java.util.List;



public class MaxSentence extends Sentence {
    @Override
    public void toOperationString(machine.Machine machine) {
        String sentence = this.getSentence();
        //提取句子里面的所有数字
        List<String> string = util.StringUtil.getNumInString(sentence);
        String rString = "max %s %s";
        if (string.size() != 2) {
            //参数不够
            machine.state = 2;
            rString = "max";
            machine.operationString=rString;
        } else {
            machine.operationString = String.format(rString, string.get(0), string.get(1));
        }        
    }
}
