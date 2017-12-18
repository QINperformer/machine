/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentence;

import java.util.List;

//表示一个自然语言句子

public abstract class Sentence {
    
    //句子
    private String sentence;
    
   
    
    //把句子转换到表达式
    public abstract void toOperationString(machine.Machine machine);

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
    
}
