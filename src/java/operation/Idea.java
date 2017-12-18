/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation;

import dao.IdeaDao;
import machine.Machine;
import operation.Operation;

/**
 *
 * @author 50879
 */
public class Idea extends Operation {

    IdeaDao ideaDao = new IdeaDao();

    @Override
    public String doOperation(Machine machine) {
        if (machine.state == 1) {
            machine.state = 2;
        } else {
            String content = "";
            content = machine.natrualWords;
            machine.result = ideaDao.submitIdea(content);
            machine.state = 1;
            machine.operationString = "";
            machine.natrualWords = "";
        }
        return "";
    }

}
