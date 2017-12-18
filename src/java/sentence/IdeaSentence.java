/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentence;

import machine.Machine;
import sentence.Sentence;

/**
 *
 * @author 50879
 */
public class IdeaSentence extends Sentence{

    @Override
    public void toOperationString(Machine machine) {
        machine.result="请写下你的宝贵意见：";
    }
    
}
