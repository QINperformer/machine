package sentence;

import dao.EquipDao;
import machine.Machine;
import po.PublicEquip;

public class EquipSentence extends Sentence {

    EquipDao equipDao = new EquipDao();

    @Override
    public void toOperationString(Machine machine) {
        String sentence = this.getSentence();
        PublicEquip publicEquip = equipDao.match(sentence);
        String rString = "publicEquip %s";
        if (publicEquip == null) {
            rString = "publicEquip";
            machine.operationString = rString;
        } else {
            machine.operationString = String.format(rString, publicEquip.getEquipName());
        }
    }

}
